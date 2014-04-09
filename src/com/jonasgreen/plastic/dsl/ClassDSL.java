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

    public void member(String name, Class type) {
        addMember(name, type);
    }

    public void memberList(String name, Class type) {
        addMemberList(name, type);
    }

    protected void addMember(String name, Class type){
        members.add(new MemberDSL(name, type));
    }

    protected void addMemberList(String name, Class type){
        members.add(new MemberListDSL(name, type));
    }

    public List<MemberDSL> getMembers() {
        return members;
    }
}
