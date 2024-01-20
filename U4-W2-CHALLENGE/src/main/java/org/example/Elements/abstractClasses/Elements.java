package org.example.Elements.abstractClasses;

import java.util.Random;

public abstract class Elements {

    private int codISBN;

    private String title;

    private int year;

    private int numPages;

    public Elements( String title, int year, int numPages) {

        Random random= new Random();
        this.codISBN = random.nextInt(1,1000);
        this.title = title;
        this.year = year;
        this.numPages = numPages;
    }

    public int getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(int codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

}
