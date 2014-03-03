package com.jonasgreen.plastic.example.dsl;

import com.jonasgreen.plastic.dsl.ClassDSL;
import com.jonasgreen.plastic.dsl.Type;

/**
 *
 */
public class PersonDSL extends ClassDSL {

    @Override
    public void classDescription() {
        member("parent", PersonDSL.class);

        member("firstName", Type.STRING);
        member("lastName", Type.STRING);
        member("age", Type.LONG);

        memberList("addresses", AddressDSL.class);
        memberList("children", PersonDSL.class);
    }
}
