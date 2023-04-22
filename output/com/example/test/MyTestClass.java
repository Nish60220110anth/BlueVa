// My Test File comment
package com.example.test;

import static java.lang.Object;
import static java.lang.String;

import com.squareup.javapoet.ClassName;
import java.lang.Integer;
import java.lang.String;

/**
 * Hello , this is Sample Java doc for class MyTestClass
 * @brief
 * Some sample brief message
 */
public class MyTestClass extends ClassName {
  /**
   * Sample Jav doc for Field myName
   */
  static String myName = String.valueOf("Nishanth");

  /**
   * Sample Constructor Java doc for Class MyTestClass
   */
  public MyTestClass() {
    String name = "Shiva";
    if ( name == "Shiva") {
      System.out.println("Hello Shiva");
    }
  }

  /**
   * Sample Java doc for Method MyTestMethod 13d3dc5a-cbcf-4545-b6ed-b86e8584dba6 This is a test method 
   * @param testParam Sample Java doc for Parameter testParam
   */
  public Integer MyTestMethod(final String testParam) {
    System.out.println("Hello Mom!");
  }
}
