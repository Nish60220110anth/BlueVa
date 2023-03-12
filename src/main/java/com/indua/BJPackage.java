package com.indua;

import java.util.ArrayList;

import com.indua.props.BJClass;
import com.indua.props.BJEnum;
import com.indua.props.BJInterface;

public class BJPackage {
    /**
     * // Java
     * public static BJPackage createInstance(String _ppackageName) {
     * BJPackage packageLayout = new BJPackage(_ppackageName);
     * return packageLayout;
     * }
     * 
     * @param _ppackageName The name of the package.
     * @return A new instance of BJPackage.
     */
    public static BJPackage createInstance(String _ppackageName) {
        BJPackage packageLayout = new BJPackage(_ppackageName);

        return packageLayout;
    }

    private final String _packageName;
    private ArrayList<BJClass> _classColl;
    private ArrayList<BJEnum> _enumColl;

    private ArrayList<BJInterface> _interfaceColl;
    private ArrayList<String> _classNames;
    private ArrayList<String> _enumNames;

    private ArrayList<String> _interfaceNames;

    private BJPackage(String _ppackageName) {
        _classColl = new ArrayList<>();
        _interfaceColl = new ArrayList<>();
        _enumColl = new ArrayList<>();

        _packageName = _ppackageName;

        _classNames = new ArrayList<>();
        _enumNames = new ArrayList<>();
        _interfaceNames = new ArrayList<>();
    }

    /**
     * // Java
     * public String getPackageName() {
     * return _packageName;
     * }
     * 
     * @return The package name.
     */
    public String getName() {
        return _packageName;
    }

    /**
     * This function returns the collection of classes
     * 
     * @return An ArrayList of BJClass objects.
     */
    public ArrayList<BJClass> getClassColl() {
        return _classColl;
    }

    /**
     * This function sets the class collection of the package
     * 
     * @param _classColl The collection of classes in the package.
     * @return The object itself.
     */
    public BJPackage setClassColl(ArrayList<BJClass> _classColl) {
        this._classColl = _classColl;
        return this;
    }

    /**
     * This function returns the value of the private variable _enumColl
     * 
     * @return An ArrayList of BJEnum objects.
     */

    public ArrayList<BJEnum> getEnumColl() {
        return _enumColl;
    }

    /**
     * This function sets the value of the private variable _enumColl to the value
     * of the parameter
     * _enumColl
     * 
     * @param _enumColl An ArrayList of BJEnum objects.
     * @return The object itself.
     */

    public BJPackage setEnumColl(ArrayList<BJEnum> _enumColl) {
        this._enumColl = _enumColl;
        return this;
    }

    /**
     * This function returns the collection of interfaces that are associated with
     * this object.
     * 
     * @return An ArrayList of BJInterface objects.
     */
    public ArrayList<BJInterface> getInterfaceColl() {
        return _interfaceColl;
    }

    /**
     * This function sets the value of the _interfaceColl variable to the value of
     * the _interfaceColl
     * variable passed in as a parameter.
     * 
     * @param _interfaceColl ArrayList of BJInterface objects
     * @return The object itself.
     */
    public BJPackage setInterfaceColl(ArrayList<BJInterface> _interfaceColl) {
        this._interfaceColl = _interfaceColl;
        return this;
    }

    /**
     * // Java
     * 
     * public ArrayList<String> getClassNames() {
     * return _classNames;
     * }
     * 
     * @return An ArrayList of Strings.
     */

    public ArrayList<String> getClassNames() {
        return _classNames;
    }

    /**
     * It sets the class names of the package.
     * 
     * @param _classNames The list of class names that are in the package.
     * @return The object itself.
     */
    public BJPackage setClassNames(ArrayList<String> _classNames) {
        this._classNames = _classNames;
        return this;
    }

    /**
     * This function returns an ArrayList of Strings that contains the names of the
     * enumerations
     * 
     * @return An ArrayList of Strings.
     */
    public ArrayList<String> getEnumNames() {
        return _enumNames;
    }

    /**
     * This function sets the value of the private variable _enumNames to the value
     * of the parameter
     * _enumNames
     * 
     * @param _enumNames The names of the enums in the package.
     * @return The object itself.
     */

    public BJPackage setEnumNames(ArrayList<String> _enumNames) {
        this._enumNames = _enumNames;
        return this;
    }

    /**
     * This function returns an ArrayList of Strings that contains the names of all
     * the interfaces that the
     * class implements
     * 
     * @return An ArrayList of Strings.
     */

    public ArrayList<String> getInterfaceNames() {
        return _interfaceNames;
    }

    /**
     * This function sets the interface names of the package
     * 
     * @param _interfaceNames The list of interfaces that the package implements.
     * @return The object itself.
     */
    public BJPackage setInterfaceNames(ArrayList<String> _interfaceNames) {
        this._interfaceNames = _interfaceNames;
        return this;
    }

    /**
     * Adds a class to the package
     * 
     * @param _class The class to add to the package.
     * @return The BJPackage object.
     */
    public BJPackage addClass(BJClass _class) {
        this._classColl.add(_class);
        return this;
    }

    /**
     * AddEnum() adds an enum to the enum collection.
     * 
     * @param _enum The enum to add to the package
     * @return The BJPackage object.
     */

    public BJPackage addEnum(BJEnum _enum) {
        this._enumColl.add(_enum);
        return this;
    }

    /**
     * This function adds an interface to the interface collection.
     * 
     * @param _interface The interface to add to the package.
     * @return The BJPackage object.
     */
    public BJPackage addInterface(BJInterface _interface) {
        this._interfaceColl.add(_interface);
        return this;
    }
}

/*
 * BJPackage _package =
 * BJPackage.createInstance(PackageString).addClass(BJClass).addEnum(BJEnum).
 * addInterface(BJInterface);
 * 
 * Used this stack of function calls to add class / enum / interface to the
 * package object
 */
