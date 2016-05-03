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
public class BookTest {

    private final Book b;
    private final String BOOKNAME = "TestBook";
    private final String BOOKAUTHOR = "William";

    public BookTest() {
        b = new Book(BOOKNAME, BOOKAUTHOR);
    }

    @Test
    public void testSomeMethod() {
        assert (b.getName().equals(BOOKNAME));
        assert (b.getAuthor().equals(BOOKAUTHOR));
    }

}
