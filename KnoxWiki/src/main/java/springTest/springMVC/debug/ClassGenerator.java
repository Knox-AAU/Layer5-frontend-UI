package springTest.springMVC.debug;

import springTest.springMVC.datatypes.JavaClassStruct;

import java.util.ArrayList;
import java.util.List;

public class ClassGenerator   {
    public static JavaClassStruct CreateJavaClassStruct () {
        String name = "AClass";
        String parentClass = "AbstractClass";
        String description ="This is a class with does something, and should be used in some to do these things. It is could to keep this in mind when useing this class";
        List<String> interfaces = new ArrayList<String>();
        interfaces.add("Iinterface");
        List< JavaClassStruct.Method > methodList = new ArrayList<JavaClassStruct.Method>();
        methodList.add(new JavaClassStruct.Method("First Method", "This is a method","Here is an code example"));
        methodList.add(new JavaClassStruct.Method("Second Method", "This is another method","Here is an code example"));
        methodList.add(new JavaClassStruct.Method("Third Method", "This is a method with a really long description, just to test what happens if the descirptiong of the method is a bit to long compared to the container it is inside. Becouse we can't have the layout getting ruid by peopel who are a bit to descriptinve when it comes to their methods. It also has a ton of spelling mistake but that is just beocouse it just need to be long and not to look nice like or shit ","Here is an code example"));
        methodList.add(new JavaClassStruct.Method("Fourth Method", "And this is also just another method","Here is an code example"));
        List< JavaClassStruct.Property > propertyList = new ArrayList<JavaClassStruct.Property>();
        propertyList.add(new JavaClassStruct.Property("First Property","This is a property", "An Example of use"));
        propertyList.add(new JavaClassStruct.Property("Second Property","This is another property", "An Example of use"));
        propertyList.add(new JavaClassStruct.Property("Third Property","This is a property with a really long description, just to test what happens if the descirptiong of the property is a bit to long compared to the container it is inside. Becouse we can't have the layout getting ruid by peopel who are a bit to descriptinve when it comes to their properties. It also has a ton of spelling mistake but that is just beocouse it just need to be long and not to look nice like or shit ", "An Example of use"));
        propertyList.add(new JavaClassStruct.Property("Fourth Property","And this is also just another property", "An Example of use"));


        return new JavaClassStruct(name,parentClass,description,interfaces,methodList,propertyList);
    }
}
