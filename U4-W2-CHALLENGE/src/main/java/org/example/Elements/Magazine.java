package org.example.Elements;


import org.example.Elements.abstractClasses.Elements;
import org.example.enums.Periodicity;

public class Magazine extends Elements {

private Periodicity frequency;

    public Magazine(String title, int year, int numPages, Periodicity frequency) {
        super(title, year, numPages);
        this.frequency = frequency;
    }

    public Periodicity getFrequency() {
        return frequency;
    }

    public void setFrequency(Periodicity frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                " CodISBN=" + getCodISBN() +
                ", title='" + getTitle() + '\'' +
                ", year=" + getYear()+
                ", pages=" + getNumPages() +
                "frequency=" + frequency +
                '}';
    }
}
