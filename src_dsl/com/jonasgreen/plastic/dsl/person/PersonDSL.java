package com.jonasgreen.plastic.dsl.person;

import com.jonasgreen.plastic.dsl.ClassDSL;
import com.jonasgreen.plastic.dsl.Type;
import com.jonasgreen.plastic.example.person.Person;

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
