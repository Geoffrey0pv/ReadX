package model;
import java.util.Date;
public class UserFree extends User{
    private boolean adds = true;
    private boolean winSurprise = false;
    private BibliographyProduct [] books;
    private BibliographyProduct [] magazines;
    private String creditCard;
    private int countAvailableBooks;
    private int countAvailableReview;

    public UserFree(String name, TypeID typeId, int id, Date date, String email) {
        super(name, typeId, id, date, email);
        books = new Book[5];
        magazines = new Magazine[2];
    }
    /**
     * Adds a book to the user's collection.
     *
     * @param book The book to be added.
     * @return A message indicating the success of adding the book.
     */
    @Override
    public String addBook(BibliographyProduct book){
        String message = "";
        boolean control = true;
        for (int i = 0; i < books.length && control; i++) {
            if(books[i] == null){
                books[i] = book;
                message = "The book: " + book.getName();
                control = false;
            }
        }
        return message;
    }
    /**
     * Adds a magazine to the user's collection.
     *
     * @param magazine The magazine to be added.
     * @return A message indicating the success of adding the magazine.
     */
    @Override
    public String addMagazine(BibliographyProduct magazine){
        String message = "";
        boolean control = false;

        for (int i = 0; i < magazines.length && !control; i++) {
            if(magazines[i] == null){
                magazines[i] = magazine;
                message = "The magazine: " + magazine.getName();
                control = true;
            }
        }
        return message;
    }
    @Override
    public int getId() {
        return super.getId();
    }
    /**
     * Generates a surprise for the user.
     *
     * @param moth         The month for the surprise.
     * @param firstletter   The first letter for the surprise.
     * @param criticsCount  The count of critics for the surprise.
     * @return A message indicating the surprise result.
     */
    @Override
    public String surprise(int moth, char firstletter, int criticsCount) {
        String message;
        super.surprise(moth, firstletter, criticsCount);

        if(getFirtsLetter() == firstletter && !winSurprise){
            adds = false;
            message = "\n Congratulations you win One dat without Adds: \n" + getName();
            winSurprise = true;
        } else {
        message = "The user Free: " + getName() + " No wins";
        }

        return message;
    }
    /**
     * Returns a string representation of the UserFree object.
     *
     * @return A string containing information about the UserFree.
     */
    @Override
    public String toString() {
        return "\nUserType: Free " + "\n" + super.toString() + "\n" +
                "* With Adds: " + adds +"\n";
    }
    public boolean getAdds() {
        return adds;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
