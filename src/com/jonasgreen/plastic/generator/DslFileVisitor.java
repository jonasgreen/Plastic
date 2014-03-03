package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.DSLEntity;

import java.io.File;
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

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        String fileName = path.toFile().getName();
        try {
            Class<?> dslClass = Class.forName(fileName);
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
