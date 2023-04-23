// Some Sample file comment to demonstarate infact to test the comment
package com.example.myblueva;

import java.lang.Boolean;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;

/**
 * Some Sample interface comment to demonstarate infact to test the comment for MyTestInterface Interface 
 */
abstract interface MyTestInterface extends MyInter1 {
  /**
   * Sample Jav doc for Field myTestField1
   */
  Integer myTestField1 = Integer.valueOf("0");

  /**
   * Sample Jav doc for Field myTestField2
   */
  String myTestField2 = String.valueOf("Nishanth");

  /**
   * Sample Java doc for Method MyTestMethod null
   * @param myTestParam1 Sample Java doc for myTestParam1
   * @param myTestParam2 Sample Java doc for myTestParam2
   * @param myArrayParam Sample Java doc for myArrayParam
   */
  Integer MyTestMethod(String myTestParam1, Boolean myTestParam2, Float[] myArrayParam);
}
