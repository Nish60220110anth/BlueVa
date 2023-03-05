package com.indua.utils;

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

    public static Modifier getNonAccessModifierForMethod(BJNAccessModifiersMethod naccModifier) {
        
    }
}
