package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

        AddFunktionen add = new AddFunktionen(emf);
        add.addSomeBooks();
        add.addSomeUser();
        BorrowManager borrow = new BorrowManager(emf);
        borrow.borrow("maxi" , "foo");
        borrow.borrow("Allexi" , "poem");
        borrow.borrow("maxi" , "welt");

        ReturnManager returnManager = new ReturnManager(emf);
        returnManager.calculatePenalty("welt");



        emf.close();
        System.out.println("Hello world!");


    }
}