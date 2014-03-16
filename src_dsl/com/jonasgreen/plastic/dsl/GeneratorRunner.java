package com.jonasgreen.plastic.dsl;

import com.jonasgreen.plastic.generator.Generator;
import com.jonasgreen.plastic.generator.InputPaths;
import com.jonasgreen.plastic.generator.OutputPaths;
import com.jonasgreen.plastic.generator.PrintDSLPlugin;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class GeneratorRunner {

    public static void main(String[] args){
        Path dslRootDir = Paths.get("/Users/jonasgreen/GitHub/Plastic/src_dsl/com/jonasgreen/plastic/dsl");
        Path dslSrcDir = Paths.get("/Users/jonasgreen/GitHub/Plastic/src_dsl");

        Path modelRootDir = Paths.get("/Users/jonasgreen/GitHub/Plastic/src_model/com/jonasgreen/plastic/model");
        Path modelSrcDir = Paths.get("/Users/jonasgreen/GitHub/Plastic/src_model");

        Generator g = new Generator(new InputPaths(dslRootDir, dslSrcDir));
        g.addPlugin(new PrintDSLPlugin(new OutputPaths(modelRootDir, modelSrcDir)));

        g.generate();
    }

}
