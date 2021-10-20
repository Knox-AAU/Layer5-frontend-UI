package springTest.springMVC.controllerSupport;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import springTest.springMVC.datatypes.JavaClassStruct;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class XMLLoader {
  public XMLLoader() {}

  public HashMap<String, JavaClassStruct> LoadXML()
      throws ParserConfigurationException, IOException, SAXException {

    HashMap<String, JavaClassStruct> jcsList = new HashMap<>();

    // Store all the xml files in a list
    final File folder = new File("..\\..\\..\\layer5-frontend-ui\\KnoxWiki\\xml");
    List<File> files = new ArrayList<File>();
    for (File file : folder.listFiles()) {
      if (file.isFile() && file.getName().endsWith(".xml")) {
        files.add(file);
      }
    }

    // Access all files in the list
    for (int i = 0; i < files.size(); i++) {
      System.out.println(files.get(i).getName());
      try {
        Scanner scanner = new Scanner(files.get(i));
        while (scanner.hasNextLine()) {
          String data = scanner.nextLine();
          System.out.println(data);
        }
      } catch (FileNotFoundException e) {
        System.out.println(files.get(i) + ": File not found");
        e.printStackTrace();
      }
    }

    List<String> fileNames = new ArrayList<String>();
    for (int i = 0; i < files.size(); i++) {
      fileNames.add(files.get(i).getName());
    }

    for (File file : files) {
      JavaClassStruct jcs = new JavaClassStruct();
      jcs.setFileName(file.getName());

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

      Element interfaceNode = (Element) e.getElementsByTagName("interfaces").item(0);
      List<String> intrfcs = new ArrayList<>();
      NodeList interfacesNode = interfaceNode.getElementsByTagName("interfaceName");
      for (int i = 0; i < interfacesNode.getLength(); i++) {
        intrfcs.add(interfacesNode.item(i).getTextContent());
      }
      jcs.setInterfaces(intrfcs);
      for (int i = 0; i < intrfcs.size(); i++) {
        System.out.println("INTERFACE: " + intrfcs.get(i));
      }

      Node descriptionNode = e.getElementsByTagName("description").item(0);
      String description = descriptionNode.getTextContent();
      jcs.setDescription(description);
      System.out.println("Current element class description: " + description);

      Element methodsNode = (Element) e.getElementsByTagName("methods").item(0);
      NodeList methods = methodsNode.getChildNodes();

      List<JavaClassStruct.Method> methodList = new ArrayList<>();
      for (int i = 0; i < methods.getLength(); i++) {
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

        JavaClassStruct.Method meth =
            new JavaClassStruct.Method(methodName, methodDescription, methodUsage);
        methodList.add(meth);
      }
      jcs.setMethodList(methodList);

      // Properties
      Element propertiesNode = (Element) e.getElementsByTagName("properties").item(0);
      NodeList properties = propertiesNode.getChildNodes();

      List<JavaClassStruct.Property> propertyList = new ArrayList<>();
      for (int i = 0; i < properties.getLength(); i++) {
        Element property = (Element) properties.item(i);
        Node propertyNameNode = property.getElementsByTagName("propertyName").item(0);
        String propertyName = propertyNameNode.getTextContent();
        System.out.println("propertyName" + i + " " + propertyName);

        Node propertyDescriptionNode = property.getElementsByTagName("propertyDescription").item(0);
        String propertyDescription = propertyDescriptionNode.getTextContent();
        System.out.println("propertydesc" + i + " " + propertyDescription);

        Node propertyUsageNode = property.getElementsByTagName("propertyUsage").item(0);
        String propertyUsage = propertyUsageNode.getTextContent();
        System.out.println("propertyusage" + i + " " + propertyUsage);

        JavaClassStruct.Property prop =
            new JavaClassStruct.Property(propertyName, propertyDescription, propertyUsage);
        propertyList.add(prop);
      }
      jcs.setPropertyList(propertyList);

      jcsList.put(jcs.getFileName(), jcs);
    }

    return jcsList;
  }
}
