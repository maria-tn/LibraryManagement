package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.h2.tools.Server;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

        Server webServer = Server.createWebServer().start();
        Server server = Server.createTcpServer().start();


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