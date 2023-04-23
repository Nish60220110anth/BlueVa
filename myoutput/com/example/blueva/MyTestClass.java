package com.example.blueva;

import static java.lang.Object;
import static java.lang.String;

import java.lang.Character;
import java.lang.Float;
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
   * Sample Jav doc for Field myCharArray
   */
  Character[] myCharArray = new Character[] {};

  /**
   * Sample Jav doc for Field myFloatArray
   */
  Float[] myFloatArray = new Float[] {};

  /**
   * Sample Jav doc for Field myNumber
   */
  Integer myNumber = Integer.valueOf(0);

  MyTestClass() {
    this.myCharArray = new Character[]{};
    this.myFloatArray = new Float[]{};
    this.myNumber = 0;
  }

  MyTestClass(Character[] myCharArray, Float[] myFloatArray, Integer myNumber) {
    this.myCharArray = myCharArray;
    this.myFloatArray = myFloatArray;
    this.myNumber = myNumber;
  }

  /**
   * @param args Sample Java doc for Parameter args
   */
  public static Void main(final String[] args) {
    System.out.println("Hello Mom!");
  }

  /**
   * This is a test method
   * @param testParam Sample Java doc for Parameter testParam
   */
  public Integer MyTestMethod(final String[] testParam) {
    System.out.println("Hello Mom!");
  }

  /**
   * My AnoTest Comment
   * @param testParam Sample Java doc for Parameter testParam
   */
  private Void MyAnoTestMethod(final String[] testParam) {
    System.out.println("Hello Mom!");
  }
}
