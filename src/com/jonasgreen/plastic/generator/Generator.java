package com.jonasgreen.plastic.generator;

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
            DSLDirectory tree = generateDSLTree();

            for (DSLPlugin plugin : plugins) {
                plugin.generate(tree);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addPlugin(DSLPlugin p){
        plugins.add(p);
    }

    private DSLDirectory generateDSLTree() throws IOException {
        DslFileVisitor visitor = new DslFileVisitor(inputPaths);
        Files.walkFileTree(inputPaths.getDslRootDir(), visitor);
        return null;//visitor.getEntities();
    }


}
