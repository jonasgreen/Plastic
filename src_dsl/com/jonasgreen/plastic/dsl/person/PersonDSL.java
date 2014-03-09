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
        member("parent", PersonDSL.class);

        member("firstName", Type.STRING);
        member("lastName", Type.STRING);
        member("age", Type.LONG);

        memberList("addresses", AddressDSL.class);
        memberList("children", PersonDSL.class);
    }


    public boolean isOverSixty(Person person){
        return person.getAge() > 60;
    }
}
