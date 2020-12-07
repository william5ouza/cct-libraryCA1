/*
 * @author William
 

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import MyArrays.Borrowings;
import MyArrays.Readers;
import com.sun.javadoc.Doclet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apont
 */
public class ListingReaders {
    
    Scanner sc = new Scanner(System.in);
    String userSearch;
   private  String tempReader;
   ArrayList<Readers> readers = loadReaders();
    int IdSearch;

    public static void main (String [] args) throws IOException{
        new ListingReaders();
    }
    public ListingReaders() throws IOException {
      
    boolean menu = false;    
    do{
    int option;   
    
       
       System.out.println("");
       System.out.println("\tReaders");
       System.out.println("Please select one of the following options");
       System.out.println("");
       System.out.println("1 -\tList all readers by ID number");
       System.out.println("2 -\tList all readers in alphabetic order");
       System.out.println("3 -\tBorrow or return a book by name or ID");
       System.out.println("4-\tReturn to main menu");
       System.out.println("5-\tExit");
       
       option = sc.nextInt();
       
        switch (option) {
            case 1:
                ListReadersbyIDOrder(readers);
                System.out.println("");
                System.out.println("What would you like to do now");
                
               
                break;
                
            case 2:
                System.out.println("");
                ListReadersInAlphabeticOrder(readers);
                System.out.println("");
                
                break;
                
            case 3:
                System.out.println("");
                    BorrowByReader();
                 System.out.println("");
               
                break;
                
            case 4:
                System.out.println("");
                new LibraryMenu();
               System.out.println("");
               
                break;    
                
            case 5:
               System.out.println("Thank you for using our library");
               menu = true;
               break ;
                
             default:
                System.out.println("Please enter with a valid option");
                return;
        } 
               
        }while(!menu);
    
     
   } 

    /**
     *
     * @throws IOException
     */
    public int BorrowByReader () throws IOException {
           boolean menu = false;
            do{
                System.out.println("Press 1 - Search by Name");            
                System.out.println("Press 2 - Search by ID");
                System.out.println("Press 3 - show reader's history");
                System.out.println("Press 4 - Return a book");
                System.out.println("Press 5 - Return to the previous menu");
                System.out.println("Press 6 - Return to the main menu");
                
                
                int option = sc.nextInt();
               
                switch (option) {
                    case 1:
                        SearchByName(readers, tempReader, tempReader);
                        break;

                    case 2:
                        SearchByID(readers, tempReader);
                        break;
                    case 3:
                        //ShowReaderActivity(borrowings, tempReader);
                        break;
                    case 4:
                        addReturn(tempReader);
                        break;        
                    case 5:
                        new ListingBooks();
                        break;    
                    case 6:
                        new LibraryMenu();
                        menu = true;
                        break;    
                    default:
                        System.out.println("Please press a valid option");
                        break;
                }
            }while(!menu);
        
     return 0;
    }
    public ArrayList <Readers> loadReaders() throws FileNotFoundException, IOException {
        
        ArrayList <Readers> readers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("Readers.txt"));
        String contentReader = br.readLine();
       
        try {
            String[] data;
            int id;
            String name;
            String surname;
           
            while((contentReader != null)) {
              data = contentReader.split(",");
              id = Integer.parseInt(data[0]);
              name = data[1];
              surname = data[2];
              
              readers.add(new Readers(id, name, surname));
              contentReader = br.readLine();    
            }
            
        }
        
