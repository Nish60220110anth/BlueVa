package com.indua.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.indua.props.BJBuildInterfaceOutput;
import com.indua.props.BJInterface;
import com.indua.props.BJMethodInterface;
import com.indua.props.BJParameter;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class BJInterfaceWriter {
    private BJInterface _interface;

    private BJInterfaceWriter (BJInterface _pinterface) throws IOException {
        _interface = _pinterface;
        PreCheck();
    }

    public static BJInterfaceWriter CreateInstance(BJInterface _pinterface) throws IOException {
        return new BJInterfaceWriter(_pinterface);
    }

    public BJBuildInterfaceOutput BuildContent() {

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
                .SetClassName(this._interface.GetName())
                .SetMessage(String.format("Interface %s.java successfully created", this._interface.GetName()))
                .SetBuildStatus(BJBuildStatus.SUCCESS);

        return interfaceOutput;
    }
    
    public TypeSpec CreateInterfaceSpec() {

    }

    public MethodSpec CreateMethodSpec(BJMethodInterface _method){
        com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(_method.GetName());


    }

    public ParameterSpec CreateParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(
            Utility.GetTypeNameForPrimTypes(_parameter.GetOutput()), 
            _parameter.GetName(), 
            Utility.GetNonAccessModifierForParameter(_parameter.GetNaccModifier()));

        parameterBuilder = parameterBuilder.addJavadoc(
            String.format("Sample Java doc for %s",_parameter.GetName())
        );

        return parameterBuilder.build();
    }


}
