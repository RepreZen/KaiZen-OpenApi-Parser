package com.reprezen.swaggerparser;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator;

public class GenSwagger3 {
    public static void main(String[] args)
            throws JsonParseException, JsonMappingException, IOException, ParseException {
        CodeGenerator.main(new String[] { //
                "-t", "types3.yaml", //
                "-p", "com.reprezen.swaggerparser", //
                "-i", "model3", //
                "-I", "model3", //
                "-c", "impl3", //
                "-C", "impl3" //
                // , "-n" // uncomment to run in no-preserve mode
        });
    }
}
