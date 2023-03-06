package com.indua.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.indua.props.BJBuildInterfaceOutput;
import com.indua.props.BJInterface;
import com.indua.props.BJMethodInterface;
import com.indua.props.BJParameter;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class BJInterfaceWriter {
    private BJInterface _interface;

    private BJInterfaceWriter(BJInterface _pinterface) throws IOException {
        _interface = _pinterface;
        PreCheck();
    }

    public static BJInterfaceWriter CreateInstance(BJInterface _pinterface) throws IOException {
        return new BJInterfaceWriter(_pinterface);
    }

    public BJBuildInterfaceOutput BuildContent() throws IOException {
        TypeSpec myinterface = CreateInterfaceSpec();
        JavaFile javaFile = JavaFile.builder(_interface.GetPackageName(), myinterface).build();

        javaFile.writeTo(GetFolderFile());

        return GenerateInterfaceOutput();
    }

    private void PreCheck() throws IOException {
        if (!Files.exists(Paths.get("output"))) {
            Files.createDirectory(Paths.get("output"));
        }
    }

    private File GetFolderFile() {
        return Paths.get("./output").toFile();
    }

    private BJBuildInterfaceOutput GenerateInterfaceOutput() {
        BJBuildInterfaceOutput interfaceOutput = BJBuildInterfaceOutput.CreateInstance()
                .SetInterfaceName(this._interface.GetName())
                .SetMessage(String.format("Interface %s.java successfully created", this._interface.GetName()))
                .SetBuildStatus(BJBuildStatus.SUCCESS);

        return interfaceOutput;
    }

    public TypeSpec CreateInterfaceSpec() {
        com.squareup.javapoet.TypeSpec.Builder interfaceBuilder = TypeSpec.interfaceBuilder(this._interface.GetName());
        interfaceBuilder = interfaceBuilder.addModifiers(Utility.GetAccessModifier(this._interface.GetAccModifiers()));

        interfaceBuilder = interfaceBuilder
                .addJavadoc(String.format("Hello , this is Sample Java doc for interface %s\n", this._interface.GetName())
                        + "@brief\nSome sample brief message");

        for (BJMethodInterface methodClass : this._interface.GetMethodColl()) {
            interfaceBuilder = interfaceBuilder.addMethod(CreateMethodSpec(methodClass));
        }

        for (String interfaceName : _interface.GetImplementingInterfaces()) {
            interfaceBuilder = interfaceBuilder
                    .addSuperinterface(Utility.GetTypeNameFromString(_interface.GetPackageName(),
                            interfaceName));
        }

        return interfaceBuilder.build();
    }

    public MethodSpec CreateMethodSpec(BJMethodInterface _methodInterface) {
        com.squareup.javapoet.MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_methodInterface.GetName());

        _methodBuilder = _methodBuilder.addModifiers(Utility.GetAccessModifier(_methodInterface.GetAccModifiers()),
                Utility.GetNonAccessModifierForMethod(_methodInterface.GetNaccModifiers()));

        _methodBuilder = _methodBuilder.returns(Utility.GetTypeNameForPrimTypes(_methodInterface.GetOutput()));

        for (BJParameter parameter : _methodInterface.GetParameterColl()) {
            _methodBuilder = _methodBuilder.addParameter(CreateParameterSpec(parameter));
        }

        _methodBuilder = _methodBuilder.addJavadoc(String.format("Sample Java doc for Method %s",
                _methodInterface.GetName()));

        return _methodBuilder.build();
    }

    public ParameterSpec CreateParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(
                Utility.GetTypeNameForPrimTypes(_parameter.GetOutput()),
                _parameter.GetName(),
                Utility.GetNonAccessModifierForParameter(_parameter.GetNaccModifier()));

        parameterBuilder = parameterBuilder.addJavadoc(
                String.format("Sample Java doc for %s", _parameter.GetName()));

        return parameterBuilder.build();
    }

}
