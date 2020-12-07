
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


/*
 This project is part of my BsC in Computing at CCT college Dublin

A library has come to you as a developer and outlined that currently they do not have any software to
track the different titles they have in stock, users of the library and borrowings. They have asked you
to develop a system which will allow them to do this. The library doesn’t have a budget for a
database, so your solution must implement a text file based system to ensure persistency of the data.

 */

/**
 *
 * @author William
 */
public class Main {
    
        public static void main (String[] args) throws IOException{
            
            System.out.println("HI, Welcome to this Library\n"+"In order to borrow a book, go to reader and select it by name or ID.\n"+"Once you select the reader, you can pick a book and borrow to the reader\n"+ "Enjoy your reading" );
        
        new LibraryMenu();
        
       
                
        }
}


        
