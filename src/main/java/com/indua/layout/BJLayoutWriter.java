package com.indua.layout;

import com.indua.BJPackage;

public class BJLayoutWriter {
    private final BJPackage _package;

    private BJLayoutWriter(BJPackage _pppackage) {
        this._package = _pppackage;
    }

    public static BJLayoutWriter createInstance(BJPackage _ppackage) {
        return new  BJLayoutWriter(_ppackage);  
    }


}

/*
 * BJLayoutWriter mywriter = BJLayoutWriter.CreateInstance().SetClassColl(ArrayList<BJClass>)
 * . SetEnumColl(ArrayList<BJEnum>).SetInterfaceColl(ArrayList<BJInterface>).writeTo(Stream);
 */