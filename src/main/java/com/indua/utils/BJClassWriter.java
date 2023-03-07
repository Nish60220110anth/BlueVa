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
    /**
     * Create a new instance of BJClassWriter, passing in the BJClass object that
     * was created in the
     * previous step.
     * 
     * @param _pclass The class to be written.
     * @return A new instance of BJClassWriter
     */
    public static BJClassWriter createInstance(BJClass _pclass) throws IOException {
        return new BJClassWriter(_pclass);
    }

    private BJClass _class;

    private BJClassWriter(BJClass _pclass) throws IOException {
        _class = _pclass;
        _preCheck();
    }

    /**
     * It creates a JavaFile object, writes it to a folder, and returns a
     * BJBuildClassOutput object
     * 
     * @return The return type is BJBuildClassOutput.
     */
    public BJBuildClassOutput build() throws IOException {
        TypeSpec myclass = createClassSpec();
        JavaFile javaFile = JavaFile.builder(_class.getPackageName(), myclass).build();

        javaFile.writeTo(getFolderFile());

        return generateClassOutput();
    }

    /**
     * If the output directory doesn't exist, create it
     */
    private void _preCheck() throws IOException {
        if (!Files.exists(Paths.get("output"))) {
            Files.createDirectory(Paths.get("output"));
        }
    }

    /**
     * Get the output folder as a File object.
     * 
     * @return A File object that represents the folder output.
     */
    private File getFolderFile() {
        return Paths.get("./output").toFile();
    }

    /**
     * `generateClassOutput()` creates a `BJBuildClassOutput` object and returns it
     * 
     * @return A BJBuildClassOutput object.
     */
    private BJBuildClassOutput generateClassOutput() {
        BJBuildClassOutput classOutput = BJBuildClassOutput.createInstance()
                .setClassName(this._class.getName())
                .setMessage(String.format("Class %s.java successfully created", this._class.getName()))
                .setBuildStatus(BJBuildStatus.SUCCESS);

        return classOutput;
    }

    /**
     * It creates a class spec for a class
     * 
     * @return A TypeSpec object.
     */
    private TypeSpec createClassSpec() {
        com.squareup.javapoet.TypeSpec.Builder classBuilder = TypeSpec.classBuilder(this._class.getName());
        classBuilder = classBuilder.addModifiers(Utility.getAccessModifier(this._class.getAccModifier()),
                Utility.getNonAccessModifierForClass(this._class.getNaccModifier()));

        classBuilder = classBuilder
                .addJavadoc(String.format("Hello , this is Sample Java doc for class %s\n", this._class.getName())
                        + "@brief\nSome sample brief message");

        classBuilder = classBuilder
                .superclass(
                        Utility.getTypeNameFromString(_class.getPackageName(), _class.getExtendingClass()).getClass(),
                        true);

        classBuilder = classBuilder.addMethod(createConstructor());
        for (BJMethodClass methodClass : this._class.getMethodColl()) {
            classBuilder = classBuilder.addMethod(createMethodSpec(methodClass));
        }

        for (BJField field : this._class.getFieldColl()) {
            classBuilder = classBuilder.addField(createFieldSpec(field));
        }

        for (String interfaceName : _class.getImplementingInterfaces()) {
            classBuilder = classBuilder.addSuperinterface(Utility.getTypeNameFromString(_class.getPackageName(),
                    interfaceName));
        }

        return classBuilder.build();
    }

    /**
     * It creates a constructor for the class
     * 
     * @return A MethodSpec object.
     */
    private MethodSpec createConstructor() {
        com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.constructorBuilder();

        methodBuilder = methodBuilder.addModifiers(Modifier.PUBLIC)
                .addStatement("String name = \"Shiva\";")
                .beginControlFlow("if ( name == \"Shiva\")")
                .addStatement("System.out.println(\"Hello Shiva\");")
                .endControlFlow();

        methodBuilder = methodBuilder.addJavadoc(String.format("Sample Constructor Java doc for Class %s", this._class
                .getName()));

        return methodBuilder.build();
    }

    /**
     * It creates a method spec for a given method class
     * 
     * @param _methodClass This is the class that holds all the information about
     *                     the method.
     * @return A MethodSpec object.
     */
    private MethodSpec createMethodSpec(BJMethodClass _methodClass) {

        com.squareup.javapoet.MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_methodClass.getName());

        _methodBuilder = _methodBuilder.addModifiers(Utility.getAccessModifier(_methodClass.getAccModifier()),
                Utility.getNonAccessModifierForMethod(_methodClass.getNaccModifier()));

        _methodBuilder = _methodBuilder.returns(Utility.getTypeNameForPrimTypes(_methodClass.getOutput()));

        for (BJParameter parameter : _methodClass.getParameterColl()) {
            _methodBuilder = _methodBuilder.addParameter(createParameterSpec(parameter));
        }

        _methodBuilder = _methodBuilder.addJavadoc(String.format("Sample Java doc for Method %s %s",
                _methodClass.getName(), _methodClass.getBjId().getId()));

        _methodBuilder = _methodBuilder.beginControlFlow("for (int i=0 ; i < 100 ; i++)")
                .addStatement(getCodeFromId(_methodClass.getBjId()))
                .beginControlFlow("if(i == 69)")
                .addStatement("System.out.println(\"I got 69\");")
                .nextControlFlow("else if( i == 9)")
                .addStatement("System.out.println(\"I got 9\");")
                .nextControlFlow("else")
                .addStatement("System.out.println(\"Oops Nothing\");")
                .endControlFlow();

        return _methodBuilder.build();
    }

    /**
     * It creates a ParameterSpec object for a given BJParameter object
     * 
     * @param _parameter This is the parameter object that contains the information
     *                   about the parameter.
     * @return A ParameterSpec object.
     */

    private ParameterSpec createParameterSpec(BJParameter _parameter) {
        com.squareup.javapoet.ParameterSpec.Builder _parameterBuilder = ParameterSpec.builder(
                Utility.getTypeNameForPrimTypes(_parameter.getOutput()),
                _parameter.getName(), Utility.getNonAccessModifierForParameter(_parameter.getNaccModifier()))
                .addJavadoc(
                        String.format("Sample Java doc for Parameter %s", _parameter.getName()));

        return _parameterBuilder.build();
    }

    /**
     * It creates a field spec for a given field
     * 
     * @param _field This is the field object that contains all the information
     *               about the field.
     * @return A FieldSpec object.
     */
    private FieldSpec createFieldSpec(BJField _field) {
        com.squareup.javapoet.FieldSpec.Builder fieldBuilder = FieldSpec.builder(
                Utility.getTypeNameForPrimTypes(_field.getOutput()),
                _field.getName(), Utility.getNonAccessModifierForField(_field.getNaccModifier()))
                .addJavadoc(String.format("Sample Jav doc for Field %s", _field.getName()));

        return fieldBuilder.build();
    }

    private String getCodeFromId(BJId bjId) {
        return String.format("System.out.println(\"Hello India\")\n");
    }

    /*
     * name="" output="" id="" accmod="" naccmod=""
     */
}
