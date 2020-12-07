
import MyArrays.Books;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class ListingBooks {


    Scanner sc = new Scanner(System.in);
    String bookSearch;
    ArrayList<Books> books = loadBooks();

   
    private String tempBook;
    
    public String getTempBook() {
        return tempBook;
    }
   
    
    
    public ListingBooks() throws IOException{
    
        boolean menu1 = false;    
    do{
    
    int option;   
       System.out.println("");
       System.out.println("\tBooks");
       System.out.println("Please select one of the following options");
       System.out.println("");
       System.out.println("1 -\tList all  books by title");
       System.out.println("2 -\tList all books by authors");
       System.out.println("3 -\tBorrow or return a book");
       System.out.println("4-\tReturn to main menu");
       System.out.println("5-\tExit");
       
       option = sc.nextInt();
       
        switch (option) {
            case 1:
                ListBooksInAlphabeticOrder(books);
                new ListingBooks();
                
               
                break;
                
            case 2:
                
                ListAuthorsAlphabetically(books);
                
                new ListingBooks();
                
                break;
                
            case 3:
                
                    BorrowByBook();
                 
               
                break;
                
            case 4:
                
                new LibraryMenu();
               
               
                break;    
                
            case 5:
               System.out.println("Thank you for using our library");
               menu1 = true;
               break ;
                
             default:
                System.out.println("Please enter with a valid option");
                return;
        } 
               
        }while(true);
   }
    public int BorrowByBook() throws IOException{
      
            boolean menu2 = false;    
    do{
              int option1;     
                System.out.println("Press 1 - borrow a book by title");            
                System.out.println("Press 2 - borrow a book by author");
                System.out.println("Press 3 - show book queue");
                System.out.println("Press 4 - Return to the previous menu");
                System.out.println("Press 5 - Return to the previous menu");
                System.out.println("Press 6 - Return to the main menu");
                
                
                
                
                option1 = sc.nextInt();
                
                switch (option1) {
                    case 1:
                        srcBookbyTitle(books);
                        break;
                    case 2:
                        srcBookbyAuthor(books, bookSearch, tempBook);
                        break;
                    case 3:
                        //BookQueue(books, tempBook, tempBook);
                        break;
                    case 4:
                        new ListingBooks();
                        break;    
                    case 5:
                        new LibraryMenu();
                        break;
                    case 6:
                        menu2 = true;
                        break;   
                    default:
                        System.out.println("Please press a valid option");
                        break;
                }
                return option1;
            }while(true);
        
    
     
    }
    
    public ArrayList <Books> loadBooks() throws FileNotFoundException, IOException {
        
       ArrayList <Books> books = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader("Books.txt"));
        String contentReader = br.readLine();
        try {
            String[] data;
            int id;
            String title;
            String author;
            
           
            while((contentReader != null)) {
              data = contentReader.split("\t");
              id = Integer.parseInt(data[0]);
              title = data[1];
              author = data[2];
              
              
              books.add(new Books(id, title, author));
              contentReader = br.readLine();
            }
        } catch (IOException ex) {
        
        Logger.getLogger(ListingBooks.class.getName()).log(Level.SEVERE, null, ex);
    
    }
       
         return books;
        
    }
    public String srcBookbyTitle(ArrayList<Books> books) throws IOException {
        
    System.out.println("Enter the Books's name");
    bookSearch = sc.next();    
    for(int i = 0; i < books.size(); i++){
    
    // When the element is found, stop the loop and return the index
       
            if(books.get(i).getTitle().contains(bookSearch)){
        //if(borrowings.get(i).getBorrowedBook().contains(bookSearch)){
           // System.out.println(borrowings.get(i).getBorrowedBook());
       tempBook = books.get(i).getTitle();      
       System.out.println(books.get(i).getID()+ " " + books.get(i).getTitle()+ " " + books.get(i).getAuthor());
       
    }
            new LibraryMenu();
    }
   
    return tempBook;
    }
    public String srcBookbyAuthor(ArrayList<Books> books, String bookSearch, String tempBook) throws IOException {
    System.out.println("Enter the Author's name");
    System.out.println("");
    bookSearch = sc.next();
    
    for(int i = 0; i < books.size(); i++){
    
    // When the element is found, stop the loop and return the index
    if(books.get(i).getAuthor().contains(bookSearch)){
        
        tempBook = books.get(i).getTitle();
        System.out.println(books.get(i).getID()+ " " +  books.get(i).getAuthor()+" " + books.get(i).getTitle());
        
    }
        new LibraryMenu();
        
    }
    return tempBook;
    }
    public int ListBooksInAlphabeticOrder(ArrayList<Books> books ){
        //This part sort all books in the array by titles's alphabetically
            String temp;
            int count = books.size();
            String str[] = new String [count];
           
           for(int i = 0; i < count; i++){
              
           }
           
           for(int i = 0; i < count; i++){
               
               str[i] = books.get(i).getTitle()+ " | " + books.get(i).getAuthor()+ " | " + books.get(i).getID();
                       }
           
           for(int i = 0; i< count; i++){
               for(int j = i+1; j < count; j++ ) {
                   
                   if(str[i].compareTo(str[j])>0){
                      
                       temp = str[i];
                       str[i] = str[j];
                       str[j] = temp;
                       
                   }
               }
               
           }  
           System.out.println("Tiltle\t" + "Author\t" + "ID");
           for(int i = 0; i <= count -1; i++){
               
               
               System.out.println(str[i]);
                   
               }          
        
        return 0;
    }
    public int ListAuthorsAlphabetically(ArrayList<Books> books ){
        
        //This part sort books by title
           String temp;
           int count = books.size();
           String str[] = new String [count];
           
           
           
           for(int i = 0; i < count; i++){
               
           }
           
           for(int i = 0; i < count; i++){
               
               str[i] = books.get(i).getAuthor() + " | " + books.get(i).getTitle() + " | " + books.get(i).getID();
                       }
           
           for(int i = 0; i< count; i++){
               for(int j = i+1; j < count; j++ ) {
                   
                   if(str[i].compareTo(str[j])>0){
                      
                       temp = str[i];
                       str[i] = str[j];
                       str[j] = temp;
                       
                   }
               }
           }  
           System.out.println("Author\t" + "Title\t" + "ID");
           for(int i = 0; i <= count -1; i++){
               
               System.out.println(str[i]);
                   
               }
        
        return 0;
    }
    /*public int addBorrowingByBook(String tempBook) throws IOException  {
    
    String tempReader = new ListingReaders().getTempReader();
    
    try{
    
    FileWriter fstream = new FileWriter("borrowings.txt",true);
    BufferedWriter out = new BufferedWriter(fstream);
    out.write(tempReader + "\t"+ tempBook  +"\t"+ new java.util.Date()+"\n");
    out.close();
    }catch (Exception e){
    System.err.println("Error while writing to file: " +
    e.getMessage());
    
    }
    return 0;
    }*/
    public Queue BookQueue (Books books, String tempBook, String tempReader){
            
            Queue <String>book_Q = new LinkedList<>();
            
        
             try {
                BufferedReader br = new BufferedReader(new FileReader("borrowings.txt"));
                String line;
                tempBook = books.getTitle();
                while((line = br.readLine()) != null){
                    if(null != line && line.contains(tempBook)) {
                        book_Q.add(tempReader);
                        return book_Q;
                    }
                }
                 System.out.println("print Q" + book_Q);
             } catch (IOException ex) {
                 System.out.println(ex);
             }
        return book_Q;
        
    }   
   
    
    }

    
   
