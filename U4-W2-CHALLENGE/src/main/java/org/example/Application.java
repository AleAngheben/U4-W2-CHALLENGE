package org.example;

import com.github.javafaker.Faker;
import org.example.Elements.Book;
import org.example.Elements.abstractClasses.Elements;
import org.example.actions.Create;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {

        System.out.println("U4-W2-D5");

        List<Elements> myCatalog = new ArrayList<>();

        //HO CREATO 5 LIBRI E 5 RIVISTE TRAMITE LA CLASSE CREATE
        Create.createAndAdd(200, myCatalog);
        System.out.println(myCatalog);


        // 1 AGGIUNTA DI UN ELEMENTO -----------------------------------------------------------------------------------

        System.out.println("");
        System.out.println("Esercizio 1");
        Book newBook = new Book("Nuovo", 2020, 500, "autoreNew", "MetafictionNew");
        System.out.println("Nuovo libro da aggiungere : " + newBook);
        myCatalog.add(newBook);


        // 2 RIMOZIONE ELEMENTO CON CODICE ISBN ------------------------------------------------------------------------
        //----cancella nel caso il cod ISBN sia 300

        System.out.println("");
        System.out.println("Esercizio 2");
        int valueToDelete = 300;
        myCatalog.removeIf(ele -> ele.getCodISBN() == valueToDelete);


        // 3 RICERCA PER ISBN ------------------------------------------------------------------------------------------
        //------filtra tutti gli elementi che hanno quel codice e me lo stampa a video

        System.out.println("");
        System.out.println("Esercizio 3");
        int valuetoSearch = 240;
        myCatalog.stream().filter(ele -> ele.getCodISBN() == valuetoSearch).forEach(System.out::println);


        // 4 RICERCA PER ANNO DI PUBBLICAZIONE

        System.out.println("");
        System.out.println("Esercizio 4");
        int yearToSearch = 2020;
        myCatalog.stream().filter(ele -> ele.getYear() == yearToSearch).forEach(System.out::println);


        // 5 RICERCA PER AUTORE

        Faker faker  = new Faker(Locale.ITALY);

        String authorToSearch = faker.book().author();

    }
}
