package springTest.springMVC.controllerSupport;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import springTest.springMVC.datatypes.JavaClassStruct;

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

public class XMLGenerator {
    String className;
    String parentClass;
    List<String> interfaces;
    String description;
    List<JavaClassStruct.Method> methodList;
    List<JavaClassStruct.Property> propertyList;

    JavaClassStruct jcs;



    public XMLGenerator(JavaClassStruct jcs, String xmlPath){
        this.jcs = jcs;
        className = jcs.getName();
        parentClass = jcs.getParentClass();
        interfaces = jcs.getInterfaces();
        description = jcs.getDescription();
        methodList = jcs.getMethodList();
        propertyList = jcs.getPropertyList();

        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //========================================================


            Element root = document.createElement("class");
            document.appendChild(root);

            //Name
            Element classNameNode = document.createElement("className");
            classNameNode.appendChild(document.createTextNode(className));
            root.appendChild(classNameNode);

            //Parent
            Element parentNode = document.createElement("parent");
            parentNode.appendChild(document.createTextNode(parentClass));
            root.appendChild(parentNode);

            //Interfaces
            Element interfaceNode = document.createElement("interfaces");
            root.appendChild(interfaceNode);
            for(int i = 0; i < interfaces.size(); i++){
                Element interfaceName = document.createElement("interfaceName");
                interfaceName.appendChild(document.createTextNode(interfaces.get(i)));
                interfaceNode.appendChild(interfaceName);
            }

            //Description
            Element descNode = document.createElement("description");
            descNode.appendChild(document.createTextNode(description));
            root.appendChild(descNode);

            //Methods
            Element methNode = document.createElement("methods");
            root.appendChild(methNode);

            for(int i = 0; i < methodList.size(); i++){
                //Parent
                Element methodNameNode = document.createElement("method");
                methNode.appendChild(methodNameNode);

                //Name
                Element methodName = document.createElement("methodName");
                methodName.appendChild(document.createTextNode(methodList.get(i).getName()));
                methodNameNode.appendChild(methodName);

                //Description
                Element methodDesc = document.createElement("methodDescription");
                methodDesc.appendChild(document.createTextNode(methodList.get(i).getDescription()));
                methodNameNode.appendChild(methodDesc);

                //Example
                Element methodExample = document.createElement("methodUsage");
                methodExample.appendChild(document.createTextNode(methodList.get(i).getExample()));
                methodNameNode.appendChild(methodExample);

            }


            //Properties
            Element propertyNode = document.createElement("properties");
            root.appendChild(propertyNode);

            for(int i = 0; i < propertyList.size(); i++){
                //Parent
                Element propertyNameNode = document.createElement("property");
                propertyNode.appendChild(propertyNameNode);

                //Name
                Element propertyName = document.createElement("propertyName");
                propertyName.appendChild(document.createTextNode(propertyList.get(i).getName()));
                propertyNameNode.appendChild(propertyName);

                //Description
                Element propertyDesc = document.createElement("propertyDescription");
                propertyDesc.appendChild(document.createTextNode(propertyList.get(i).getDescription()));
                propertyNameNode.appendChild(propertyDesc);

                //Example
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

            System.out.println("XML created from class!!");
            //printData();

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe){
            tfe.printStackTrace();
        }
    }

    private void printData(){
        System.out.println("==================PRINT DATA==================");

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


    }
}
