package com.jonasgreen.plastic.example.dsl;

import com.jonasgreen.plastic.dsl.ClassDSL;
import com.jonasgreen.plastic.dsl.Type;

/**
 *
 */
public class PersonDSL extends ClassDSL {

    @Override
    public void classDescription() {

        member("firstName", STRING);
        member("lastName", STRING);
        member("age", LONG);

        member("parent", PersonDSL.class);

        memberList("addresses", AddressDSL.class);
        memberList("children", PersonDSL.class);
    }
}
