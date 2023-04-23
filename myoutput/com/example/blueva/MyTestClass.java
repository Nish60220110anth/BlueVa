package com.example.blueva;

import static java.lang.Object;
import static java.lang.String;

import java.lang.Character;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;

/**
 * Hello , this is Sample Java doc for class MyTestClass
 * @brief
 * Some sample brief message
 */
public final class MyTestClass {
  /**
   * Sample Jav doc for Field myName
   */
  Character[] myName = Character.valueOf('N');

  MyTestClass(Character[] myName) {
    this.myName = '';
  }

  MyTestClass(Character[] myName) {
    this.myName = myName;
  }

  /**
   * Sample Java doc for Method main 4752d539-c1a5-40cb-a50d-e187bc6696d0  
   * @param args Sample Java doc for Parameter args
   */
  public static Void main(final String[] args) {
    System.out.println("Hello Mom!");
  }

  /**
   * Sample Java doc for Method MyTestMethod 15abd8ff-63d5-48c8-981d-261f639c790d This is a test method 
   * @param testParam Sample Java doc for Parameter testParam
   */
  public Integer MyTestMethod(final String[] testParam) {
    System.out.println("Hello Mom!");
  }

  /**
   * Sample Java doc for Method MyAnoTestMethod b42aeb51-122e-4885-a6f8-6984c18fdd22 My AnoTest Comment 
   * @param testParam Sample Java doc for Parameter testParam
   */
  private Void MyAnoTestMethod(final String[] testParam) {
    System.out.println("Hello Mom!");
  }
}
