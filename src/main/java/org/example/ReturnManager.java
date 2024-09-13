package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.time.Period;

public class ReturnManager {

    EntityManagerFactory emf;
    ReturnManager(EntityManagerFactory emf){
        this.emf = emf;
    }
    public void calculatePenalty(String book_title){
        EntityManager em = emf.createEntityManager();

        Query getBookQuery = em.createQuery("SELECT books FROM Books books WHERE books.title = :title");
        getBookQuery.setParameter("title" , book_title);
        Books myBook = (Books) getBookQuery.getSingleResult();
        int myBookId = myBook.getId();

        Query checkBorrowTable = em.createQuery("SELECT brwRcrd FROM BorrowedRecords brwRcrd WHERE brwRcrd.bookId =: bookId");
        checkBorrowTable.setParameter("bookId" , myBookId);
        BorrowedRecords brwRcrd = (BorrowedRecords) checkBorrowTable.getSingleResult();

        int user_id = brwRcrd.getUserId();
        Query findUser = em.createQuery("SELECT users FROM Users users WHERE users.id = :user_id");
        findUser.setParameter("user_id" , user_id);
        Users myUser = (Users) findUser.getSingleResult();

        int totalDaysOfBorrow = Period.between( brwRcrd.getBorrowDate().toLocalDate() ,  LocalDate.now()).getDays();

        if(totalDaysOfBorrow>30){
            int penalty = (totalDaysOfBorrow-30)*2;
            System.out.println(penalty + "should be paid");
        }else {
            System.out.println("returned");
        }
        em.getTransaction().begin();

        em.remove(brwRcrd);
        myBook.setAvailable(true);
        em.persist(myBook);
        myUser.setBorrowedNum(myUser.getBorrowedNum()-1);


        em.getTransaction().commit();
        em.close();
    }






}
