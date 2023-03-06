package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;
import com.indua.utils.BJNAccessModifiersClass;

public class BJClass extends BJNode {

    public static BJClass CreateInstance(String _ppackageName) {
        return new BJClass(_ppackageName);
    }

    private String _extendingClass;
    private ArrayList<String> _implementingInterfaces;
    private BJAccessModifers _accModifiers;
    private BJNAccessModifiersClass _naccModifiers;
    private ArrayList<BJMethodClass> _methodColl;
    private ArrayList<BJField> _fieldColl;
    private final String _packageName;

    private BJClass(String _ppackageName) {
        _implementingInterfaces = new ArrayList<>();
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();
        _packageName = _ppackageName;

        _accModifiers = BJAccessModifers.DEFAULT;
        _naccModifiers = BJNAccessModifiersClass.DEFAULT;
    }

    public String GetPackageName() {
        return this._packageName;
    }

    public String GetExtendingClass() {
        return _extendingClass;
    }

    public BJClass SetExtendingInterfaces(String _extendingClass) {
        this._extendingClass = _extendingClass;
        return this;
    }

    public ArrayList<String> GetImplementingInterfaces() {
        return _implementingInterfaces;
    }

    public BJClass SetImplementingClasses(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJClass SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public BJNAccessModifiersClass GetNaccModifiers() {
        return _naccModifiers;
    }

    public BJClass SetNaccModifiers(BJNAccessModifiersClass _naccModifiers) {
        this._naccModifiers = _naccModifiers;
        return this;
    }

    public ArrayList<BJMethodClass> GetMethodColl() {
        return _methodColl;
    }

    public BJClass AddMethod(BJMethodClass _method) {
        this._methodColl.add(_method);
        return this;
    }

    public ArrayList<BJField> GetFieldColl() {
        return _fieldColl;
    }

    public BJClass SetFieldColl(ArrayList<BJField> _fieldColl) {
        this._fieldColl = _fieldColl;
        return this;
    }

    public String GetName() {
        return this._name;
    }

    public BJClass SetName(String _pname) {
        this._name = _pname;
        return this;
    }
}
