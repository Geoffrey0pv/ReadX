package model;
import java.util.Calendar;

public class BibliographyProduct {
    private String name;
    private Calendar date;
    private int numPages;
    private double value;
    private String id;
    private int readPages = 0;

    public BibliographyProduct(String name, Calendar date, int numPages, double value, String id) {
        this.name = name;
        this.date = date;
        this.numPages = numPages;
        this.value = value;
        this.id = id;
    }
    public void generateID(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getReadPages() {
        return readPages;
    }
    public void setReadPages(int readPages) {
        this.readPages = readPages;
    }
    @Override
    public String toString() {
        return  " \n " +
                "\n* Name: " + name + " \n " +
               // "* Date publish: " + date + " \n " +
                "* Pages numbers: " + numPages + " \n " +
                "* Value: " + value + "$ \n " +
                "* Number read pages: " + readPages + "\n";
    }
}
