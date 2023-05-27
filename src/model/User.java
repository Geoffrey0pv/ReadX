package model;
import java.util.Date;
public abstract class User {
    private String name;
    private int id;
    private TypeID idTP;
    private Date date;
    private String email;
    public User(String name, TypeID typeId, int id, Date date, String email) {
        this.name = name;
        idTP = typeId;
        this.id = id;
        this.date = date;
        this.email = email;

    }
    public String surprise (int moth, char firstletter, int criticsCount){
        return  null;
    }
    public String getName() {
        return name;
    }
    public String addBook(BibliographyProduct book){return null;}
    public String addMagazine(BibliographyProduct magazine){return null;}
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "\n* Name: " + name +
                "\n* Id Type: " + idTP +
                "\n* Id: " + id +
                "\n* Date register: " + date +
                "\n* Email: " + email;
    }
    public char getFirtsLetter(){
        return Character.toLowerCase(name.charAt(0));
    }

}
