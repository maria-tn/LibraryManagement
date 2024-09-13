package org.example;


import jakarta.persistence.*;


@Entity
@Table(name="library_profile")
public class LibraryProfileForPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;


    @Column(name="library_id")
    private int libraryID;

    @Column(name="library_User_name")
    private String libraryUN ;



    public LibraryProfileForPerson(int libraryID , String libraryUN){
        this.libraryID= libraryID;
        this.libraryUN= libraryUN;
    }


    public LibraryProfileForPerson(){

    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public String getLibraryUN() {
        return libraryUN;
    }

    public void setLibraryUN(String libraryUN) {
        this.libraryUN = libraryUN;
    }

    @Override
    public String toString() {
        return "LibraryProfileForPerson{" +
                "id=" + id +
                ", libraryID=" + libraryID +
                ", libraryUN='" + libraryUN + '\'' +
                '}';
    }
}
