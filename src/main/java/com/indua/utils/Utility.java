package com.indua.utils;

import java.lang.reflect.Type;

import javax.lang.model.element.Modifier;

public class Utility {
    public static Modifier GetAccessModifier(BJAccessModifers accModifer) {
        if (accModifer == BJAccessModifers.DEFAULT) {
            return Modifier.DEFAULT;
        } else if (accModifer == BJAccessModifers.PRIVATE) {
            return Modifier.PRIVATE;
        } else if (accModifer == BJAccessModifers.PROTECTED) {
            return Modifier.PROTECTED;
        } else {
            return Modifier.PUBLIC;
        }
    }

    public static Modifier GetNonAccessModifierForField(BJNAccessModifiersField naccModifier) {
        if (naccModifier == BJNAccessModifiersField.DEFAULT) {
            return Modifier.DEFAULT;
        } else if (naccModifier == BJNAccessModifiersField.FINAL) {
            return Modifier.FINAL;
        } else if (naccModifier == BJNAccessModifiersField.STATIC) {
            return Modifier.STATIC;
        } else if (naccModifier == BJNAccessModifiersField.TRANSIENT) {
            return Modifier.TRANSIENT;
        } else {
            return Modifier.VOLATILE;
        }
    }

    public static Modifier GetNonAccessModifierForMethod(BJNAccessModifiersMethod naccModifier) {
        if (naccModifier == BJNAccessModifiersMethod.ABSTRACT) {
            return Modifier.ABSTRACT;
        } else if (naccModifier == BJNAccessModifiersMethod.FINAL) {
            return Modifier.FINAL;
        } else if (naccModifier == BJNAccessModifiersMethod.STATIC) {
            return Modifier.STATIC;
        } else if (naccModifier == BJNAccessModifiersMethod.SYNCHRONIZED) {
            return Modifier.SYNCHRONIZED;
        } else if (naccModifier == BJNAccessModifiersMethod.TRANSIENT) {
            return Modifier.TRANSIENT;
        } else {
            return Modifier.DEFAULT;
        }
    }

    public static Modifier GetNonAccessModifierForClass(BJNAccessModifiersClass naccModifier) {
        if (naccModifier == BJNAccessModifiersClass.ABSTRACT) {
            return Modifier.ABSTRACT;
        } else if (naccModifier == BJNAccessModifiersClass.DEFAULT) {
            return Modifier.DEFAULT;
        } else {
            return Modifier.FINAL;
        }
    }

    public static Modifier GetNonAccessModifierForParameter(BJNAccessModifiersParameter naccModifier) {
        if (naccModifier == BJNAccessModifiersParameter.DEFAULT) {
            return Modifier.DEFAULT;
        } else {
            return Modifier.FINAL;
        }
    }

    public static Type GetTypeNameForPrimTypes(BJPrimTypes _primTypes) {
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
}
