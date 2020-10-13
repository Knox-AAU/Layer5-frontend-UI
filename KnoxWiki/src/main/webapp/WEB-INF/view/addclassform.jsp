<%--
  Created by IntelliJ IDEA.
  User: bjark
  Date: 25/09/2020
  Time: 14.22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/nav.jspf"%>
<div class="mainbody">
    <%@ include file="common/sidebar.jspf"%>

        <div id="AddClassForm">
            <!-- Header -->
            <div class="addclass_header_section">
                <h1 >Add New Class</h1>
            </div>

            <!-- Class Name -->
            <div class="addclass_section">
                <h2 class="addclass_section_header">Class Name</h2>
                <input id="class_name_input" class="addclass_txt_input" type="text">

            </div>
            <!-- Class Exctents -->
            <div class="addclass_section">
                <h2 class="addclass_section_header">Inheritence</h2>
                <h3>Excents Class</h3>
                <input id="class_parent_input" class="addclass_txt_input"  type="text">
                <div id="Interface_Section">
                    <h3>Implements Interfaces</h3>
                    <div class="add_element_option">
                        <input id="Interface_Input" class="addclass_txt_input" type="text">
                        <button id="Add_Interface"  class="btn_accept btn addclass_add_btn" >Add</button>
                    </div>
                </div>
            </div>
            <!-- Class Description -->
            <div class="addclass_section">
                <h2 class="addclass_section_header">Class Description</h2>
                <textarea id="description_input" class="addclass_textfield"></textarea>
            </div>
            <!-- Class Methods -->
            <div class="addclass_section" id="addclass_method_section">
                <div class="add_element_option addclass_section_header">
                    <h2>Class Methods</h2>
                    <button class="btn_accept btn addclass_add_btn" id="AddMethod">Add</button>
                </div>
            </div>
            <!-- Class Properties -->
            <div class="addclass_section" id="addclass_property_section">
                <div class="add_element_option addclass_section_header">
                    <h2>Class Properties</h2>
                    <button class="btn_accept btn addclass_add_btn" id="AddProperty">Add</button>
                </div>
            </div>


            <!-- Class Properties -->
            <div class="addclass_save_Section">
                <h3>Save Class</h3>
                <button  class="btn_confirm btn"  id="SaveClass">Save</button>
            </div>
        </div>

</div>
</body>
<script>
    var methodhtml = `<%@ include file="classcomponents/classmethod.jspf"%>`;
    var propertyhtml = `<%@ include file="classcomponents/classproperty.jspf"%>`;

    $( "#AddMethod" ).click(function() {
        var section = document.querySelector("#addclass_method_section");
        const div = document.createElement('div');
        div.innerHTML = methodhtml;

        section.appendChild(div);
    });
    $( "#AddProperty" ).click(function() {
        var section = document.querySelector("#addclass_property_section");
        const div = document.createElement('div');
        div.innerHTML = propertyhtml;

        section.appendChild(div);
    });


    $( "#Add_Interface" ).click(function() {
        var interface_input = document.querySelector("#Interface_Input");
        var name = interface_input.value;
        if (name === "") return;
        var section = document.querySelector("#Interface_Section");
        const div = document.createElement('div');
        const text = document.createElement('h3');
        text.classList.add("interface_name");
        text.innerHTML = name;
        interface_input.value = "";
        div.appendChild(text);
        section.appendChild(div);
    });


    $( "#SaveClass" ).click(function() {
        createJsonOutOfClassForm();
    });


    function createJsonOutOfClassForm () {
        // Retrive data
        var name = document.querySelector("#class_name_input").value;
        var parentclass = document.querySelector("#class_parent_input").value;
        var interfaceelements =  document.querySelectorAll(".interface_name");
        var interfaces = [];
        if (!(interfaceelements == null)){
            for(var i = 0; i < interfaceelements.length; i ++){
                interfaces.push(interfaceelements[i].innerHTML)
            }
        }
        var description = document.querySelector("#description_input").value;
        var methodlist = getMethodData ();
        var propertyList = getPropertyData ();

        console.log(name);
        console.log(parentclass);
        console.log(interfaceelements);
        console.log(interfaces);
        console.log(description);
        console.log(methodlist);
        console.log(propertyList);

        var whateveryouwant = {
            name : name,
            parentClass : parentclass,
            interfaces : interfaces,
            description : description,
            methodList : methodlist,
            propertyList : propertyList
        };
        SendData(whateveryouwant);
    }
    function SendData (classObject) {
        //var data = JSON.stringify(classObject);

        var test = JSON.stringify(
            classObject
        );

        console.log(test);
        $.ajax({
            type: "POST",
            url: "/test",
            contentType: "application/json",
            data: test,
            success: function (returnValue) {
                console.log("success");
                console.log(returnValue);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log (XMLHttpRequest);
                alert("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
            }
        });
    }
    function ClassSaveSuccess (returnValue) {
        console.log(returnValue);
    }
    function ClassSaveError (XMLHttpRequest, textStatus, errorThrown) {
        alert("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
    }


    function getMethodData () {
        var methodelements = document.querySelectorAll(".classmethod");
        var returnlist = [];
        console.log(methodelements);
        if (!(methodelements == null)){
            for(var i = 0; i < methodelements.length; i++){
                var method = methodelements[i];
                var methodname = method.querySelector(".methodname_input").value;
                var methoddescription = method.querySelector(".methoddescription_input").value;
                var methodexample = method.querySelector(".methodexample_input").value;

                var method = {
                    name : methodname,
                    description : methoddescription,
                    example : methodexample,
                };
                returnlist.push(method);
            }
            return returnlist;
        } else {
            return null;
        }
    }
    function getPropertyData () {
        var propertyElements = document.querySelectorAll(".classproperty");
        var returnlist = [];
        console.log(propertyElements);
        if (!(propertyElements == null)){
            for(var i = 0; i < propertyElements.length; i++){
                var property = propertyElements[i];
                var propertyname = property.querySelector(".propertyname_input").value;
                var propertydescription = property.querySelector(".propertydescription_input").value;
                var propertyExample = property.querySelector(".propertyexample").value;
                var property = {
                    name : propertyname,
                    description : propertydescription,
                    example : propertyExample,
                };
                returnlist.push(property);
            }
            return returnlist;
        } else {
            return null;
        }
    }
</script>
</html>
