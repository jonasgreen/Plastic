package com.jonasgreen.plastic.generator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DSLDirectory extends DSLStructure{
    private List<DSLStructure> children = new ArrayList<>();





    public List<DSLStructure> getChildren(){
        return children;
    }
}
