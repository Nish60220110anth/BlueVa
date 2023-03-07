package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifier;

public class BJEnum {
    /**
     * The function creates a new instance of the class BJEnum
     * 
     * @param _ppackageName The package name of the enum class.
     * @return A new instance of BJEnum.
     */
    public static BJEnum createInstance(String _ppackageName) {
        return new BJEnum(_ppackageName);
    }

    /**
     * It takes an array of strings and returns an array of BJEnumValue objects
     * 
     * @param _enumStr   An array of strings that will be used to generate the enum
     *                   values.
     * @param reqDefault If true, the first value in the enum will be "DEFAULT" and
     *                   will have a value of 0.
     * @return An ArrayList of BJEnumValue objects.
     */
    public static ArrayList<BJEnumValue> generateEnumValues(ArrayList<String> _enumStr, Boolean reqDefault) {
        ArrayList<BJEnumValue> _enumValues = new ArrayList<>();
        int count = 1;
        _enumValues.add(BJEnumValue.createInstance().setName("DEFAULT").setValue(0));

        for (String str : _enumStr) {
            _enumValues.add(BJEnumValue.createInstance().setName(str).setValue(count));
            count += 1;
        }

        return _enumValues;
    }

    private String _name;
    private BJAccessModifier _accModifier;
    private ArrayList<BJEnumValue> _enumvaluesColl;
    private final String _packageName;

    private BJEnum(String _ppackageName) {
        _enumvaluesColl = new ArrayList<>();
        this._packageName = _ppackageName;

        _name = "DefaultEnum";
        _accModifier = BJAccessModifier.DEFAULT;
    }

    /**
     * It returns the package name of the enum.
     * 
     * @return The package name of the enum.
     */
    public String getPackageName() {
        return this._packageName;
    }

    /**
     * It returns the name of the enum.
     * 
     * @return The name of the enum.
     */
    public String getName() {
        return _name;
    }

    /**
     * Sets name of the enum
     * 
     * @param _name The name of the enum.
     * @return The enum itself.
     */
    public BJEnum setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * It returns the access modifiers of the class.
     * 
     * @return The access modifiers of the class.
     */
    public BJAccessModifier getAccModifier() {
        return _accModifier;
    }

    /**
     * This function sets the access modifiers of the enum to the access modifiers
     * passed in as a
     * parameter.
     * 
     * @param _accModifier The access modifiers for the enum.
     * @return The object itself.
     */
    public BJEnum setAccModifier(BJAccessModifier _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }

    /**
     * This function returns the value of the private variable _enumvaluesColl.
     * 
     * @return The return type is an ArrayList of BJEnumValue objects.
     */
    public ArrayList<BJEnumValue> setEnumvaluesColl() {
        return _enumvaluesColl;
    }

    /**
     * This function returns the collection of enum values for this enum.
     * 
     * @return An ArrayList of BJEnumValue objects.
     */
    public ArrayList<BJEnumValue> getEnumValuesColl() {
        return _enumvaluesColl;
    }

    /**
     * This function adds an enum value to the enum values collection.
     * 
     * @param _enumvalue The enum value to add to the enum
     * @return The object itself.
     */
    public BJEnum addEnumValues(BJEnumValue _enumvalue) {
        this._enumvaluesColl.add(_enumvalue);
        return this;
    }
}
