package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.DSLEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 */
public class Generator {

    protected Path inputDir;
    protected Path outputDir;

    public Generator(Path inputDir, Path outputDir) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
    }

    public void generate(){
        try {
            List<DSLEntity> entities = getDSLEntities();
            System.out.println(entities.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<DSLEntity> getDSLEntities() throws IOException {
        DslFileVisitor visitor = new DslFileVisitor();
        Files.walkFileTree(inputDir, visitor);
        return visitor.getEntities();
    }

    public static void main(String[] args){
        Path inputPath = Paths.get("/Users/jonasgreen/GitHub/Plastic/src/com/jonasgreen/plastic/example/dsl");
        Generator g = new Generator(inputPath, null);
        g.generate();
    }
}
