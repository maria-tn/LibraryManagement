package org.example;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@DiscriminatorValue("borrow_is_permitted")
public class BorrowPermittedBook extends Books {

    private int maxLength;


    public BorrowPermittedBook(String title , Author author , Boolean available  , int maxLength){
        super(title , author , available);
        this.maxLength = maxLength;
    }
    public BorrowPermittedBook(){
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        return "BorrowPermittedBook{" +
                "maxLength=" + maxLength +
                '}';
    }
}
