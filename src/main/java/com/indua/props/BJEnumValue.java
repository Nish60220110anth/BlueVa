package com.indua.props;

public class BJEnumValue {
    /**
     * Creates new instance of BJEnum
     * 
     * @return A new instance of BJEnumValue
     */
    public static BJEnumValue createInstance() {
        return new BJEnumValue();
    }

    private String _name;
    private int _value;

    private BJEnumValue() {

    }

    /**
     * This function returns the name of the person
     * 
     * @return The name of the person.
     */
    public String getName() {
        return _name;
    }

    /**
     * This function sets the name of the enum value to the given name.
     * 
     * @param _name The name of the enum value.
     * @return The object itself.
     */
    public BJEnumValue setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * This function returns the value of the private variable _value
     * 
     * @return The value of the variable _value.
     */
    public int getValue() {
        return _value;
    }

    /**
     * This function sets the value of the enum to the value passed in as a
     * parameter.
     * 
     * @param _pvalue The value of the enum.
     * @return The value of the enum.
     */

    public BJEnumValue setValue(int _pvalue) {
        this._value = _pvalue;
        return this;
    }
}
