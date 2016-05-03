/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigsoft.mvn.jk.test.store;

import com.bigsoft.mvn.jk.test.Book;
import com.bigsoft.mvn.jk.test.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author william
 */
public class Store {

    private final Person merchant;
    private final Map<String, Book> availBooks;

    public Store(Person merchant, Map<String, Book> availBooks) {
        this.merchant = merchant;
        this.availBooks = availBooks;
    }

    public void sell(Person p, Book b) {
        synchronized (lock) {
            if (availBooks.containsKey(b.getName())) {
                p.boughtNew(b);
                availBooks.remove(b.getName());
                System.out.println("Sold: " + b.getName());
            }
        }
    }

    public Book pickBook() {
        Set<String> s = this.availBooks.keySet();
        int size = s.size();
        int item = new Random().nextInt(size);
        int i = 0;
        String bookName = null;
        for (String obj : s) {
            if (i == item) {
                bookName = obj;
                break;
            }
            i = i + 1;
        }
        return this.availBooks.get(bookName);
    }

    private final Object lock = new Object();

    public void newBook(Book b) {
        synchronized (lock) {
            if (b != null) {
                availBooks.put(b.getName(), b);
            }
        }
    }

    public int getAvailBookCount() {
        return this.availBooks.size();
    }

    public static void main(String[] args) {
        Person merchant = new Person("New", "Merchant");
        Map<String, Book> availBooks = new HashMap<>();
        Store store = new Store(merchant, availBooks);
        initStore(store);
        Person customer = new Person("Customer", "Name");
        store.sell(customer, store.pickBook());
        System.out.println("Remaining books: " + store.getAvailBookCount());
    }

    private static void initStore(Store store) {
        Book b1 = new Book("Book 1", "Author 1");
        Book b2 = new Book("Book 2", "Author 2");
        Book b3 = new Book("Book 3", "Author 3");
        Book b10 = new Book("Book 10", "Author 10");
        Book b11 = new Book("Book 11", "Author 11");
        store.newBook(b1);
        store.newBook(b2);
        store.newBook(b3);
        store.newBook(b10);
        store.newBook(b11);
        System.out.println("Total books: " + store.getAvailBookCount());
    }
}
