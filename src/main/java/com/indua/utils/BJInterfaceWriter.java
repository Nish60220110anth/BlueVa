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
    /**
     * This function creates a new instance of the BJInterfaceWriter class
     * 
     * @param _pinterface The interface to write.
     * @return A new instance of BJInterfaceWriter
     */
    public static BJInterfaceWriter createInstance(BJInterface _pinterface) throws IOException {
        return new BJInterfaceWriter(_pinterface);
    }

    private BJInterface _interface;

    private BJInterfaceWriter(BJInterface _pinterface) throws IOException {
        _interface = _pinterface;
        _preCheck();
    }

    /**
     * Builds the interface
     * 
     * @return The return type is BJBuildInterfaceOutput.
     */
    public BJBuildInterfaceOutput build() throws IOException {
        TypeSpec myinterface = createInterfaceSpec();
        JavaFile javaFile = JavaFile.builder(_interface.getPackageName(), myinterface).build();

        javaFile.writeTo(getFolderFile());

        return generateInterfaceOutput();
    }

    /**
     * This function creates a Java interface using the JavaPoet library
     * 
     * @return A TypeSpec object.
     */
    public TypeSpec createInterfaceSpec() {
        com.squareup.javapoet.TypeSpec.Builder interfaceBuilder = TypeSpec.interfaceBuilder(this._interface.getName());
        interfaceBuilder = interfaceBuilder.addModifiers(Utility.getAccessModifier(this._interface.getAccModifier()));

        interfaceBuilder = interfaceBuilder
                .addJavadoc(
                        String.format("Hello , this is Sample Java doc for interface %s\n", this._interface.getName())
                                + "@brief\nSome sample brief message");

        for (BJMethodInterface methodClass : this._interface.getMethodColl()) {
            interfaceBuilder = interfaceBuilder.addMethod(createMethodSpec(methodClass));
        }

        for (String interfaceName : _interface.getImplementingInterfaces()) {
            interfaceBuilder = interfaceBuilder
                    .addSuperinterface(Utility.getTypeNameFromString(_interface.getPackageName(),
                            interfaceName));
        }

        return interfaceBuilder.build();
    }

    /**
     * It creates a method spec for a given method interface
     * 
     * @param _methodInterface This is the interface that contains the method
     *                         details.
     * @return A MethodSpec object.
     */
    public MethodSpec createMethodSpec(BJMethodInterface _methodInterface) {
        com.squareup.javapoet.MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_methodInterface.getName());

        _methodBuilder = _methodBuilder.addModifiers(Utility.getAccessModifier(_methodInterface.getAccModifier()),
                Utility.getNonAccessModifierForMethod(_methodInterface.getNaccModifier()));

        _methodBuilder = _methodBuilder.returns(Utility.getTypeNameForPrimTypes(_methodInterface.getOutput()));

        for (BJParameter parameter : _methodInterface.getParameterColl()) {
            _methodBuilder = _methodBuilder.addParameter(createParameterSpec(parameter));
        }

        _methodBuilder = _methodBuilder.addJavadoc(String.format("Sample Java doc for Method %s",
                _methodInterface.getName()));

        return _methodBuilder.build();
    }

    /**
     * It creates a parameter spec for a given parameter
     * 
     * @param _parameter This is the parameter object that contains the information
     *                   about the parameter.
     * @return A ParameterSpec object.
     */
    public ParameterSpec createParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(
                Utility.getTypeNameForPrimTypes(_parameter.getOutput()),
                _parameter.getName(),
                Utility.getNonAccessModifierForParameter(_parameter.getNaccModifier()));

        parameterBuilder = parameterBuilder.addJavadoc(
                String.format("Sample Java doc for %s", _parameter.getName()));

        return parameterBuilder.build();
    }

    /**
     * If the directory "output" doesn't exist, create it
     */
    private void _preCheck() throws IOException {
        if (!Files.exists(Paths.get("output"))) {
            Files.createDirectory(Paths.get("output"));
        }
    }

    /**
     * It returns a `File` object that represents the folder `output` in the current
     * working directory
     * 
     * @return A File object that represents the output folder.
     */

    private File getFolderFile() {
        return Paths.get("./output").toFile();
    }

    /**
     * This function creates an instance of the BJBuildInterfaceOutput class, sets
     * the interface name,
     * message, and build status, and returns the instance
     * 
     * @return An instance of BJBuildInterfaceOutput.
     */

    private BJBuildInterfaceOutput generateInterfaceOutput() {
        BJBuildInterfaceOutput interfaceOutput = BJBuildInterfaceOutput.createInstance()
                .setInterfaceName(this._interface.getName())
                .setMessage(String.format("Interface %s.java successfully created", this._interface.getName()))
                .setBuildStatus(BJBuildStatus.SUCCESS);

        return interfaceOutput;
    }

}
