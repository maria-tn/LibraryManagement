package org.example;


import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String email ;
    @Lob
    private byte[] user_image ;

    @OneToOne
    @JoinColumn(name="library_id" , referencedColumnName = "library_id")
    private LibraryProfileForPerson libraryProfile;

    public LibraryProfileForPerson getLibraryProfile() {
        return libraryProfile;
    }

    public void setLibraryProfile(LibraryProfileForPerson libraryProfile) {
        this.libraryProfile = libraryProfile;
    }
    public int getBorrowedNum() {
        return borrowedNum;
    }

    public void setBorrowedNum(int borrowedNum) {
        this.borrowedNum = borrowedNum;
    }

    private int borrowedNum ;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getUser_image() {
        return user_image;
    }

    public void setUser_image(byte[] user_image) {
        this.user_image = user_image;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", user_image=" + Arrays.toString(user_image) +
                '}';
    }
}
