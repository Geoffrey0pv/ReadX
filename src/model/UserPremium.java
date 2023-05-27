package model;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class UserPremium extends User{
    private String creditCard;
    private String avatar;
    private int lastMothPay;
    private double [] payments;
    private final double PAYMONTH = 15;
    private boolean winSurprise = false;
    private BibliographyProduct[][] library;
    private final int ROWS = 5;
    private final int COLUMNS = 5;

    Date date;

    public UserPremium(String name, TypeID typeId, int id, Date date, String email, String creditCard, String avatar) {
        super(name, typeId, id, date, email);
        this.creditCard =  creditCard;
        this.date = date;
        this.avatar = avatar;
        payments = new double[12];
        library = new BibliographyProduct[ROWS][COLUMNS];
    }
    @Override
    public int getId() {
        return super.getId();
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public String addBook(BibliographyProduct book){
        String message = "";
        boolean control = false;
        for (int i = 0; i < library.length && !control; i++) {
            for (int j = 0; j < library.length && !control; j++) {
                if(library[i][j] == null){
                    library[i][j] = book;
                    control = true;
                    message = "The book: " + book.getName() + " was added";
                }
            }

        }
        return message;
    }
    /**
     * Adds a magazine to the UserPremium's collection of magazines.
     *
     * @param magazine The magazine to be added.
     * @return A message indicating the success of the operation.
     */
    @Override
    public String addMagazine(BibliographyProduct magazine){
        String message = "";
        boolean control = false;
        for (int i = 0; i < library.length && !control; i++) {  //reccorre las filas
            for (int j = 0; j < library.length && !control; j++) { //recorre las columnas
                if(library [i][j] == null){
                    library[i][j] = magazine;
                    control = true;
                    message = "The Magazine: " + magazine.getName() + " was added";
                }
            }
        }
        return message;
    }
    public String generateMouthPay() {
        SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
        String mesActualStr = formatoMes.format(date);
        int mesActual = Integer.parseInt(mesActualStr);
        payments[mesActual-1] = PAYMONTH;
        boolean control = false;
        lastMothPay = 0;
        for (int i = 0; i < payments.length - 2 && !control; i++) {
            if (payments[i] != 0 && payments[i + 1] == 0) {
                lastMothPay = i+1;
                control = true;
            }
        }
        return  this + "\n" +
                "* Avatar: " + avatar + "\n" +
                "* CreditCard: " + creditCard + "\n" +
                "* Last Moth Pay: " + lastMothPay + "\n" +
                "* Value pay moth loaded: " + PAYMONTH + "$" + "\n";
    }
    @Override
    public String surprise(int moth, char firstletter, int criticsCount) {
        Random random = new Random();

        super.surprise(moth, firstletter, criticsCount);
        String message;
        int countSpotify = random.nextInt(900000) + 1000000;

        if (lastMothPay == moth && !winSurprise) {
                message =  "\n Congratulations you Win Spotify count. ID count: " + countSpotify + getName() + "\n";
                winSurprise = true;
        } else {
            message = "The user premiums: " + getName() + " No wins";
        }
        return message;
    }
    public BibliographyProduct positionLibrary(int position) {
        int row = ((position -1) / 5);
        int column = ((position -1) % 5);
        return library[row][column];
    }
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
