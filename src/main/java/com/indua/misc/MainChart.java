package com.indua.misc;

import java.util.ArrayList;
import java.util.UUID;

import javax.lang.model.element.Modifier;

import com.indua.props.BJClass;
import com.indua.props.BJField;
import com.indua.props.BJId;
import com.indua.props.BJMethodClass;
import com.indua.props.BJParameter;
import com.indua.utils.BJAccessModifier;
import com.indua.utils.BJPrimTypes;

public class MainChart {
    private ArrayList<BJMethodClass> _methodColl;
    private ArrayList<BJField> _fieldColl;

    public static MainChart createInstance() {
        return new MainChart();
    }

    private MainChart() {
        _methodColl = new ArrayList<>();
        _fieldColl = new ArrayList<>();

        BJMethodClass mainMethod = BJMethodClass.createInstance().setAccModifier(BJAccessModifier.PUBLIC)
                .setName("main").setOutput(BJPrimTypes.VOID)
                .setNaccModifier(Modifier.STATIC)
                .setBjId(BJId.createInstance(UUID.randomUUID()))
                .addParameter(
                        BJParameter.createInstance().setName("args").setIsArray(true).setOutput(BJPrimTypes.STRING))
                .setCode("System.out.println(\"Hello Mom!\");");

        _methodColl.add(mainMethod);
    }

    public void FillBjClass(BJClass bjClass) {
        for(BJMethodClass method : _methodColl) {
            bjClass.addMethod(method);
        }

        for(BJField field : _fieldColl) {
            bjClass.addField(field);
        }
    }
}
