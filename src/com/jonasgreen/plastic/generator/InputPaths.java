package com.jonasgreen.plastic.generator;

import java.nio.file.Path;

/**
 *
 */
public class InputPaths {
    private Path dslRootDir;
    private Path dslSrcDir;

    public InputPaths(Path dslRootDir, Path dslSrcDir) {
        this.dslRootDir = dslRootDir;
        this.dslSrcDir = dslSrcDir;
    }


    public Path getDslRootDir() {
        return dslRootDir;
    }

    public Path getDslSrcDir() {
        return dslSrcDir;
    }
}
