package com.jonasgreen.plastic.generator.javafile;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
<<<<<<< HEAD:src/com/jonasgreen/plastic/generator/javafile/ClazzImpl.java
public class ClazzImpl extends JavaFileImpl implements Clazz {
=======
public class ClassImpl extends JavaFileImpl implements Class {
>>>>>>> parent of 29eb509... DSLStructure added:src/com/jonasgreen/plastic/generator/javafile/ClassImpl.java

    protected List<Method> methods = new ArrayList<>();
    protected List<Constructor> constructors = new ArrayList<>();
    protected List<Field> fields = new ArrayList<>();








    public void add(Method method){
        methods.add(method);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        for (Method m : methods) {
            m.renderInto(sb);
        }
        return sb.toString();
    }
}
