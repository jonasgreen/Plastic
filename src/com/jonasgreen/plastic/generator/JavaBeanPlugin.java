package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.*;
import com.jonasgreen.plastic.generator.javafile.*;

import java.util.List;

/**
 *
 */
public class JavaBeanPlugin extends DefaultDSLPlugin {


    public JavaBeanPlugin(OutputPaths outputPaths) {
        super(outputPaths);
    }

    @Override
    public void generate(List<DSLEntity> entities) {
        for (DSLEntity entity : entities) {
            if (entity instanceof InterfaceDSL) {
                writeToDisk(handleInterface((InterfaceDSL) entity));
            }
            else if (entity instanceof AbstractClassDSL) {
                writeToDisk(handleAbstractClass((AbstractClassDSL) entity));
            }
            else if (entity instanceof ClassDSL) {
                writeToDisk(handleClass((ClassDSL) entity));
            }
            else {
                System.out.println("WARNING: " + entity.getClass().getName() + " is not supported in JavaBeanPlugin");
            }
        }
    }

    protected JavaFile handleInterface(InterfaceDSL dsl) {

    }

    protected JavaFile handleClass(ClassDSL dsl) {
        Clazz clazz = new ClazzImpl();
        return clazz;
    }

    protected JavaFile handleAbstractClass(AbstractClassDSL dsl) {

    }

    protected void writeToDisk(JavaFile file) {
        file.render();
    }

}