        catch (IOException ex) {
        
        Logger.getLogger(ListingReaders.class.getName()).log(Level.SEVERE, null, ex);
    
    }  
         return readers;
        
    }
    public int ListReadersInAlphabeticOrder(ArrayList<Readers> array ){
        //This part sort all books in the array by Readers's names
            String temp;
            int count = array.size();
            String str[] = new String [count];
           
           for(int i = 0; i < count; i++){
           }
           for(int i = 0; i < count; i++){
               
               str[i] = array.get(i).getName()+ " | " + array.get(i).getSurname()+ " | " + array.get(i).getId();
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
           System.out.println("Name\t" + "Surname\t" + "ID");
           for(int i = 0; i <= count -1; i++){
                System.out.println(str[i]);
           }          
        return 0;
    }
    public int ListReadersbyIDOrder(ArrayList<Readers> array ){
        //This part sort all books in the array by Readers's names
            String temp;
            int count = array.size();
            String str[] = new String [count];
           
           for(int i = 0; i < count; i++){
              
           }
           
           for(int i = 0; i < count; i++){
               
               str[i] = array.get(i).getId()+ " | " + array.get(i).getName()+ " | " + array.get(i).getSurname();
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
           
           System.out.println("Name\t" + "Surname\t" + "ID");
           for(int i = 0; i <= count -1; i++){
               
               
               System.out.println(str[i]);
                   
               }          
        
        return 0;
    }
    public String SearchByName(ArrayList<Readers> array, String tempReader, String tempBook) throws IOException {
        System.out.println("Enter a name");
        userSearch = sc.next();
        
          
                
              for(int i = 0; i < array.size(); i++){
            
            // When the element is found, stop the loop and return the index
            if(array.get(i).getName().contains(userSearch)){
                tempReader = array.get(i).getName()+ " " + array.get(i).getSurname();
                System.out.println( array.get(i).getName()+ " " + array.get(i).getSurname());
                addBorrowing(tempReader);
            }
                
           
        }return tempReader;
               
    }    
    public String SearchByID(ArrayList<Readers> array, String tempReader) throws IOException {
        System.out.println("Enter a reader ID");
        
        int userSearch = sc.nextInt();
        
           for(int i = 0; i < array.size(); i++){
            
            // When the element is found, stop the loop and return the index
            if(array.get(i).getId() == userSearch) {
                
                tempReader= array.get(i).getId()+ " " + array.get(i).getName();
                System.out.println(tempReader);
           }            
        }
        return tempReader;
    }
    public String getTempReader() {
    return tempReader;
    }
    public String BorrowsMenu (String tempReader) throws IOException { 
                
                System.out.println("Select 1 - borrow a book");
                System.out.println("Select 2 - return a book");
                System.out.println("Select 3 - show reader's history");
                int option = sc.nextInt();
                while(option <1 || option>4){
                    
                
                if (option ==1 ) {
                   
                        addBorrowing( tempReader);
                }else if(option == 2){   
                        addReturn(tempReader);
                }else if(option == 3){
                     new ListingBooks();           
                }else if(option == 4){
                    new LibraryMenu();
                }else{
                    System.out.println("That's not a valid option");
                }       
                }
        
        return tempReader;
    }
    public int ShowReaderActivity(ArrayList <Borrowings> borrowings, String tempReader) throws IOException{
        
        
        
       
        
                 for(int i = 0; i < borrowings.size(); i++){
                     tempReader = borrowings.get(i).getBorrower();
            // When the element is found, stop the loop and return the index
            if(borrowings.get(i).getBorrower().contains(tempReader)) {
           System.out.println(borrowings.get(i).getBorrower()+ "\t" +borrowings.get(i).getBorrowedBook() + "\t" + borrowings.get(i).getBorroweddate() + "\t" + borrowings.get(i).getReturneddate());
                
            
            }
        
          }
        return 0;
                
    }
    public int addBorrowing(String tempReader) throws IOException  {
        
       String tempBook = new ListingBooks().getTempBook();
       try{
        FileWriter fstream = new FileWriter("borrowings.txt",true);
        BufferedWriter out = new BufferedWriter(fstream);
        if (tempBook!=null){
        out.write(tempReader+ "\t"+ tempBook  +"\t"+ java.time.LocalDate.now() +"\t"+ "***"+"\n");
        
        out.close();
        }else {
            System.out.println("Fail");
        }
                }
       
       catch (Exception e){
           
        System.err.println("Error while writing to file: " +
        e.getMessage());
       
        }
       
       
    
    return 0;
    }
    
    public int addReturn(String tempReader) throws IOException  {
        
        System.out.println("Please, select search for a book");
        String tempBook = new ListingBooks().getTempBook();
        
       try{
       
        FileWriter fstream = new FileWriter("borrowings.txt",true);
            try (BufferedWriter out = new BufferedWriter(fstream)) {
                out.write(tempReader+ "\t"+ tempBook  +"\t"+ "***" + "\t"+ java.time.LocalDate.now() + "\n");
            }
        
        System.out.println("Book returned succefully");    
        }
       
       catch (Exception e){
           
        System.err.println("Error while writing to file: " +
        e.getMessage());
       
        }
       
       
    
    return 0;
    }
}
        
        
        
    
    
        

    


