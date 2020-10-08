package springTest.springMVC.datatypes;

import java.util.List;

public class JavaClassStruct {
    private String name;
    private String parentClass;
    private String description;
    private List<String> interfaces;
    private List<Method> methodList;
    private List<Property> propertyList;

    public JavaClassStruct(String name, String parentClass, String description, List<String> interfaces, List<Method> methodList, List<Property> propertyList) {
        this.name = name;
        this.parentClass = parentClass;
        this.description = description;
        this.interfaces = interfaces;
        this.methodList = methodList;
        this.propertyList = propertyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentClass() {
        return parentClass;
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<String> interfaces) {
        this.interfaces = interfaces;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }


    public class Method  {
        private String name;
        private String description;
        private String example;


        public Method(String name, String description, String example) {
            this.name = name;
            this.description = description;
            this.example = example;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

    }
    public class Property  {
        private String name;
        private String description;
        private String example;

        public Property(String name, String description, String example) {
            this.name = name;
            this.description = description;
            this.example = example;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }
    }


}
