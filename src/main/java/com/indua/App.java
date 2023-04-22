package com.indua;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.indua.props.BJClass;
import com.indua.props.BJField;
import com.indua.props.BJFieldI;
import com.indua.props.BJId;
import com.indua.props.BJImport;
import com.indua.props.BJImports;
import com.indua.props.BJInterface;
import com.indua.props.BJMethodClass;
import com.indua.props.BJMethodInterface;
import com.indua.props.BJParameter;
import com.indua.utils.BJAccessModifier;
import com.indua.utils.BJAccessModifierCI;
import com.indua.utils.BJAccessModifierFieldI;
import com.indua.utils.BJClassWriter;
import com.indua.utils.BJInterfaceWriter;
import com.indua.utils.BJNAccessModifierFieldC;
import com.indua.utils.BJNAccessModifierFieldI;
import com.indua.utils.BJNAccessModifierMethod;
import com.indua.utils.BJPrimTypes;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // // Class
        BJClass myclass = BJClass.createInstance("com.example.test")
                .setName("MyTestClass");

        BJParameter _parameter1 = BJParameter.createInstance().setName("testParam")
                .setOutput(BJPrimTypes.STRING);

        BJMethodClass _method = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PUBLIC)
                .setName("MyTestMethod")
                .setOutput(BJPrimTypes.INT)
                .setComment("This is a test method")
                .setCode("System.out.println(\"Hello Mom!\");")
                .setBjId(BJId.createInstance(UUID.randomUUID()))
                .addParameter(_parameter1);

        BJField _field = BJField.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
                .setOutput(BJPrimTypes.STRING)
                .setName("myName")
                .setValue("Nishanth")
                .setNaccModifier(BJNAccessModifierFieldC.STATIC);

        myclass.addMethod(_method);
        myclass.addField(_field);

        BJImport import1 = BJImport.createInstance().setPackageName("java")
        .setSimpleName("lang").setLeafName("String");
        BJImport import2 = BJImport.createInstance().setPackageName("java")
        .setSimpleName("lang").setLeafName("Object");

        BJImports imports = BJImports.createInstance().addImport(import1).addImport(import2);

        try {
            BJClassWriter.createInstance(myclass.setFileComment("My Test File comment")
            .setStaticImports(imports)).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // Enum
        // BJEnum _enum = BJEnum.createInstance("com.example.test").
        // setAccModifier(BJAccessModifierE.PUBLIC)
        // .setName("MyTestEnum");
        
        // BJValue _value1 = BJValue.createInstance().setName("VALUE1").setValue(0);
        // BJValue _value2 = BJValue.createInstance().setName("VALUE2").setValue(1);

        // _enum.addValue(_value1).addValue(_value2);

        //  try {
        //     BJEnumWriter.createInstance(_enum).build();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // Interface
        // BJFieldI _field1 = BJFieldI.createInstance().setName("myTestField1")
        // .setAccModifier(BJAccessModifierFieldI.PUBLIC)
        // .setNaccModifier(BJNAccessModifierFieldI.STATIC)
        // .setOutput(BJPrimTypes.BOOLEAN)
        // .setValue("true");

        // BJMethodInterface _method1 = BJMethodInterface.createInstance()
        // .setName("MyTestMethod")
        // .setOutput(BJPrimTypes.INT)
        // .addParameter(BJParameter.createInstance().setName("myTestParam1").setOutput(BJPrimTypes.STRING))
        // .addParameter(BJParameter.createInstance().setName("myTestParam2").setOutput(BJPrimTypes.BOOLEAN))
        // .setAccModifier(BJAccessModifier.PUBLIC)
        // .setNaccModifier(BJNAccessModifierMethod.STATIC);

        // ArrayList<String> myInter = new ArrayList<>();
        // myInter.add("MyInter1");
        // myInter.add("MyInter2");

        // BJInterface _interface = BJInterface.createInstance("com.example.test")
        // .setName("MyTestInterface")
        // .setAccModifier(BJAccessModifierCI.PUBLIC)
        // .setImplementingInterfaces(myInter)
        // .setFileComment("Some Sample file comment to demonstarate infact to test the comment");

        // _interface.addMethod(_method1);
        // _interface.addField(_field1);

        // try {
        //     BJInterfaceWriter.createInstance(_interface.setImports(imports)).build();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

    }
}
