package com.indua.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.indua.props.BJBuildClassOutput;
import com.indua.props.BJClass;

public class BJClassWriter {
    private BJClass _class;

    private BJClassWriter() throws IOException {
        _class = BJClass.CreateInstance();
        PreCheck();
    }

    private void PreCheck() throws IOException {
        if (!Files.exists(Paths.get("output"))) {
            Files.createDirectory(Paths.get("output"));
        }
    }

    public BJBuildClassOutput BuildContent() {
         
    }

}
