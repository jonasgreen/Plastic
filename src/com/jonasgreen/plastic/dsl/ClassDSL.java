package com.jonasgreen.plastic.dsl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class ClassDSL implements DSLEntity {

    protected List<MemberDSL> members = new ArrayList<>();

    protected ClassDSL() {
        classDescription();
    }

    public abstract void classDescription();

    public void member(String name, Type type) {
        addMember(name, type.getClassType());
    }


    public <T extends DSLEntity> void member(String name, Class<T> type) {
        addMember(name, type);
    }

    public <T extends DSLEntity> void memberList(String name, Class<T> type) {
        addMemberList(name, type);
    }

    public void memberList(String name, Type type) {
        addMemberList(name, type.getClassType());
    }

    protected void addMember(String name, Class type){
        members.add(new MemberDSL(name, type));
    }

    protected void addMemberList(String name, Class type){
        members.add(new MemberListDSL(name, type));
    }
}
