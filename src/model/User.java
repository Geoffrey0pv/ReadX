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
    /**
     * Adds a book to the user's library.
     *
     * @param book The book to be added.
     * @return A message indicating the success of the addition.
     */
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
    /**
     * Adds a magazine to the user's library.
     *
     * @param magazine The magazine to be added.
     * @return A message indicating the success of the addition.
     */
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
    /**
     * Searches for a bibliography product in the library based on the given coordinates.
     *
     * @param x The x-coordinate of the product in the library.
     * @param y The y-coordinate of the product in the library.
     * @return The bibliography product found at the specified coordinates.
     */
    public BibliographyProduct searchProduct(int x, int y){
        return library[x][y];
    }
    /**
     * Searches for magazines in the library and returns information about them.
     *
     * @return A message containing information about the magazines found in the library.
     */
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
    /**
     * Deletes a product from the library at the specified coordinates.
     *
     * @param x The x-coordinate of the product in the library.
     * @param y The y-coordinate of the product in the library.
     * @return A message indicating the successful deletion of the product.
     */
    public String deleteProduct(int x, int y){
        library[x][y] = null;
        return "Delete succesfuly";
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
