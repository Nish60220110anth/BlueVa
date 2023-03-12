package com.example.test;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

/**
 * Hello , this is Sample Java doc for interface MyTestInterface
 * @brief
 * Some sample brief message
 */
public interface MyTestInterface extends MyInter1, MyInter2 {
  /**
   * Sample Jav doc for Field myTestField1
   */
  Boolean myTestField1 = Boolean.valueOf("true");

  /**
   * Sample Java doc for Method MyTestMethod
   * @param myTestParam1 Sample Java doc for myTestParam1@param myTestParam2 Sample Java doc for myTestParam2
   */
  static Integer MyTestMethod(final String myTestParam1, final Boolean myTestParam2) {
  }
}
