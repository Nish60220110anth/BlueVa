package com.indua.props;

import com.indua.utils.BJAccessModifiers;
import com.indua.utils.BJNAccessModifiersField;
import com.indua.utils.BJPrimTypes;

public class BJField {
    /**
     * Creates new instance of BJField
     * 
     * @return A new instance of BJField.
     */
    public static BJField createInstance() {
        return new BJField();
    }

    private String _name;
    private BJPrimTypes _output;
    private String _value;
    private BJAccessModifiers _accModifiers;
    private BJNAccessModifiersField _naccModifiersFields;

    private BJField() {

    }

    /**
     * This function returns the value of the private variable _value.
     * 
     * @return The value of the variable _value.
     */
    public String getValue() {
        return _value;
    }

    /**
     * This function sets the value of the field to the value passed in as a
     * parameter.
     * 
     * @param _value The value of the field.
     * @return The object itself.
     */
    public BJField setValue(String _value) {
        this._value = _value;
        return this;
    }

    /**
     * Gets the name of the field
     * 
     * @return The name of the field.
     */
    public String getName() {
        return _name;
    }

    /**
     * It sets the name of the field to the name passed in as a parameter
     * 
     * @param _name The name of the field.
     * @return The object itself.
     */
    public BJField setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * Returns the type of the field
     * 
     * @return The type of field.
     */
    public BJPrimTypes getOutput() {
        return _output;
    }

    /**
     * This function sets the output of the BJField to the value of the parameter
     * _output
     * 
     * @param _output The type of the output of the field.
     * @return The BJField object.
     */
    public BJField setOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    /**
     * It returns the access modifiers of the class.
     * 
     * @return The access modifiers of the class.
     */
    public BJAccessModifiers getAccModifiers() {
        return _accModifiers;
    }

    /**
     * This function sets the access modifiers of the field and returns the field.
     * 
     * @param _accModifiers The access modifiers for the field.
     * @return The object itself.
     */
    public BJField setAccModifiers(BJAccessModifiers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    /**
     * This function returns the value of the private field _naccModifiersFields
     * 
     * @return The _naccModifiersFields variable is being returned.
     */

    public BJNAccessModifiersField getNaccModifiers() {
        return _naccModifiersFields;
    }

    /**
     * This function sets the value of the private variable _naccModifiersFields to
     * the value of the
     * parameter _naccModifiersMethods.
     * 
     * @param _naccModifiersMethods The access modifier for the method.
     * @return The object itself.
     */
    public BJField setNaccModifiers(BJNAccessModifiersField _naccModifiersMethods) {
        this._naccModifiersFields = _naccModifiersMethods;
        return this;
    }

}
