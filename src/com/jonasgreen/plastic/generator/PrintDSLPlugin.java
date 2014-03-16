package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.ClassDSL;
import com.jonasgreen.plastic.dsl.DSLEntity;
import com.jonasgreen.plastic.dsl.MemberDSL;
import com.jonasgreen.plastic.dsl.MemberListDSL;

import java.util.List;

/**
 *
 */
public class PrintDSLPlugin extends DefaultDSLPlugin{

    private int tab = 20;

    public PrintDSLPlugin(OutputPaths outputPaths) {
        super(outputPaths);
    }

    @Override
    public void handleDSLEntities(List<DSLEntity> entities) {
        for (DSLEntity entity : entities) {
            StringBuilder sb = new StringBuilder(entity.getClass().getSimpleName()).append("\n");
            if(entity instanceof ClassDSL){
                ClassDSL dsl = (ClassDSL) entity;
                for (MemberDSL m : dsl.getMembers()) {
                    sb.append("   - ").append(m.getName());
                    appendTab(sb, 5 + m.getName().length());
                    if(m instanceof MemberListDSL){
                        sb.append("[List<").append(m.getType().getSimpleName()).append(">]");
                    }
                    else{
                        sb.append("[").append(m.getType().getSimpleName()).append("]");
                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }

    private void appendTab(StringBuilder sb, int length) {
        int count = length;
        while (count++ < tab){
            sb.append(" ");
        }
    }
}
