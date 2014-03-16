package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.DSLEntity;

import java.io.IOException;
import java.nio.file.Files;
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
            List<DSLEntity> dslEntities = generateDSLTree();

            for (DSLPlugin plugin : plugins) {
                plugin.generate(dslEntities);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addPlugin(DSLPlugin p){
        plugins.add(p);
    }

    private List<DSLEntity> generateDSLTree() throws IOException {
        DslFileVisitor visitor = new DslFileVisitor(inputPaths);
        Files.walkFileTree(inputPaths.getDslRootDir(), visitor);
        return visitor.getEntities();
    }


}
