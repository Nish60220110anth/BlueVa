package com.indua.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.indua.props.BJBuildEnumOutput;
import com.indua.props.BJEnum;
import com.indua.props.BJEnumValue;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

public class BJEnumWriter {
    private BJEnum _enum;

    private BJEnumWriter(BJEnum _penum) throws IOException {
        PreCheck();
    }

    public static BJEnumWriter CreateInstance(BJEnum _penum) throws IOException {
        return new BJEnumWriter(_penum);
    }

    public BJBuildEnumOutput BuildContent() throws IOException {
        TypeSpec myenum = CreateEnumSpec();
        JavaFile javaFile = JavaFile.builder(_enum.GetPackageName(), myenum).build();

        javaFile.writeTo(GetFolderFile());

        return GenerateEnumOutput();
    }

    private void PreCheck() throws IOException {
        if (!Files.exists(Paths.get("./output"))) {
            Files.createDirectory(Paths.get("./output"));
        }
    }

    private File GetFolderFile() {
        return Paths.get("./output").toFile();
    }

    private BJBuildEnumOutput GenerateEnumOutput() {
        BJBuildEnumOutput IntefaceOutput = BJBuildEnumOutput.CreateInstance()
                .SetEnumName(_enum.GetName())
                .SetMessage(String.format("Inteface %s.java successfully created", this._enum.GetName()))
                .SetBuildStatus(BJBuildStatus.SUCCESS);

        return IntefaceOutput;
    }

    public TypeSpec CreateEnumSpec() {
        com.squareup.javapoet.TypeSpec.Builder enumBuilder = TypeSpec.enumBuilder(_enum.GetName());

        enumBuilder = enumBuilder.addModifiers(Utility.GetAccessModifier(_enum.GetAccModifiers()));

        for (BJEnumValue _value : _enum.GetEnumvaluesColl()) {
          enumBuilder =   enumBuilder.addEnumConstant(_value.GetName(),
                    TypeSpec.anonymousClassBuilder("$L", _value.GetValue()).build());
        }

        return enumBuilder.build();
    }
}
