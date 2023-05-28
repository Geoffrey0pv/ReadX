package model;

import java.util.Calendar;

public class Book extends BibliographyProduct{
    private String review;
    private TypeGender gender;
    private String frontPage;
    private int numSales;
    Calendar cal;
    public Book(String name, Calendar date, int numPages, String review, double value, String id, TypeGender gender, String frontPage, int numSales) {
        super(name, date, numPages, value, id);
        this.review = review;
        this.gender = gender;
        this.frontPage = frontPage;
        this.cal = date;
        this.numSales = numSales;
        generateID();
    }
    @Override
    public String toString() {
        return super.toString() + "* ID: " + getId() + " \n " +
                "* Review: " + review + " \n " +
                "* Gender: " + gender + " \n " +
                "* Front page: " + frontPage + "\n " +
                "* Date publish: " + cal.getTime() + "\n " +
                "* Number Sales: " + numSales  + "\n ";
    }
    public int getNumSales() {
        return numSales;
    }

    public void setNumSales(int numSales) {
        this.numSales = numSales;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
