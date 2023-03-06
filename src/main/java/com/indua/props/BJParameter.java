package com.indua.props;

import com.indua.utils.BJNAccessModifiersParameter;
import com.indua.utils.BJPrimTypes;

public class BJParameter {
    public static BJParameter CreateInstance() {
        return new BJParameter();
    }

    private String _name;
    private BJPrimTypes _output;
    private BJNAccessModifiersParameter _naccModifier;
    
    private BJParameter() {

    }
    public BJNAccessModifiersParameter GetNaccModifier() {
        return _naccModifier;
    }

    public void SetNaccModifier(BJNAccessModifiersParameter _naccModifier) {
        this._naccModifier = _naccModifier;
    }

    public String GetName() {
        return _name;
    }

    public BJParameter SetName(String _name) {
        this._name = _name;
        return this;
    }

    public BJPrimTypes GetOutput() {
        return _output;
    }

    public BJParameter SetOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }
}
