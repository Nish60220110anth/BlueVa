package com.indua.props;

import com.indua.utils.BJNAccessModifiersParameter;
import com.indua.utils.BJPrimTypes;

public class BJParameter {
    public static BJParameter createInstance() {
        return new BJParameter();
    }

    private String _name;
    private BJPrimTypes _output;
    private BJNAccessModifiersParameter _naccModifier;

    private BJParameter() {

    }

    public BJNAccessModifiersParameter getNaccModifier() {
        return _naccModifier;
    }

    public void getNaccModifier(BJNAccessModifiersParameter _naccModifier) {
        this._naccModifier = _naccModifier;
    }

    public String getName() {
        return _name;
    }

    public BJParameter setName(String _name) {
        this._name = _name;
        return this;
    }

    public BJPrimTypes getOutput() {
        return _output;
    }

    public BJParameter setOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }
}
