/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigsoft.mvn.jk.test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author william
 */
public class Person {

    private Map<String, Book> shelf;
    private String fName;
    private String lName;

    public Map<String, Book> getShelf() {
        return shelf;
    }

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.shelf = new HashMap<>();
    }

    public void setShelf(Map<String, Book> shelf) {
        this.shelf = shelf;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void boughtNew(Book b) {
        this.shelf.put(b.getName(), b);
    }

    public boolean hasBook(String name) {
        return this.shelf.containsKey(name);
    }

    public boolean hasBook(Book b) {
        return hasBook(b.getName());
    }

    public boolean giveAway(String name) {
        if (hasBook(name)) {
            this.shelf.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean giveAway(Book b) {
        return giveAway(b.getName());
    }
}
