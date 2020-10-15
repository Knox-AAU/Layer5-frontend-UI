package springTest.springMVC.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import springTest.springMVC.datatypes.JavaClassStruct;
import springTest.springMVC.datatypes.TestAutoCreate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
public class RestAPI {
    String className;
    String parentClass;
    List<String> interfaces;
    String description;
    List<JavaClassStruct.Method> methodList;
    List<JavaClassStruct.Property> propertyList;

    String xmlPath = "C:\\Users\\teisv\\Documents\\Git\\Knox-frontend\\xmltestfile.xml";

    @PostMapping(value = "/test", consumes = "application/json")
    @ResponseBody
    public String testajax(@RequestBody String name) throws JsonProcessingException {
        System.out.println("testajax");
        //System.out.println(test.getName());


        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JavaClassStruct jcs = objectMapper.readValue(name, JavaClassStruct.class);

            className = jcs.getName();
            parentClass = jcs.getParentClass();
            interfaces = jcs.getInterfaces();
            description = jcs.getDescription();
            methodList = jcs.getMethodList();
            propertyList = jcs.getPropertyList();


            System.out.println("====================================");

            System.out.println("Name: " + jcs.getName());
            System.out.println("parentClass: " + jcs.getParentClass());
            System.out.println("interfaces: " + jcs.getInterfaces());
            System.out.println("Description: " + jcs.getDescription());

            for(int i = 0; i < jcs.getMethodList().size(); i++){
                System.out.println("MethodList: " + jcs.getMethodList().get(i).getName());
            }

            for(int i = 0; i < jcs.getPropertyList().size(); i++){
                System.out.println("PropertyList: " + jcs.getPropertyList().get(i).getName());
            }

            System.out.println("====================================");
            createXML();
        } catch(JsonProcessingException e){
            e.printStackTrace();
        }


        return "success";
    }

    private void createXML(){
        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //========================================================


            Element root = document.createElement("class");
            document.appendChild(root);

            Element classNameNode = document.createElement("className");
            classNameNode.appendChild(document.createTextNode(className));
            root.appendChild(classNameNode);


            Element parentNode = document.createElement("parent");
            parentNode.appendChild(document.createTextNode(parentClass));
            root.appendChild(parentNode);


            Element interfaceNode = document.createElement("interfaces");
            root.appendChild(interfaceNode);
            for(int i = 0; i < interfaces.size(); i++){
                Element interfaceName = document.createElement("interfaceName");
                interfaceName.appendChild(document.createTextNode(interfaces.get(i)));
                interfaceNode.appendChild(interfaceName);
            }

            Element descNode = document.createElement("description");
            descNode.appendChild(document.createTextNode(description));
            root.appendChild(descNode);

            Element methNode = document.createElement("methods");
            root.appendChild(methNode);

            for(int i = 0; i < methodList.size(); i++){
                Element methodNameNode = document.createElement(methodList.get(i).getName());
                //methodNameNode.appendChild(document.createTextNode(methodList.get(i).getName()));
                methNode.appendChild(methodNameNode);

                Element methodDesc = document.createElement("methodDescription");
                methodDesc.appendChild(document.createTextNode(methodList.get(i).getDescription()));
                methodNameNode.appendChild(methodDesc);

                Element methodExample = document.createElement("methodUsage");
                methodExample.appendChild(document.createTextNode(methodList.get(i).getExample()));
                methodNameNode.appendChild(methodExample);

            }

            Element propertyNode = document.createElement("properties");
            root.appendChild(propertyNode);

            for(int i = 0; i < propertyList.size(); i++){
                Element propertyNameNode = document.createElement(propertyList.get(i).getName());
                //methodNameNode.appendChild(document.createTextNode(methodList.get(i).getName()));
                propertyNode.appendChild(propertyNameNode);

                Element propertyDesc = document.createElement("propertyDescription");
                propertyDesc.appendChild(document.createTextNode(propertyList.get(i).getDescription()));
                propertyNameNode.appendChild(propertyDesc);

                Element propertyExample = document.createElement("propertyUsage");
                propertyExample.appendChild(document.createTextNode(propertyList.get(i).getExample()));
                propertyNameNode.appendChild(propertyExample);

            }

            //========================================================

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlPath));

            transformer.transform(domSource, streamResult);

            System.out.println("XML created!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe){
            tfe.printStackTrace();
        }
    }
}
