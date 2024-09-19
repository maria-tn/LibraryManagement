package org.example;

import jakarta.persistence.*;

public class AddFunktionen {
    EntityManagerFactory emf ;

    AddFunktionen(EntityManagerFactory emf){
        this.emf = emf;
    }
    public void addSomeBooks(){

        EntityManager emBook = emf.createEntityManager();

        emBook.getTransaction().begin();

        Author jkRolling = new Author("JK Rolling" , 56 ,177);
        emBook.persist(jkRolling);

        Author goethe = new Author("Goethe" , 96 , 432 );
        emBook.persist(goethe);

        BorrowNotPermittedBook newBorrowNotPermittedBook = new BorrowNotPermittedBook("foo" ,jkRolling , true , 7);
        emBook.persist(newBorrowNotPermittedBook);

        BorrowNotPermittedBook newBorrowNotPermittedBook2 = new BorrowNotPermittedBook("welt" , jkRolling , true ,6 );
        emBook.persist(newBorrowNotPermittedBook2);

        BorrowPermittedBook newBorrowPermittedBook2 = new BorrowPermittedBook("poem" , goethe, true , 30);
        emBook.persist(newBorrowPermittedBook2);

        BorrowPermittedBook newBorrowPermittedBook1 = new BorrowPermittedBook("HarryPotter", jkRolling , true,30);
        emBook.persist(newBorrowPermittedBook1);

        BorrowNotPermittedBook newBorrowNotPermittedBook1 = new BorrowNotPermittedBook("JenaHistory" , goethe , true , 2);
        emBook.persist(newBorrowNotPermittedBook1);


        emBook.getTransaction().commit();
        emBook.close();
    }

    public void addSomeUser(){

        EntityManager emUser = emf.createEntityManager();


        emUser.getTransaction().begin();

        Users newUser1 = new Users();
        newUser1.setName("maxi");
        newUser1.setEmail("maxi@mail.com");
        LibraryProfileForPerson profile1= new LibraryProfileForPerson(202401,"max_101");
        /*emUser.persist(profile1);*/
        /*newUser1.setLibraryProfile(profile1);*/
        emUser.persist(newUser1);

        Users newUser2 = new Users();
        newUser2.setName("Allexi");
        newUser2.setEmail("Allexi@mail.com");
        LibraryProfileForPerson profile2= new LibraryProfileForPerson(202402,"allex_102");
        /*emUser.persist(profile2);*/
        /*newUser2.setLibraryProfile(profile2);*/
        emUser.persist(newUser2);

        Users newUser3 = new Users();
        newUser3.setName("martini");
        newUser3.setEmail("martini@mail.com");
        LibraryProfileForPerson profile3= new LibraryProfileForPerson(202403,"martin_103");
        /*emUser.persist(profile3);*/
        /*newUser3.setLibraryProfile(profile3);*/
        emUser.persist(newUser3);

        emUser.getTransaction().commit();
        emUser.close();

    }


}
