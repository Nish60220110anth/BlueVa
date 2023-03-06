package com.indua;

import java.util.ArrayList;

import com.indua.props.BJClass;
import com.indua.props.BJEnum;
import com.indua.props.BJInterface;

public class BJPackage {
    public static BJPackage CreateInstance(String _ppackageName) {
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

    public String GetPackageName() {
        return _packageName;
    }

    public ArrayList<BJClass> GetClassColl() {
        return _classColl;
    }

    public BJPackage SetClassColl(ArrayList<BJClass> _classColl) {
        this._classColl = _classColl;
        return this;
    }

    public ArrayList<BJEnum> GetEnumColl() {
        return _enumColl;
    }

    public BJPackage SetEnumColl(ArrayList<BJEnum> _enumColl) {
        this._enumColl = _enumColl;
        return this;
    }

    public ArrayList<BJInterface> GetInterfaceColl() {
        return _interfaceColl;
    }

    public BJPackage SetInterfaceColl(ArrayList<BJInterface> _interfaceColl) {
        this._interfaceColl = _interfaceColl;
        return this;
    }

    public ArrayList<String> GetClassNames() {
        return _classNames;
    }

    public BJPackage SetClassNames(ArrayList<String> _classNames) {
        this._classNames = _classNames;
        return this;
    }

    public ArrayList<String> GetEnumNames() {
        return _enumNames;
    }

    public BJPackage SetEnumNames(ArrayList<String> _enumNames) {
        this._enumNames = _enumNames;
        return this;
    }

    public ArrayList<String> GetInterfaceNames() {
        return _interfaceNames;
    }

    public BJPackage SetInterfaceNames(ArrayList<String> _interfaceNames) {
        this._interfaceNames = _interfaceNames;
        return this;
    }

    public BJPackage AddClass(BJClass _class) {
        this._classColl.add(_class);
        return this;
    }

    public BJPackage AddEnum(BJEnum _enum) {
        this._enumColl.add(_enum);
        return this;
    }

    public BJPackage AddInterface(BJInterface _interface) {
        this._interfaceColl.add(_interface);
        return this;
    }
}
