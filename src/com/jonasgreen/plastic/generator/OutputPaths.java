package com.jonasgreen.plastic.generator;

import java.nio.file.Path;

/**
 *
 */
public class OutputPaths {
    private Path generatedModelRootDir;
    private Path generatedModelSrcDir;

    public OutputPaths(Path generatedModelRootDir, Path generatedModelSrcDir) {
        this.generatedModelRootDir = generatedModelRootDir;
        this.generatedModelSrcDir = generatedModelSrcDir;
    }


    public Path getGeneratedModelRootDir() {
        return generatedModelRootDir;
    }

    public Path getGeneratedModelSrcDir() {
        return generatedModelSrcDir;
    }
}
