package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifier;

public class BJInterface {
    /**
     * This function creates a new instance of the BJInterface class, and returns
     * it.
     * 
     * @param _ppackageName The package name of the app you want to launch.
     * @return A new instance of BJInterface.
     */
    public static BJInterface createInstance(String _ppackageName) {
        return new BJInterface(_ppackageName);
    }

    private String _name;
    private ArrayList<String> _implementingInterfaces;
    private BJAccessModifier _accModifier;
    private final String _packageName;
    private ArrayList<BJMethodInterface> _methodColl;

    private BJInterface(String _ppackageName) {
        _implementingInterfaces = new ArrayList<>();
        _methodColl = new ArrayList<>();
        _accModifier = BJAccessModifier.DEFAULT;

        this._packageName = _ppackageName;
    }

    /**
     * It returns the method collection.
     * 
     * @return An ArrayList of BJMethodInterface objects.
     */
    public ArrayList<BJMethodInterface> getMethodColl() {
        return _methodColl;
    }

    /**
     * Adds method to interface method collection
     * 
     * @param _method The method to add to the interface.
     * @return The interface itself.
     */
    public BJInterface addMethod(BJMethodInterface _method) {
        this._methodColl.add(_method);
        return this;
    }

    /**
     * It returns the package name of the interface.
     * 
     * @return The package name of the interface.
     */
    public String getPackageName() {
        return this._packageName;
    }

    /**
     * It returns the name of the interface.
     * 
     * @return The name of the interface.
     */
    public String getName() {
        return _name;
    }

    /**
     * This function sets the name of the object to the value of the parameter _name
     * and returns the
     * object.
     * 
     * @param _name The name of the interface.
     * @return The object itself.
     */
    public BJInterface setName(String _name) {
        this._name = _name;
        return this;
    }

    /**
     * Returns the implementing interfaces
     * 
     * @return An ArrayList of Strings
     */
    public ArrayList<String> getImplementingInterfaces() {
        return _implementingInterfaces;
    }

    /**
     * This function sets the implementing interfaces of the interface
     * 
     * @param _implementingInterfaces The list of interfaces that this interface
     *                                implements.
     * @return The object itself.
     */
    public BJInterface setImplementingInterfaces(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    }

    /**
     * Returns the access modifiers for the class
     * 
     * @return The access modifiers of the class.
     */
    public BJAccessModifier getAccModifier() {
        return _accModifier;
    }

    /**
     * Sets the access modifiers for the class
     * 
     * @param _accModifier The access modifiers for the interface.
     * @return The object itself.
     */
    public BJInterface setAccModifier(BJAccessModifier _accModifier) {
        this._accModifier = _accModifier;
        return this;
    }
}
