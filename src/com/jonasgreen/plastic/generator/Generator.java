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

    protected String inputDir;
    protected String outputDir;


    public Generator(String inputDir, String outputDir) {
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
        Path path = Paths.get(inputDir);

        DslFileVisitor visitor = new DslFileVisitor();
        Files.walkFileTree(path, visitor);
        return visitor.getEntities();
    }

    public static void main(String[] args){
        Generator g = new Generator("/Users/jonasgreen/GitHub/Plastic/src/com/jonasgreen/plastic/example/dsl", "");
    }
}
