package com.jonasgreen.plastic.dsl.person;

import com.jonasgreen.plastic.dsl.ClassDSL;
import com.jonasgreen.plastic.dsl.Type;

/**
 *
 */
public class AddressDSL extends ClassDSL{
    @Override
    public void classDescription() {
        member("street", Type.STRING);
        member("streetNo", Type.LONG);
    }
}
