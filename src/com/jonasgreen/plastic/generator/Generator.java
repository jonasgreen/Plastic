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
<<<<<<< HEAD
            List<DSLEntity> dslEntities = generateDSLTree();

            for (DSLPlugin plugin : plugins) {
                plugin.generate(dslEntities);
            }
=======
            List<DSLEntity> entities = getDSLEntities();
            build(entities);

            System.out.println(entities.size());
>>>>>>> parent of 29eb509... DSLStructure added
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

<<<<<<< HEAD
    private List<DSLEntity> generateDSLTree() throws IOException {
=======
    private List<DSLEntity> getDSLEntities() throws IOException {
>>>>>>> parent of 29eb509... DSLStructure added
        DslFileVisitor visitor = new DslFileVisitor(inputPaths);
        Files.walkFileTree(inputPaths.getDslRootDir(), visitor);
        return visitor.getEntities();
    }


}
