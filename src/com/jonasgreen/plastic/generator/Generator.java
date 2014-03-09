package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.DSLEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Generator {

    protected InputPaths inputPaths;

    protected List<DSLPlugin> plugins = new ArrayList<>();

    public Generator(InputPaths inputPaths) {
        this.inputPaths = inputPaths;
    }

    public void generate(){
        try {
            List<DSLEntity> entities = getDSLEntities();
            build(entities);

            System.out.println(entities.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void build(List<DSLEntity> entities) {
        for (DSLPlugin plugin : plugins) {
            plugin.handleDSLEntities(entities);
        }
    }

    public void addPlugin(DSLPlugin p){
        plugins.add(p);
    }

    private List<DSLEntity> getDSLEntities() throws IOException {
        DslFileVisitor visitor = new DslFileVisitor(inputPaths);
        Files.walkFileTree(inputPaths.getDslRootDir(), visitor);
        return visitor.getEntities();
    }


}
