package com.jonasgreen.plastic.generator;

/**
 *
 */
public abstract class DefaultDSLPlugin implements DSLPlugin{

    protected OutputPaths outputPaths;

    public DefaultDSLPlugin(OutputPaths outputPaths) {
        this.outputPaths = outputPaths;
    }

}
