package com.jonasgreen.plastic.generator;

import com.jonasgreen.plastic.dsl.DSLEntity;

import java.util.List;

/**
 *
 */
public interface DSLPlugin {

    public void handleDSLEntities(List<DSLEntity> entities);
}
