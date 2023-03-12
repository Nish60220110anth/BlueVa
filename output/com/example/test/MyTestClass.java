package com.example.test;
 
import static java.io.*;
import static java.lang.*;

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
   * Sample Java doc for Method MyTestMethod 2ed71338-8322-4fc1-b9ee-47b77f728470
   * @param testParam Sample Java doc for Parameter testParam
   */
  public Integer MyTestMethod(final String testParam) {
    for (int i=0 ; i < 100 ; i++) {
      System.out.println("Hello India")
          ;
      if(i == 69) {
        System.out.println("I got 69");
      } else if( i == 9) {
        System.out.println("I got 9");
      } else {
        System.out.println("Oops Nothing");
      }
    }
  }
}
