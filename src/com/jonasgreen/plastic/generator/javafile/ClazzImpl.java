package com.jonasgreen.plastic.generator.javafile;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ClazzImpl extends JavaFileImpl implements Clazz {

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
