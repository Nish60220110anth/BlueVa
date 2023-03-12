package com.indua;

import java.io.IOException;
import java.util.ArrayList;
import com.indua.props.BJFieldI;
import com.indua.props.BJInterface;
import com.indua.props.BJMethodInterface;
import com.indua.props.BJParameter;
import com.indua.utils.BJAccessModifier;
import com.indua.utils.BJAccessModifierCI;
import com.indua.utils.BJAccessModifierFieldI;
import com.indua.utils.BJInterfaceWriter;
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
        // Class
        // BJClass myclass = BJClass.createInstance("com.example.test")
        //         .setName("MyTestClass");

        // BJParameter _parameter1 = BJParameter.createInstance().setName("testParam")
        //         .setOutput(BJPrimTypes.STRING);

        // BJMethodClass _method = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PUBLIC)
        //         .setName("MyTestMethod")
        //         .setOutput(BJPrimTypes.INT)
        //         .setBjId(BJId.createInstance(UUID.randomUUID()))
        //         .addParameter(_parameter1);

        // BJField _field = BJField.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
        //         .setOutput(BJPrimTypes.STRING)
        //         .setName("myName")
        //         .setValue("Nishanth")
        //         .setNaccModifier(BJNAccessModifierFieldC.STATIC);

        // myclass.addMethod(_method);
        // myclass.addField(_field);

        // try {
        //     BJClassWriter.createInstance(myclass).build();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

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
        BJFieldI _field1 = BJFieldI.createInstance().setName("myTestField1")
        .setAccModifier(BJAccessModifierFieldI.PUBLIC)
        .setNaccModifier(BJNAccessModifierFieldI.STATIC)
        .setOutput(BJPrimTypes.BOOLEAN)
        .setValue("true");

        BJMethodInterface _method1 = BJMethodInterface.createInstance()
        .setName("MyTestMethod")
        .setOutput(BJPrimTypes.INT)
        .addParameter(BJParameter.createInstance().setName("myTestParam1").setOutput(BJPrimTypes.STRING))
        .addParameter(BJParameter.createInstance().setName("myTestParam2").setOutput(BJPrimTypes.BOOLEAN))
        .setAccModifier(BJAccessModifier.PUBLIC)
        .setNaccModifier(BJNAccessModifierMethod.STATIC);

        ArrayList<String> myInter = new ArrayList<>();
        myInter.add("MyInter1");
        myInter.add("MyInter2");

        BJInterface _interface = BJInterface.createInstance("com.example.test")
        .setName("MyTestInterface")
        .setAccModifier(BJAccessModifierCI.PUBLIC)
        .setImplementingInterfaces(myInter);

        _interface.addMethod(_method1);
        _interface.addField(_field1);

        try {
            BJInterfaceWriter.createInstance(_interface).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
