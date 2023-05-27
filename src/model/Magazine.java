package model;

import java.util.Calendar;
import java.util.Random;

public class Magazine extends BibliographyProduct{

private TypePerodicity issuancePeriodicity;
private TypeMagazine categoryMagazine;
private int activeSubscriptions;
private int readPages = 0;
Calendar cal;
Random random;
    public Magazine(String name, Calendar date, int numPages, double value, String id, TypePerodicity issuancePeriodicity, TypeMagazine categoryMagazine, int activeSubscriptions) {
        super(name, date, numPages, value, id);
        this.issuancePeriodicity = issuancePeriodicity;
        this.categoryMagazine = categoryMagazine;
        this.cal = date;
        this.activeSubscriptions = activeSubscriptions;
        random = new Random();
        generateID();
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return super.toString()  + "* ID: " + getId() + " \n " +
                "* Periodicity: " + issuancePeriodicity + " \n " +
                "* Category: " + categoryMagazine + "\n" +
                "* Date publish: " + cal.getTime() +  "\n" +
                "* Active Subscriptions: " + activeSubscriptions  + "\n " +
                "* Number read pages: " + readPages;
    }

    public int getActiveSubscriptions() {
        return activeSubscriptions;
    }

    public void setActiveSubscriptions(int activeSubscriptions) {
        this.activeSubscriptions = activeSubscriptions;
    }
}
