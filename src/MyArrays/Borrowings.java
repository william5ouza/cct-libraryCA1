package MyArrays;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class Borrowings {
    
    private String borrowedBook;
    private String borrower;
    private String borroweddate;
    private String returneddate;

   
    public Borrowings (String borrowedBooks, String borrower, String borroweddate, String returneddate){
        this.borrowedBook = borrowedBooks;
        this.borrower = borrower;
        this.borroweddate = borroweddate;
        this.returneddate = returneddate;
    }
    
   
    public String getBorrowedBooks() {
        return borrowedBook;
    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorroweddate() {
        return borroweddate;
    }

    public void setBorroweddate(String borroweddate) {
        this.borroweddate = borroweddate;
    }

    public String getReturneddate() {
        return returneddate;
    }

    public void setReturneddate(String returneddate) {
        this.returneddate = returneddate;
    }
    

    @Override
    public String toString() {
        return "Borrowings{" + "borrowedBook=" + borrowedBook + ", borrower=" + borrower + ", borroweddate=" + borroweddate + ", returneddate=" + returneddate + '}';
    }

}