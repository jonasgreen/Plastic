package com.jonasgreen.plastic.dsl;

/**
 *
 */
public class MemberDSL {

    protected String name;
    protected Class type;

    public MemberDSL(String name, Class type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class getType() {
        return type;
    }
}
