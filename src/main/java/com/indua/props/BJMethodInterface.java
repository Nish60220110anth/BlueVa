package com.indua.props;

import java.util.ArrayList;

import com.indua.utils.BJAccessModifers;
import com.indua.utils.BJNAccessModifiersMethod;
import com.indua.utils.BJPrimTypes;

public class BJMethodInterface {
    /*
     * name="" input="" output="" accmod="" naccmod=""
     */

    public static BJMethodInterface CreateInstance() {
        return new BJMethodInterface();
    }

    private String _name;
    private ArrayList<BJParameter> _inputs;
    private BJPrimTypes _output;
    private BJAccessModifers _accModifiers;
    private BJNAccessModifiersMethod _naccModifiers;

    private BJMethodInterface() {

    }

    public String GetName() {
        return _name;
    }

    public BJMethodInterface SetName(String _name) {
        this._name = _name;
        return this;
    }

    public ArrayList<BJParameter> GetInputs() {
        return _inputs;
    }

    public BJMethodInterface SetInputs(ArrayList<BJParameter> _inputs) {
        this._inputs = _inputs;
        return this;
    }

    public BJPrimTypes GetOutput() {
        return _output;
    }

    public BJMethodInterface SetOutput(BJPrimTypes _output) {
        this._output = _output;
        return this;
    }

    public BJAccessModifers GetAccModifiers() {
        return _accModifiers;
    }

    public BJMethodInterface SetAccModifiers(BJAccessModifers _accModifiers) {
        this._accModifiers = _accModifiers;
        return this;
    }

    public BJNAccessModifiersMethod GetNaccModifiers() {
        return _naccModifiers;
    }

    public BJMethodInterface SetNaccModifiers(BJNAccessModifiersMethod _naccModifiers) {
        this._naccModifiers = _naccModifiers;
        return this;
    }
}
