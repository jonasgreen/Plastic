package com.jonasgreen.plastic.dsl.person;

import com.jonasgreen.plastic.dsl.CommandDSL;

/**
 *
 */
public class CreatePersonCommandDSL extends CommandDSL {
    @Override
    public void classDescription() {
        member("person", PersonDSL.class);
    }
}
