package com.indua.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.indua.props.BJBuildClassOutput;
import com.indua.props.BJClass;
import com.indua.props.BJField;
import com.indua.props.BJMethodClass;
import com.indua.props.BJParameter;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class BJClassWriter {
    private BJClass _class;

    private BJClassWriter(BJClass _pclass) throws IOException {
        _class = _pclass;
        PreCheck();
    }

    public static BJClassWriter CreateInstance(BJClass _pclass) throws IOException {
        return new BJClassWriter(_pclass);
    }

    public BJBuildClassOutput BuildContent() throws IOException {
        TypeSpec myclass = CreateClassSpec();
        JavaFile javaFile = JavaFile.builder(_class.GetPackageName(), myclass).build();

        javaFile.writeTo(GetFolderFile());

        return GenerateClassOutput();
    }

    private void PreCheck() throws IOException {
        if (!Files.exists(Paths.get("output"))) {
            Files.createDirectory(Paths.get("output"));
        }
    }

    private File GetFolderFile() {
        return Paths.get("./output").toFile();
    }

    private BJBuildClassOutput GenerateClassOutput() {
        BJBuildClassOutput classOutput = BJBuildClassOutput.CreateInstance()
                .SetClassName(this._class.GetName())
                .SetMessage(String.format("Class %s.java successfully created", this._class.GetName()))
                .SetBuildStatus(BJBuildStatus.SUCCESS);

        return classOutput;
    }

    private TypeSpec CreateClassSpec() {
        com.squareup.javapoet.TypeSpec.Builder classBuilder = TypeSpec.classBuilder(this._class.GetName());
        classBuilder = classBuilder.addModifiers(Utility.GetAccessModifier(this._class.GetAccModifiers()),
                Utility.GetNonAccessModifierForClass(this._class.GetNaccModifiers()));

        classBuilder = classBuilder
                .addJavadoc(String.format("Hello , this is Sample Java doc for class %s\n", this._class.GetName())
                        + "@brief\nSome sample brief message");

        classBuilder = classBuilder
                .superclass(
                        Utility.GetTypeNameFromString(_class.GetPackageName(), _class.GetExtendingClass()).getClass(),
                        true);

        classBuilder = classBuilder.addMethod(CreateConstructor());
        for (BJMethodClass methodClass : this._class.GetMethodColl()) {
            classBuilder = classBuilder.addMethod(CreateMethodSpec(methodClass));
        }

        for (BJField field : this._class.GetFieldColl()) {
            classBuilder = classBuilder.addField(CreateFieldSpec(field));
        }

        for (String interfaceName : _class.GetImplementingInterfaces()) {
            classBuilder = classBuilder.addSuperinterface(Utility.GetTypeNameFromString(_class.GetPackageName(),
                    interfaceName));
        }

        return classBuilder.build();
    }

    private MethodSpec CreateConstructor() {
        com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.constructorBuilder();

        methodBuilder = methodBuilder.addModifiers(Modifier.PUBLIC)
                .addStatement("String name = \"Shiva\";")
                .beginControlFlow("if ( name == \"Shiva\")")
                .addStatement("System.out.println(\"Hello Shiva\");")
                .endControlFlow();

        methodBuilder = methodBuilder.addJavadoc(String.format("Sample Constructor Java doc for Class %s", this._class
                .GetName()));

        return methodBuilder.build();
    }

    private MethodSpec CreateMethodSpec(BJMethodClass _methodClass) {

        com.squareup.javapoet.MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_methodClass.GetName());

        _methodBuilder = _methodBuilder.addModifiers(Utility.GetAccessModifier(_methodClass.GetAccModifiers()),
                Utility.GetNonAccessModifierForMethod(_methodClass.GetNaccModifiersMethods()));

        _methodBuilder = _methodBuilder.returns(Utility.GetTypeNameForPrimTypes(_methodClass.GetOutput()));

        for (BJParameter parameter : _methodClass.GetParameterColl()) {
            _methodBuilder = _methodBuilder.addParameter(CreateParameterSpec(parameter));
        }

        _methodBuilder = _methodBuilder.addJavadoc(String.format("Sample Java doc for Method %s %s",
                _methodClass.GetName(), _methodClass.GetBjId().GetId()));

        _methodBuilder = _methodBuilder.beginControlFlow("for (int i=0 ; i < 100 ; i++)")
                .addStatement(GetCodeFromId(_methodClass.GetBjId()))
                .beginControlFlow("if(i == 69)")
                .addStatement("System.out.println(\"I got 69\");")
                .nextControlFlow("else if( i == 9)")
                .addStatement("System.out.println(\"I got 9\");")
                .nextControlFlow("else")
                .addStatement("System.out.println(\"Oops Nothing\");")
                .endControlFlow();

        return _methodBuilder.build();
    }

    private ParameterSpec CreateParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder _parameterBuilder = ParameterSpec.builder(
                Utility.GetTypeNameForPrimTypes(_parameter.GetOutput()),
                _parameter.GetName(), Utility.GetNonAccessModifierForParameter(_parameter.GetNaccModifier()))
                .addJavadoc(
                        String.format("Sample Java doc for Parameter %s", _parameter.GetName()));

        return _parameterBuilder.build();
    }

    private FieldSpec CreateFieldSpec(BJField _field) {
        com.squareup.javapoet.FieldSpec.Builder fieldBuilder = FieldSpec.builder(
                Utility.GetTypeNameForPrimTypes(_field.GetOutput()),
                _field.GetName(), Utility.GetNonAccessModifierForField(_field.GetNaccModifiers()))
                .addJavadoc(String.format("Sample Jav doc for Field %s", _field.GetName()));

        return fieldBuilder.build();
    }

    private String GetCodeFromId(BJId bjId) {
        return String.format("System.out.println(\"Hello India\")\n");
    }

    /*
     * name="" output="" id="" accmod="" naccmod=""
     */
}
