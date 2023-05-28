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

    Date date;

    public UserPremium(String name, TypeID typeId, int id, Date date, String email, String creditCard, String avatar) {
        super(name, typeId, id, date, email);
        this.creditCard =  creditCard;
        this.date = date;
        this.avatar = avatar;
        payments = new double[12];
    }
    @Override
    public int getId() {
        return super.getId();
    }
    @Override
    public String toString() {
        return super.toString();
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

    @Override
    public String addMagazine(BibliographyProduct magazine) {
        return super.addMagazine(magazine);
    }
    @Override
    public String addBook(BibliographyProduct book) {
        return super.addBook(book);
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
