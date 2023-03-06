package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;

public class BJInterface {
    public static BJInterface CreateInstance(String _ppackageName) {
        return new BJInterface(_ppackageName);
    }

    /*
     * name="" implements="" accmod=""
     */
    private String _name;

    private ArrayList<String> _implementingInterfaces;

    private BJAccessModifers _accModifiers;

    private final String _packageName;
    private ArrayList<BJMethodInterface> _methodColl;
    private BJInterface(String _ppackageName) {
        _implementingInterfaces = new ArrayList<>();
        _methodColl = new ArrayList<>();
        this._packageName = _ppackageName;
    }
    public ArrayList<BJMethodInterface> GetMethodColl() {
        return _methodColl;
    }

    public BJInterface AddMethod(BJMethodInterface _method) {
        this._methodColl.add(_method);
        return this;
    }

    public String GetPackageName() {
        return this._packageName;
    }

    public String GetName() {
        return _name;
    }

    public BJInterface SetName(String _name) {
        this._name = _name;
        return this;
    }

    public ArrayList<String> GetImplementingInterfaces() {
        return _implementingInterfaces;
    }

    public BJInterface SetImplementingInterfaces(ArrayList<String> _implementingInterfaces) {
        this._implementingInterfaces = _implementingInterfaces;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJInterface SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }
}
