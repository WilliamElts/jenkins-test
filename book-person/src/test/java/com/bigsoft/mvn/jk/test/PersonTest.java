/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigsoft.mvn.jk.test;

import org.junit.Test;

/**
 *
 * @author william
 */
public class PersonTest {

    private final Person p;
    private final Book b1 = new Book("Test1", "William");
    private final Book b2 = new Book("Test2", "William");
    private final String FIRST_NAME = "William";
    private final String LAST_NAME = "Truong";

    public PersonTest() {
        this.p = new Person(FIRST_NAME, LAST_NAME);
    }

    @Test
    public void testSomeMethod() {
        this.p.boughtNew(b1);

        assert (this.p.hasBook(b1));
        assert (!this.p.giveAway(b2));
        this.p.boughtNew(b2);
        this.p.giveAway(b1);

        assert (!this.p.hasBook(b1));
        assert (!this.p.hasBook(b1));
    }

}
