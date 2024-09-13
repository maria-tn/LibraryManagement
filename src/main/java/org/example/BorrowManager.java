package org.example;

import jakarta.persistence.*;

import java.sql.Date;


public class BorrowManager {
    EntityManagerFactory emf;

    BorrowManager(EntityManagerFactory emf){
        this.emf = emf ;
    }


    public void borrow(String user_name , String book_name){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query getUser = em.createQuery("SELECT user FROM Users user WHERE user.name = :user_name");
        getUser.setParameter("user_name" , user_name);
        Users myUser = (Users) getUser.getSingleResult();
        int user_id = myUser.getId();
        int user_borrowedNum = myUser.getBorrowedNum();

        Query getBook = em.createQuery("SELECT book FROM Books book WHERE book.title =: book_name");
        getBook.setParameter("book_name" , book_name);
        Books myBook = (Books) getBook.getSingleResult();
        int book_id = myBook.getId();
        Boolean bookAvailable = myBook.getAvailable();

        if(bookAvailable){

            if(user_borrowedNum<3){
                user_borrowedNum = user_borrowedNum + 1;
                myUser.setBorrowedNum(user_borrowedNum);
                em.persist(myUser);

                myBook.setAvailable(false);
                em.persist(myBook);


                java.util.Date today = new java.util.Date();
                Date date = new Date(today.getTime());

                BorrowedRecords brwRcrd = new BorrowedRecords();
                brwRcrd.setBookId(book_id);
                brwRcrd.setUserId(user_id);
                brwRcrd.setBorrowDate(date);
                em.persist(brwRcrd);

            }else{
                System.out.println("User has already 3 Books");
            }
        }else {
            System.out.println("Book is not available");
        }

        em.getTransaction().commit();
        em.close();
    }







}
