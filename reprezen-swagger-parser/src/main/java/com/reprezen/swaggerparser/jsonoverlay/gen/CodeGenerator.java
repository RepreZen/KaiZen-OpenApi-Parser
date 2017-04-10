/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.jsonoverlay.gen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Type;

public class CodeGenerator {

    public static void main(String[] args)
            throws JsonParseException, JsonMappingException, IOException, ParseException {
        Opts opts = new Opts(args);
        Object parsedYaml = new Yaml().load(new FileInputStream(opts.typeDataFile));
        TypeData typeData = new YAMLMapper().convertValue(parsedYaml, TypeData.class);
        typeData.init();
        new CodeGenerator(opts).generate(typeData);
    }

    private Opts opts;

    private CodeGenerator(Opts opts) {
        this.opts = opts;
    }

    private void generate(TypeData typeData) throws IOException {
        generateInterfaces(typeData);
        generateImpls(typeData);
        if (!opts.preserve) {
            System.err.println("WARNING: Preservation of non-generated code is suppressed!");
            System.err
                    .println("This is normally appropriate only when modifying the code generator and/or input data,");
            System.err.println("during which compilation errors are likely to be present in generated code.");
            System.err.println("");
            System.err.println("Please be sure to revert the generated code to a known good state and then regenerate");
            System.err.println("after completing modifications, so as to carry forward any non-generated code that");
            System.err.println("has been previously added.");
        }
    }

    private void generateInterfaces(TypeData typeData) throws IOException {
        File intfDir = getIntfDir();
        String intfPackage = getIntfPackage();
        String implPackage = getImplPackage();
        for (Type type : typeData.getTypes()) {
            if (type.isNoGen()) {
                return;
            }
            new InterfaceGenerator(intfDir, intfPackage, implPackage, "", opts.preserve).generate(type);
        }
    }

    private void generateImpls(TypeData typeData) throws IOException {
        File implDir = getImplDir();
        String intfPackage = getIntfPackage();
        String implPackage = getImplPackage();
        for (Type type : typeData.getTypes()) {
            if (type.isNoGen()) {
                return;
            }
            new ImplGenerator(implDir, intfPackage, implPackage, opts.classSuffix, opts.preserve).generate(type);
        }
    }

    private File getImplDir() {
        return new File(opts.topDir, opts.classDir.getPath());
    }

    private String getImplPackage() {
        return StringUtils.join(Arrays.asList(opts.pkg, opts.classPackage), ".");
    }

    private File getIntfDir() {
        return new File(opts.topDir, opts.interfaceDir.getPath());
    }

    private String getIntfPackage() {
        return StringUtils.join(Arrays.asList(opts.pkg, opts.interfacePackage), ".");
    }

    private static class Opts {
        private static Options options = new Options() //
                .addOption("t", "typeData", true, "type data file") //
                .addOption("d", "dir", true, "top-level generation directory") //
                .addOption("i", "interfaces", true, "directory to write interfaces") //
                .addOption("c", "classes", true, "directory to write implementation classes") //
                .addOption("p", "package", true, "containing package") //
                .addOption("I", "interface-package", true, "subpackage for interfaces") //
                .addOption("C", "class-package", true, "subpackage for classes") //
                .addOption("s", "suffix", true, "suffix for implementation classes") //
                .addOption("n", "noPreserve", false, "suppress preservation of non-genereated methods");

        public File topDir = new File(".");
        public File typeDataFile = new File("type-data.yaml");
        public String interfacePackage = "";
        public File interfaceDir = new File(".");
        public File classDir = new File("impl");
        public String pkg = CodeGenerator.class.getPackage().getName();
        public String classPackage = "impl";
        public String classSuffix = "Impl";
        public boolean preserve = true;

        public Opts(String[] args) throws ParseException {
            CommandLine cmd = new PosixParser().parse(options, args);
            if (cmd.hasOption('t')) {
                typeDataFile = new File(cmd.getOptionValue('t'));
            }
            if (cmd.hasOption('i')) {
                interfaceDir = new File(cmd.getOptionValue('i'));
            }
            if (cmd.hasOption('I')) {
                interfacePackage = cmd.getOptionValue('I');
            }
            if (cmd.hasOption('c')) {
                classDir = new File(cmd.getOptionValue('c'));
            }
            if (cmd.hasOption('C')) {
                classPackage = cmd.getOptionValue('C');
            }
            if (cmd.hasOption('s')) {
                classSuffix = cmd.getOptionValue('s');
            }
            if (cmd.hasOption('p')) {
                pkg = cmd.getOptionValue('p');
            }
            if (cmd.hasOption('n')) {
                preserve = false;
            }
        }
    }
}