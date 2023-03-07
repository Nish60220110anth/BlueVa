package com.indua.layout;

import org.w3c.dom.Document;

import com.indua.BJPackage;
import com.indua.props.BJClass;
import com.indua.props.BJEnum;
import com.indua.props.BJField;
import com.indua.props.BJInterface;
import com.indua.props.BJMethod;
import com.indua.props.BJMethodClass;
import com.indua.props.BJMethodInterface;
import com.indua.props.BJMethodType;
import com.indua.props.BJParameter;

public class BJElementBuilder {

    private final Document _document;

    private BJElementBuilder(Document _pdocument) {
        _document = _pdocument;
    }

    public static BJElementBuilder createInstance(Document _pdocument) {
        return new BJElementBuilder(_pdocument);
    }

    public BJClassElemBuilder createClassBuilder(BJClass _pclass) {
        return new BJClassElemBuilder(_document, _pclass);
    }

    public BJEnumElemBuilder createEnumBuilder(BJEnum _penum) {
        return new BJEnumElemBuilder(_document, _penum);
    }

    public BJInterfaceElemBuilder createInterfaceBuilder(BJInterface _interface) {
        return new BJInterfaceElemBuilder(_document, _interface);
    }

    public BJMethodElemBuilder createMethodBuilder(BJMethodType _methodType, BJMethod _method) {
        if (_methodType == BJMethodType.CLASS) {
            return new BJMethodClassElemBuilder(_document, (BJMethodClass) _method);
        } else {
            return new BJMethodInterElemBuilder(_document, (BJMethodInterface) _method);
        }
    }

    public BJFieldElemBuilder createFieldBuilder(BJField _pfield) {
        return new BJFieldElemBuilder(_document, _pfield);
    }

    public BJPackageElemBuilder createPackageBuilder(BJPackage _ppackage) {
        return new BJPackageElemBuilder(_document, _ppackage);
    }

    public BJParameterElemBuilder createParameterBuilder(BJParameter _pparameter) {
        return new BJParameterElemBuilder(_document, _pparameter);
    }
}
