package MyArrays;

/*
 * Here all information about users
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class Readers {
    
    private int id;
    private String name;
    private String surname;
   

   public Readers(int id, String name, String surname){
       this.id = id;
       this.name = name;
       this.surname = surname;
   }
    public void setId (int id){
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        return "Readers{" + "id=" + id + ", name=" + name + ", surname=" + surname + '}';
    }
    

}
