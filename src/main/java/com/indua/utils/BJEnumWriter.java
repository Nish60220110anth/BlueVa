package com.indua.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.indua.props.BJBuildEnumOutput;
import com.indua.props.BJBuildStatus;
import com.indua.props.BJEnum;
import com.indua.props.BJValue;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

public class BJEnumWriter {
    /**
     * Create a new instance of the BJEnumWriter class, passing in the BJEnum object
     * that you want to
     * write to the file
     * 
     * @param _penum The enum to be written.
     * @return A new instance of BJEnumWriter.
     */
    public static BJEnumWriter createInstance(BJEnum _penum) throws IOException {
        return new BJEnumWriter(_penum);
    }

    private BJEnum _enum;

    private BJEnumWriter(BJEnum _penum) throws IOException {
        _preCheck();
    }

    /**
     * It creates a JavaFile object, writes it to a folder, and returns an object
     * that contains the name of
     * the file that was written
     * 
     * @return The return type is BJBuildEnumOutput.
     * @throws IOException
     */
    public BJBuildEnumOutput build() throws IOException {
        TypeSpec myenum = createEnumSpec();
        JavaFile javaFile = JavaFile.builder(_enum.getPackageName(), myenum).build();

        javaFile.writeTo(getFolderFile());

        return generateEnumOutput();
    }

    /**
     * It creates an enum type spec for a given enum
     * 
     * @return A TypeSpec object.
     */
    public TypeSpec createEnumSpec() {
        com.squareup.javapoet.TypeSpec.Builder enumBuilder = TypeSpec.enumBuilder(_enum.getName());

        enumBuilder = enumBuilder.addModifiers(Utility.getAccessModifierE(_enum.getAccModifier()));

        for (BJValue _value : _enum.getValueColl()) {
            enumBuilder = enumBuilder.addEnumConstant(_value.getName(),
                    TypeSpec.anonymousClassBuilder("$L", _value.getValue()).build());
        }

        return enumBuilder.build();
    }

    /**
     * If the output directory doesn't exist, create it
     */
    private void _preCheck() throws IOException {
        if (!Files.exists(Paths.get("./output"))) {
            Files.createDirectory(Paths.get("./output"));
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
     * It generates an enum output.
     * 
     * @return A BJBuildEnumOutput object.
     */
    private BJBuildEnumOutput generateEnumOutput() {
        BJBuildEnumOutput IntefaceOutput = BJBuildEnumOutput.createInstance()
                .setEnumName(_enum.getName())
                .setMessage(String.format("Inteface %s.java successfully created", this._enum.getName()))
                .setBuildStatus(BJBuildStatus.SUCCESS);

        return IntefaceOutput;
    }
}
