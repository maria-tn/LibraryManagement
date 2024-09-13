package org.example;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name;
    private int age ;

    @Column(name="number_of_books")
    private int bookNum;

    @OneToMany(mappedBy = "author")
    private List<Books> books;

    public Author(String name , int age , int bookNum){
        this.name = name ;
        this.age= age ;
        this.bookNum= bookNum;
    }

    public Author(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bookNum=" + bookNum +
                '}';
    }

}
