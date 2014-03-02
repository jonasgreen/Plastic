package com.jonasgreen.plastic.dsl;

/**
 *
 */
public class Type {

    private Class classType;


    public static Type STRING = new Type(String.class);
    public static Type LONG = new Type(Long.class);

    public Type(Class classType) {
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }
}
