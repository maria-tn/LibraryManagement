package org.example;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@DiscriminatorValue("borrow_is_not_permitted")
public class BorrowNotPermittedBook extends Books{

    private int roomNumber ;

    public BorrowNotPermittedBook(String title , Author author , Boolean available  , int roomNumber){
        super(title , author , available);
        this.roomNumber=roomNumber;
    }

    public BorrowNotPermittedBook(){
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "BorrowNotPermittedBook{" +
                "roomNumber=" + roomNumber +
                '}';
    }
}
