package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifier;
import com.indua.utils.BJNAccessModifierMethod;
import com.indua.utils.BJPrimTypes;

/**
 * Method in class
 * 
 */
public class BJMethodClass extends BJMethod {

    /**
     * CreateInstance() is a static method that returns a new instance of
     * BJMethodClass.
     * 
     * @return The method is returning a new instance of the class.
     */
    public static BJMethodClass createInstance() {
        return new BJMethodClass();
    }

    private String _name; // name of node
    private BJPrimTypes _output; // return type of method
    private BJId _bjId; // Unique identifier for code
    private BJAccessModifier _accModifier;
    private BJNAccessModifierMethod _naccModifierMethod;
    private ArrayList<BJParameter> _parameterColl;

    private BJMethodClass() {
        _parameterColl = new ArrayList<>();

        _naccModifierMethod = BJNAccessModifierMethod.NONE;
    }

    /**
     * It returns the name of the BJMethodClass node.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return _name;
    }

    /**
     * This function sets the name of the object to the name passed in as a
     * parameter
     * 
     * @param _name The name of the method.
     * @return The object itself.
     */
    public BJMethodClass setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * This function sets the return type of the method
     * 
     * @param _output The return type of the method.
     * @return The class itself.
     */
    public BJMethodClass setOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    /**
     * It returns the return type of the method.
     * 
     * @return The return type of the method.
     */
    public BJPrimTypes getOutput() {
        return this._output;
    }

    /**
     * This function returns the BJId of the object
     * 
     * @return The BJId object.
     */
    public BJId getBjId() {
        return _bjId;
    }

    /**
     * This function sets the unique id for the method code
     * 
     * @param _bjId The id of the method code
     * @return The object itself.
     */
    public BJMethodClass setBjId(BJId _bjId) {
        this._bjId = _bjId;
        return this;
    }

    /**
     * This function returns the access modifiers of the class
     * 
     * @return The access modifiers of the class.
     * @apiNote See {@link BJAccessModifier} for supported Access
     */

    public BJAccessModifier getAccModifier() {
        return _accModifier;
    }

    /**
     * This function sets the access modifiers of the class to the access modifiers
     * passed in as a
     * parameter.
     * 
     * @param _accModifiers The access modifiers for the method.
     * @return The object itself.
     */
    public BJMethodClass setAccModifier(BJAccessModifier _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }

    /**
     * It returns the value of the variable _naccModifiersMethods.
     * 
     * @return The method is returning the value of the variable
     *         _naccModifiersMethods.
     */
    public BJNAccessModifierMethod getNaccModifier() {
        return _naccModifierMethod;
    }

    /**
     * This function sets the value of the variable _naccModifiersMethods to the
     * value of the variable
     * _naccModifiersMethods.
     * 
     * @apiNote See {@link BJNAccessModifierMethod} for supported
     *          Non-Access-Modifiers
     * 
     * @param _naccModifiersMethods BJNAccessModifiersMethod
     * @return The object itself.
     */
    public BJMethodClass setNaccModifier(BJNAccessModifierMethod _naccModifiersMethods) {
        this._naccModifierMethod = _naccModifiersMethods;
        return this;
    }

    /**
     * This function returns an ArrayList of BJParameter objects
     * 
     * @return An ArrayList of BJParameter objects.
     */
    public ArrayList<BJParameter> getParameterColl() {
        return _parameterColl;
    }

    /**
     * This function adds a parameter to the parameter collection
     * 
     * @param _parameter The parameter to add to the method.
     * @return The class itself.
     */
    public BJMethodClass addParameter(BJParameter _parameter) {
        this._parameterColl.add(_parameter);
        return this;
    }

}
