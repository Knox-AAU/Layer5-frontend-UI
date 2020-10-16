package springTest.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import springTest.springMVC.controllerSupport.FileManager;
import springTest.springMVC.datatypes.JavaClassStruct;
import springTest.springMVC.datatypes.frontendfile;
import springTest.springMVC.debug.ClassGenerator;
import springTest.springMVC.security.LoginValidator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("")
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHallo(ModelMap model){
        System.out.println("printHallo");

        List<frontendfile> list = new ArrayList<frontendfile>();
        list.add(new frontendfile("var", "login_page", frontendfile.FILETYPE.CSS));
        model.addAttribute("CSSFiles",list);
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String Login(@RequestParam String username,@RequestParam String password, ModelMap model) {
        System.out.println("Login");

        if (LoginValidator.ValidatLogin(username,password)){
            model.addAttribute("message","Hallso some Spring MVC Framework");
            return "main";
        } else {
            return "login";
        }

    }
    @RequestMapping(value = "/newclass", method = RequestMethod.GET)
    public String createNewClass(ModelMap model){
        System.out.println("createNewClass");


        new FileManager(model).AddCssFile("addclassform").finish();

        return "addclassform";
    }


    @RequestMapping(value = "/testclass", method = RequestMethod.GET)
    public ModelAndView ShowClass(){
        System.out.println("Show a Class");
        JavaClassStruct aclass = ClassGenerator.CreateJavaClassStruct();
        System.out.println(aclass.getName());

        ModelAndView modelAndView = new ModelAndView("classview");
        modelAndView.addObject("theClass", aclass);
        modelAndView.addObject("test","test");

        new FileManager(modelAndView.getModelMap()).AddCssFile("classview").finish();

        return modelAndView;
    }


    @RequestMapping(value = "/documentation", method = RequestMethod.GET)
    public ModelAndView ShowDocumentation() throws SAXException, IOException, ParserConfigurationException {
        System.out.println("Show doc");

        List<JavaClassStruct> jcsList = new ArrayList<>();

        //Store all the xml files in a list
        final File folder = new File("..\\..\\..\\layer5-frontend-ui\\KnoxWiki\\xml");
        List<File> files = new ArrayList<File>();
        for(File file : folder.listFiles()){
            if(file.isFile() && file.getName().endsWith(".xml")){
                files.add(file);
            }
        }

        //Access all files in the list
        for(int i = 0; i < files.size(); i++){
            System.out.println(files.get(i).getName());
            try {
                Scanner scanner = new Scanner(files.get(i));
                while(scanner.hasNextLine()){
                    String data = scanner.nextLine();
                    System.out.println(data);
                }
            } catch(FileNotFoundException e) {
                System.out.println(files.get(i) + ": File not found");
                e.printStackTrace();
            }
        }


        List<String> fileNames = new ArrayList<String>();
        for (int i = 0; i < files.size(); i++) {
            fileNames.add(files.get(i).getName());
        }

        //Kan man passe XML-filerne til JavaClassStructs-objekter og sende en liste af dem ind til viewet?

        //====

        for (File file:files) {
            JavaClassStruct jcs = new JavaClassStruct();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            Node node = doc.getFirstChild();
            Element e = (Element) node;

            Node nameNode = e.getElementsByTagName("className").item(0);
            String name = nameNode.getTextContent();
            jcs.setName(name);
            System.out.println("\nCurrent element class name: " + name);

            Node parentNode = e.getElementsByTagName("parent").item(0);
            String parent = parentNode.getTextContent();
            jcs.setParentClass(parent);
            System.out.println("Current element class parent: " + parent);

            Element interfaceNode = (Element)e.getElementsByTagName("interfaces").item(0);
            List<String> intrfcs = new ArrayList<>();
            NodeList interfacesNode =  interfaceNode.getElementsByTagName("interfaceName");
            for(int i = 0; i < interfacesNode.getLength(); i++){
                intrfcs.add(interfacesNode.item(i).getTextContent());
            }
            jcs.setInterfaces(intrfcs);
            for(int i = 0; i < intrfcs.size(); i++){
                System.out.println("INTERFACE: " + intrfcs.get(i));
            }

            Node descriptionNode = e.getElementsByTagName("description").item(0);
            String description = descriptionNode.getTextContent();
            jcs.setDescription(description);
            System.out.println("Current element class description: " + description);

            Element methodsNode = (Element)e.getElementsByTagName("methods").item(0);
            NodeList methods = methodsNode.getChildNodes();

            List<JavaClassStruct.Method> methodList = new ArrayList<>();
            for(int i = 0; i < methods.getLength(); i++){
                Element method = (Element) methods.item(i);
                Node methodNameNode = method.getElementsByTagName("methodName").item(0);
                String methodName = methodNameNode.getTextContent();
                System.out.println("methodname" + i + " " + methodName);

                Node methodDescriptionNode = method.getElementsByTagName("methodDescription").item(0);
                String methodDescription = methodDescriptionNode.getTextContent();
                System.out.println("methoddesc" + i + " " + methodDescription);

                Node methodUsageNode = method.getElementsByTagName("methodUsage").item(0);
                String methodUsage = methodUsageNode.getTextContent();
                System.out.println("methodusage" + i + " " + methodUsage);

                JavaClassStruct.Method meth = new JavaClassStruct.Method(methodName, methodDescription, methodUsage);
                methodList.add(meth);

            }
            jcs.setMethodList(methodList);

            jcsList.add(jcs);

        }






        ModelAndView modelAndView = new ModelAndView("documentation");
        modelAndView.addObject("jcsList", jcsList);

        // modelAndView.addObject("test","test");

        return modelAndView;
    }




}

