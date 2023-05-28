package model;
import java.util.Date;
public class UserFree extends User{
    private boolean adds = true;
    private boolean winSurprise = false;
    private BibliographyProduct[][] library;
    private final int ROWS = 5;
    private final int COLUMNS = 5;
    private String creditCard;
    private int countAvailableBooks;
    private int countAvailableReview;

    public UserFree(String name, TypeID typeId, int id, Date date, String email) {
        super(name, typeId, id, date, email);
        library = new BibliographyProduct[ROWS][COLUMNS];

    }

    @Override
    public String addMagazine(BibliographyProduct magazine) {
        return super.addMagazine(magazine);
    }
    @Override
    public String addBook(BibliographyProduct book) {
        return super.addBook(book);
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
    public String showLibrary(){
        return null;
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
