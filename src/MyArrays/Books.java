package MyArrays;


import java.util.stream.Stream;

/*
 * The idea in here is to define the characteristics of books 
 * Author, edition, year
 */

/**
 *
 * @author William
 */
    public class Books {
    private int id;
    private String Title;
    private String Author;
   

   
 
    
    public Books(int id, String Title, String Author){
      this.id = id;
      this.Title = Title;
      this.Author = Author;
  } 
      
 
  
    public void setId (int id){
        this.id = id;
    }
    public int getID() {
        return id;       
    }
    
     public void setTitle(String Title){
        this.Title = Title;
     }   
     public String getTitle() {
        return Title;       
    }
    
    public void setUthor(String Author){
        this.Author = Author;
    }    
     public String getAuthor() {
        return Author;       
    }

    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", Title=" + Title + ", Author=" + Author+ '}';
    }

    
    

    Stream<Books> contains(String bookSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    

}
