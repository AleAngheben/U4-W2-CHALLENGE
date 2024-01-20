package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.example.Elements.Book;
import org.example.Elements.abstractClasses.Elements;
import org.example.actions.Create;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        System.out.println("U4-W2-D5");

        List<Elements> myCatalog = new ArrayList<>();

        //HO CREATO 5 LIBRI E 5 RIVISTE TRAMITE LA CLASSE CREATE
        Create.createAndAdd(5, myCatalog);
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

        Faker faker = new Faker(Locale.ITALY);

        String authorToSearch = faker.book().author();

        List<Elements> booksByAuthor = myCatalog.stream()
                .filter(ele -> ele instanceof Book)
                .map(ele -> (Book) ele)
                .filter(book -> authorToSearch.equals(book.getAuthor()))
                .collect(Collectors.toList());

        if (booksByAuthor.isEmpty()) {
            System.out.println("Nessun libro ha come autore " + authorToSearch);
        } else {
            System.out.println("I libri che hanno in comune l'autore " + authorToSearch + " sono :");
            booksByAuthor.forEach(System.out::println);
        }


        //6 SALVATAGGIO SU DISCO ARCHIVIO

        System.out.println("");
        System.out.println("Esercizio 6");
        try {
            writeListToFile(myCatalog, "src/main/java/org/example/files/text.txt");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura nel file :" + e.getMessage());
        }


        //7 CARICAMENTO DAL DISCO DELL'ARCHIVIO

        System.out.println("");
        System.out.println("Esercizio 7");
        System.out.println("bene");
     /*   try {

            String fileContent = readFromFile("src/main/java/org/example/files/text.txt");
            System.out.println("bene");
            System.out.println("Contenuto del file:");
            System.out.println("bene");
            System.out.println(fileContent);
            System.out.println("bene");
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }*/
    }

    //per la scrittura del file
    public static void writeListToFile(List<Elements> list, String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        for (Elements element : list) {
            content.append(element.toString()).append(System.lineSeparator());
        }
        FileUtils.writeStringToFile(new File(filePath), content.toString(), StandardCharsets.UTF_8);
    }

    private static String readFromFile(String filePath) throws IOException {
        return FileUtils.readFileToString(new File(filePath), "UTF_8");
    }



}
