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

    private List<DSLEntity> entities = new ArrayList<>();

    private Path inputPath;


    public DslFileVisitor() {
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (!path.toString().endsWith(".java")) {
            return FileVisitResult.CONTINUE;
        }
        String packageName = getPackage(path.toFile());

        try {
            Class<?> dslClass = Class.forName((packageName.trim() +"." +path.toFile().getName().replace(".java", "")));
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

    private String getPackage(File javaFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(javaFile))) {
            String line = br.readLine();

            while (line != null) {
                if (line.startsWith("package")) {
                    String trimmed = line.substring(7);
                    return trimmed.substring(0, trimmed.indexOf(";"));
                }
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<DSLEntity> getEntities() {
        return entities;
    }
}
