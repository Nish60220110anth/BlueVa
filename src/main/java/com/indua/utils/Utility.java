package com.indua.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.lang.model.element.Modifier;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

public class Utility {
    /**
     * It takes a BJAccessModifiers enum and returns a Modifier enum
     * 
     * @param accModifer The access modifier of the method.
     * @return A Modifier object.
     */
    public static Modifier getAccessModifier(BJAccessModifier accModifer) {
        if (accModifer == BJAccessModifier.DEFAULT) {
            return Modifier.DEFAULT;
        } else if (accModifer == BJAccessModifier.PRIVATE) {
            return Modifier.PRIVATE;
        } else if (accModifer == BJAccessModifier.PROTECTED) {
            return Modifier.PROTECTED;
        } else {
            return Modifier.PUBLIC;
        }
    }

    /**
     * It takes a BJNAccessModifiersField enum value and returns a Java Modifier
     * enum value
     * 
     * @param naccModifier The non-access modifier for the field.
     * @return A modifier.
     */
    public static Modifier getNonAccessModifierForField(BJNAccessModifierField naccModifier) {
        if (naccModifier == BJNAccessModifierField.DEFAULT) {
            return Modifier.DEFAULT;
        } else if (naccModifier == BJNAccessModifierField.FINAL) {
            return Modifier.FINAL;
        } else if (naccModifier == BJNAccessModifierField.STATIC) {
            return Modifier.STATIC;
        } else if (naccModifier == BJNAccessModifierField.TRANSIENT) {
            return Modifier.TRANSIENT;
        } else {
            return Modifier.VOLATILE;
        }
    }

    /**
     * It takes a BJNAccessModifiersMethod enum value and returns a Modifier enum
     * value
     * 
     * @param naccModifier The non-access modifier for the method.
     * @return The return type of the method.
     */
    public static Modifier getNonAccessModifierForMethod(BJNAccessModifierMethod naccModifier) {
        if (naccModifier == BJNAccessModifierMethod.ABSTRACT) {
            return Modifier.ABSTRACT;
        } else if (naccModifier == BJNAccessModifierMethod.FINAL) {
            return Modifier.FINAL;
        } else if (naccModifier == BJNAccessModifierMethod.STATIC) {
            return Modifier.STATIC;
        } else if (naccModifier == BJNAccessModifierMethod.SYNCHRONIZED) {
            return Modifier.SYNCHRONIZED;
        } else if (naccModifier == BJNAccessModifierMethod.TRANSIENT) {
            return Modifier.TRANSIENT;
        } else {
            return Modifier.DEFAULT;
        }
    }

    /**
     * It takes a BJNAccessModifiersClass enum value and returns a Java Modifier
     * enum value
     * 
     * @param naccModifier The non-access modifier for the class.
     * @return The return type is a Modifier.
     */
    public static Modifier getNonAccessModifierForClass(BJNAccessModifierClass naccModifier) {
        if (naccModifier == BJNAccessModifierClass.ABSTRACT) {
            return Modifier.ABSTRACT;
        } else if (naccModifier == BJNAccessModifierClass.DEFAULT) {
            return Modifier.DEFAULT;
        } else {
            return Modifier.FINAL;
        }
    }

    /**
     * "If the parameter is DEFAULT, return Modifier.DEFAULT, otherwise return
     * Modifier.FINAL."
     * 
     * The function is called in the following way:
     * 
     * @param naccModifier The non-access modifier for the parameter.
     * @return A modifier.
     */
    public static Modifier getNonAccessModifierForParameter(BJNAccessModifierParameter naccModifier) {
        if (naccModifier == BJNAccessModifierParameter.DEFAULT) {
            return Modifier.DEFAULT;
        } else {
            return Modifier.FINAL;
        }
    }

    /**
     * It returns the Java class type for the given primitive type
     * 
     * @param _primTypes The primitive type that you want to convert to a Type.
     * @return The return type is a Class object.
     */
    public static Type getTypeNameForPrimTypes(BJPrimTypes _primTypes) {
        if (_primTypes == BJPrimTypes.BOOLEAN) {
            return Boolean.class;
        } else if (_primTypes == BJPrimTypes.BYTE) {
            return Byte.class;
        } else if (_primTypes == BJPrimTypes.CHAR) {
            return Character.class;
        } else if (_primTypes == BJPrimTypes.DOUBLE) {
            return Double.class;
        } else if (_primTypes == BJPrimTypes.FLOAT) {
            return Float.class;
        } else if (_primTypes == BJPrimTypes.INT) {
            return Integer.class;
        } else if (_primTypes == BJPrimTypes.SHORT) {
            return Short.class;
        } else {
            return String.class;
        }
    }

    /**
     * It takes a package name and a class name and returns a TypeName object
     * 
     * @param _packageName The package name of the class you want to create.
     * @param _className   The name of the class you want to create.
     * @return A TypeName object.
     */

    public static TypeName getTypeNameFromString(String _packageName, String _className) {
        return ClassName.get(_packageName, _className);
    }

    /**
     * It takes an ArrayList of Strings and returns a String of all the elements in
     * the ArrayList
     * separated by commas
     * 
     * @param _arrayList The array list you want to convert to a string.
     * @return A string of the array list.
     */
    public static String getArrayString(ArrayList<String> _arrayList) {
        return String.join(",", _arrayList);
    }
}
