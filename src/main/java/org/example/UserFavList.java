package org.example;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="user_fav_list")
public class UserFavList {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private String customFavoritName;

    @ManyToMany
    @JoinTable(
            name = "fav_books",
            joinColumns = @JoinColumn(name = "book_id") ,
            inverseJoinColumns = @JoinColumn(name ="favList_id")
    )
    private List<Books> books ;

    public UserFavList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomFavoritName() {
        return customFavoritName;
    }

    public void setCustomFavoritName(String customFavoritName) {
        this.customFavoritName = customFavoritName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "UserFavList{" +
                "id=" + id +
                ", customFavoritName='" + customFavoritName + '\'' +
                ", books=" + books +
                '}';
    }
}
