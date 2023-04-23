package com.indua;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.lang.model.element.Modifier;

import com.indua.props.BJClass;
import com.indua.props.BJEnum;
import com.indua.props.BJField;
import com.indua.props.BJFieldI;
import com.indua.props.BJId;
import com.indua.props.BJInterface;
import com.indua.props.BJMethodClass;
import com.indua.props.BJMethodInterface;
import com.indua.props.BJParameter;
import com.indua.props.BJValue;
import com.indua.utils.BJAccessModifier;
import com.indua.utils.BJAccessModifierCI;
import com.indua.utils.BJAccessModifierE;
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
        BJClass myclass = BJClass.createInstance("blueva")
                .setName("MyTestClass")
                .setAccModifier(Modifier.PUBLIC)
                .setNaccModifier(Modifier.DEFAULT)
                .setIsShouldAddParamConstructor(true)
                .setMain(false);

        BJParameter _parameter1 = BJParameter.createInstance().setName("testParam")
                .setOutput(BJPrimTypes.STRING).setIsArray(true);

        BJParameter _parameter2 = BJParameter.createInstance().setName("anoTestParam")
                .setOutput(BJPrimTypes.INT).setIsArray(false);

        BJMethodClass _method = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PUBLIC)
                .setName("MyTestMethod")
                .setOutput(BJPrimTypes.INT)
                .setComment("This is a test method")
                .setCode("System.out.println(\"Hello Mom!\");")
                .setBjId(BJId.createInstance(UUID.randomUUID()))
                .addParameter(_parameter1)
                .addParameter(_parameter2);

        BJMethodClass _method2 = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
                .setName("MyAnoTestMethod")
                .setOutput(BJPrimTypes.VOID)
                .setComment("My AnoTest Comment")
                .setCode("System.out.println(\"Hello Mom!\");")
                .setBjId(BJId.createInstance(UUID.randomUUID()))
                .addParameter(_parameter1);

        BJField _field1 = BJField.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
                .setOutput(BJPrimTypes.CHAR)
                .setIsArray(true)
                .setName("myCharArray")
                .setValue("Nishanth")
                .setNaccModifier(Modifier.DEFAULT);

        BJField _field2 = BJField.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
                .setOutput(BJPrimTypes.FLOAT)
                .setIsArray(true)
                .setName("myFloatArray")
                .setValue("Nishanth")
                .setNaccModifier(Modifier.DEFAULT);

        BJField _field3 = BJField.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
                .setOutput(BJPrimTypes.INT)
                .setIsArray(false)
                .setName("myNumber")
                .setValue("0")
                .setNaccModifier(Modifier.DEFAULT);

        myclass.addMethod(_method).addMethod(_method2);
        myclass.addField(_field1).addField(_field2).addField(_field3);

        myclass.setExtendingInterfaces(null);

        // BJImport import1 = BJImport.createInstance().setPackageName("java")
        // .setSimpleName("lang").setLeafName("String");
        // BJImport import2 = BJImport.createInstance().setPackageName("java")
        // .setSimpleName("lang").setLeafName("Object");

        // BJImports imports =
        // BJImports.createInstance().addImport(import1).addImport(import2);
        // myclass.setStaticImports(imports);

        // BJPackage _package =
        // BJPackage.createInstance("com.example").setPackageDir("./myoutput");
        // _package.addClass(myclass);

        // try {
        // _package.build();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // Enum
        BJEnum _enum = BJEnum.createInstance("enum").
        setAccModifier(BJAccessModifierE.PUBLIC)
        .setName("MyTestEnum");

        BJValue _value1 = BJValue.createInstance().setName("VALUE1").setValue(0);
        BJValue _value2 = BJValue.createInstance().setName("VALUE2").setValue(1);

        _enum.addValue(_value1).addValue(_value2);

        // Interface
        BJFieldI _field11 = BJFieldI.createInstance().setName("myTestField1")
                .setOutput(BJPrimTypes.INT)
                .setValue("0");

        BJFieldI _field12 = BJFieldI.createInstance().setName("myTestField2")
                .setOutput(BJPrimTypes.STRING)
                .setValue("Nishanth");

        BJMethodInterface _method1 = BJMethodInterface.createInstance()
                .setName("MyTestMethod")
                .setOutput(BJPrimTypes.INT)
                .addParameter(BJParameter.createInstance().setName("myTestParam1").setOutput(BJPrimTypes.STRING))
                .addParameter(BJParameter.createInstance().setName("myTestParam2").setOutput(BJPrimTypes.BOOLEAN))
                .addParameter(BJParameter.createInstance().setName("myArrayParam").setIsArray(true)
                        .setOutput(BJPrimTypes.FLOAT))
                .setAccModifier(BJAccessModifier.PUBLIC)
                .setNaccModifier(BJNAccessModifierMethod.ABSTRACT);

        ArrayList<String> myInter = new ArrayList<>();
        myInter.add("MyInter1");
        // myInter.add("MyInter2");

        BJInterface _interface = BJInterface.createInstance("myblueva")
                .setName("MyTestInterface")
                .setAccModifier(BJAccessModifierCI.ABSTRACT)
                .setImplementingInterfaces(myInter)
                .setInterfaceComment(
                        "Some Sample interface comment to demonstarate infact to test the comment for MyTestInterface Interface ")
                .setFileComment("Some Sample file comment to demonstarate infact to test the comment");

        _interface.addMethod(_method1);
        _interface.addField(_field11).addField(_field12);

        BJPackage _package = BJPackage.createInstance("com.example").setPackageDir("./myoutput");
        _package.addClass(myclass).addInterface(_interface).addEnum(_enum);

        try {
            _package.build();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
