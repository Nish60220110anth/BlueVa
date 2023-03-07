package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifiers;
import com.indua.utils.BJNAccessModifiersClass;

public class BJClass extends BJNode {

    /**
     * This function creates a new instance of the BJClass class, and returns it
     * 
     * @param _ppackageName The package name of the class.
     * @return A new instance of BJClass.
     */
    public static BJClass createInstance(String _ppackageName) {
        return new BJClass(_ppackageName);
    }

    private String _extendingClass;
    private ArrayList<String> _implementingInterfaces;
    private BJAccessModifiers _accModifiers;
    private BJNAccessModifiersClass _naccModifiers;
    private ArrayList<BJMethodClass> _methodColl;
    private ArrayList<BJField> _fieldColl;
    private final String _packageName;

    private BJClass(String _ppackageName) {
        _implementingInterfaces = new ArrayList<>();
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();
        _packageName = _ppackageName;

        _accModifiers = BJAccessModifiers.DEFAULT;
        _naccModifiers = BJNAccessModifiersClass.DEFAULT;
    }

    /**
     * Returns the package name
     * 
     * @return The package name.
     */
    public String getPackageName() {
        return this._packageName;
    }

    /**
     * It returns the name of the class that is extending the current class.
     * 
     * @return The extending class.
     */
    public String getExtendingClass() {
        return _extendingClass;
    }

    /**
     * This function sets the extending class of the class
     * 
     * @param _extendingClass The class that this class extends.
     * @return The class itself.
     */
    public BJClass setExtendingInterfaces(String _extendingClass) {
        this._extendingClass = _extendingClass;
        return this;
    }

    /**
     * This function returns an ArrayList of Strings that contains the names of all
     * the interfaces that
     * the class implements
     * 
     * @return An ArrayList of Strings.
     */
    public ArrayList<String> getImplementingInterfaces() {
        return _implementingInterfaces;
    }

    /**
     * This function sets the implementing classes of the class
     * 
     * @param _implementingInterfaces The list of interfaces that this class
     *                                implements.
     * @return The class itself.
     */
    public BJClass setImplementingClasses(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    }

    /**
     * > Returns the access modifiers of the current class
     * 
     * @return The access modifiers of the class.
     */
    public BJAccessModifiers getAccModifiers() {
        return _accModifiers;
    }

    /**
     * This function sets the access modifiers of the class to the access modifiers
     * passed in as a
     * parameter.
     * 
     * @param _accModifiers The access modifiers for the class.
     * @return The object itself.
     */
    public BJClass setAccModifiers(BJAccessModifiers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    /**
     * This function returns the value of the private variable _naccModifiers
     * 
     * @return The value of the variable _naccModifiers.
     */

    public BJNAccessModifiersClass getNaccModifiers() {
        return _naccModifiers;
    }

    /**
     * "This function sets the value of the private variable _naccModifiers to the
     * value of the parameter
     * _naccModifiers."
     * 
     * @param _naccModifiers The access modifiers for the class.
     * @return The object itself.
     */
    public BJClass setNaccModifiers(BJNAccessModifiersClass _naccModifiers) {
        this._naccModifiers = _naccModifiers;
        return this;
    }

    /**
     * This function returns the ArrayList of BJMethodClass objects that are stored
     * in the _methodColl
     * variable.
     * 
     * @return An ArrayList of BJMethodClass objects.
     */
    public ArrayList<BJMethodClass> getMethodColl() {
        return _methodColl;
    }

    /**
     * This function adds a method to the class
     * 
     * @param _method The method to add to the class.
     * @return The class itself.
     */
    public BJClass addMethod(BJMethodClass _method) {
        this._methodColl.add(_method);
        return this;
    }

    /**
     * Returns the field collection
     * 
     * @return An ArrayList of BJField objects.
     */
    public ArrayList<BJField> getFieldColl() {
        return _fieldColl;
    }

    /**
     * This function sets the value of the fieldColl field to the value of the
     * _fieldColl parameter
     * 
     * @param _fieldColl The collection of fields that are in the class.
     * @return The class itself.
     */
    public BJClass setFieldColl(ArrayList<BJField> _fieldColl) {
        this._fieldColl = _fieldColl;
        return this;
    }

    /**
     * Returns the name of the class
     * 
     * @return The name of the person.
     */
    public String getName() {
        return this._name;
    }

    /**
     * "This function sets the name of the class to the value of the parameter
     * passed in."
     * 
     * Now, let's look at the function in more detail
     * 
     * @param _pname The name of the class
     * @return The class itself.
     */
    public BJClass setName(String _pname) {
        this._name = _pname;
        return this;
    }
}
