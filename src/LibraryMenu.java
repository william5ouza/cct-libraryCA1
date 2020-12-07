
import MyArrays.Books;
import MyArrays.Readers;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class LibraryMenu {
   Scanner sc = new Scanner(System.in);
   
   
   
   
   
   public LibraryMenu() throws IOException {
    
    int option;          
          
    do{       
    boolean menu1 = false;   
        System.out.println("Welcome to this library");
        System.out.println("Please select one of the folloowing options");
        System.out.println("1 - Books");
        System.out.println("2 - Readers");
        System.out.println("3 - Close the program");
        
        
        
        option= sc.nextInt();
        
        switch (option) {
                
                case 1:
                    new ListingBooks();
                    
                    
                    break;
                case 2:
                    new ListingReaders();
                   
                    
                    break;
                
                   
                    
                case 3:
                    
                    System.out.println("Thank you for using our library");
                   
                   menu1 = true;
                  
                    break;
                default:
                     
                    System.out.println("Please enter a valid option");
                    break;
            }
        }while (false);
         }       
   }

   

  
            
            
         
 
    

       
   
    
    
    
    
    

