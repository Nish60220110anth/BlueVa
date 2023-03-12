package com.indua;

import java.io.IOException;
import java.util.UUID;

import com.indua.props.BJClass;
import com.indua.props.BJField;
import com.indua.props.BJId;
import com.indua.props.BJMethodClass;
import com.indua.props.BJParameter;
import com.indua.utils.BJAccessModifier;
import com.indua.utils.BJClassWriter;
import com.indua.utils.BJNAccessModifierFieldC;
import com.indua.utils.BJPrimTypes;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BJClass myclass = BJClass.createInstance("com.example.test")
                .setName("MyTestClass");

        BJParameter _parameter1 = BJParameter.createInstance().setName("testParam")
                .setOutput(BJPrimTypes.STRING);

        BJMethodClass _method = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PUBLIC)
                .setName("MyTestMethod")
                .setOutput(BJPrimTypes.INT)
                .setBjId(BJId.createInstance(UUID.randomUUID()))
                .addParameter(_parameter1);

        BJField _field = BJField.createInstance().setAccModifier(BJAccessModifier.PRIVATE)
                .setOutput(BJPrimTypes.STRING)
                .setName("myName")
                .setValue("Nishanth")
                .setNaccModifier(BJNAccessModifierFieldC.STATIC);

        myclass.addMethod(_method);
        myclass.addField(_field);

        try {
            BJClassWriter.createInstance(myclass).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/**
 * package com.example.test;
 * 
 * import java.lang.System;
 * import java.io.*;
 * 
 * public class MyInfo {
 * private String myName = "";
 * private String myCountry;
 * 
 * public static void TestMethod1(String args) {
 * 
 * }
 * 
 * private TestMethod2() {
 * 
 * }
 * 
 * }
 * 
 * 
 */
