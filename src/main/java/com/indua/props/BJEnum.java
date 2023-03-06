package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;

public class BJEnum {
    public static BJEnum CreateInstance(String _ppackageName) {
        return new BJEnum(_ppackageName);
    }
    public static ArrayList<BJEnumValue> GenerateEnumValues(ArrayList<String> _enumStr , Boolean reqDefault) {
        ArrayList<BJEnumValue> _enumValues = new ArrayList<>();
        int count = 1;
        _enumValues.add(BJEnumValue.CreateInstance().SetName("DEFAULT").SetValue(0));

        for(String str : _enumStr) {
            _enumValues.add(BJEnumValue.CreateInstance().SetName(str).SetValue(count));
            count += 1;
        }

        return _enumValues;
    }

    private String _name;
    private BJAccessModifers _accModifiers;
    private ArrayList<BJEnumValue> _enumvaluesColl;
    private final String _packageName;

    private BJEnum(String _ppackageName) {
        _enumvaluesColl = new ArrayList<>();
        this._packageName = _ppackageName;
    }

    public String GetPackageName() {
        return this._packageName;
    }

    public String GetName() {
        return _name;
    }

    public BJEnum SetName(String _name) {
        this._name = _name;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJEnum SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public ArrayList<BJEnumValue> GetEnumvaluesColl() {
        return _enumvaluesColl;
    }

    public BJEnum SetEnumvaluesColl(ArrayList<BJEnumValue> _enumvaluesColl) {
        this._enumvaluesColl = _enumvaluesColl;
        return this;
    }
}
