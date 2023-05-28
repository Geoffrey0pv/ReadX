package model;
import java.util.Date;
public abstract class User {
    private String name;
    private int id;
    private TypeID idTP;
    private Date date;
    private String email;
    private BibliographyProduct[][] library;
    private final int ROWS = 5;
    private final int COLUMNS = 5;
    public User(String name, TypeID typeId, int id, Date date, String email) {
        this.name = name;
        idTP = typeId;
        this.id = id;
        this.date = date;
        this.email = email;
        library = new BibliographyProduct[ROWS][COLUMNS];
    }
    public String surprise (int moth, char firstletter, int criticsCount){
        return  null;
    }
    public String getName() {
        return name;
    }
    public String addBook(BibliographyProduct book) {
        String message = "";
        boolean control = false;

        for (int i = 0; i < library.length && !control; i++) {
            for (int j = 0; j < library[i].length && !control; j++) {
                if (library[i][j] == null) {
                    library[i][j] = book;
                    control = true;
                    message = "The book: " + book.getName() + " was added";
                }
            }
        }
        return message;
    }
    public String addMagazine(BibliographyProduct magazine) {
        String message = "";
        boolean control = false;

        for (int i = 0; i < library.length && !control; i++) {
            for (int j = 0; j < library[i].length && !control; j++) {
                if (library[i][j] == null) {
                    library[i][j] = magazine;
                    control = true;
                    message = "The Magazine: " + magazine.getName() + " was added";
                }
            }
            control = true;
        }

        return message;
    }
    public BibliographyProduct positionLibrary(int position) {
        int row = ((position -1) / 5);
        int column = ((position -1) % 5);
        return library[row][column];
    }
    public BibliographyProduct searchProduct(int x, int y){
        return library[x][y];
    }
    public String searchMagazine(){
        String message = "";
        for (int i = 0; i < library.length; i++) {
            for (int j = 0; j < library.length; j++) {
                if(library[i][j] instanceof Magazine){
                    message += "\nMagazine: " + library[i][j].getName() + " id: " + library[i][j].getId() + " x: " + i + " y: " + j + "\n";
                }
            }
        }
        return message;
    }
    public BibliographyProduct[][] getLibrary() {
        return library;
    }
    public String deleteProduct(int x, int y){
        String message = "Delete succesfuly";
        library[x][y] = null;
        return message;
    }
    public void setLibrary(BibliographyProduct[][] library) {
        this.library = library;
    }
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
