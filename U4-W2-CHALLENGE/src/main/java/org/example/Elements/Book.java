package org.example.Elements;

import org.example.Elements.abstractClasses.Elements;

public class Book extends Elements  {

    private String author;

    private String genre;

    public Book(String title, int year, int numPages, String author, String genre) {
        super(title, year, numPages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                " CodISBN=" + getCodISBN() +
                ", title='" + getTitle() + '\'' +
                ", year=" + getYear()+
                ", pages=" + getNumPages() +
                ", author='" + getAuthor() + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
