package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.DSLEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DslFileVisitor extends SimpleFileVisitor<Path> {

    private static String fileSep = java.nio.file.FileSystems.getDefault().getSeparator();
    private List<DSLEntity> entities = new ArrayList<>();

    private InputPaths inputPaths;


    public DslFileVisitor(InputPaths inputPaths) {
        this.inputPaths = inputPaths;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (!path.toString().endsWith(".java")) {
            return FileVisitResult.CONTINUE;
        }
        String clazz = inputPaths.getDslSrcDir().relativize(path).toString().replace(".java", "").replace(fileSep, ".");

        try {
            Class<?> dslClass = Class.forName(clazz);
            try {
                entities.add((DSLEntity) dslClass.newInstance());
            }
            catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return FileVisitResult.CONTINUE;
    }


    public List<DSLEntity> getEntities() {
        return entities;
    }
}
