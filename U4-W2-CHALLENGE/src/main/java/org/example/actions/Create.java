package org.example.actions;

import com.github.javafaker.Faker;
import org.example.Elements.Magazine;
import org.example.Elements.abstractClasses.Elements;
import org.example.enums.Periodicity;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Create {
    protected static Periodicity getRandomFrequency() {
        Periodicity[] values = Periodicity.values();
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex];
    }

    public static void createAndAdd(int howMany, List<Elements> myList) {


        Faker faker = new Faker(Locale.ITALY);

        Supplier<org.example.Elements.Book> books = () -> new org.example.Elements.Book(
                faker.book().title(),
                faker.number().numberBetween(1900, 2024),
                faker.number().numberBetween(100, 1800),
                faker.book().author(),
                faker.book().genre());


        Supplier<Magazine> magazineSupplier = () -> new Magazine(
                faker.book().title(),
                faker.number().numberBetween(2000, 2024),
                faker.number().numberBetween(20, 300),
                getRandomFrequency()

        );

        for (int i = 0; i < howMany; i++) {
            myList.add((Elements) books.get());
        }

        for (int i = 0; i < howMany; i++) {
            myList.add((Elements) magazineSupplier.get());
        }
    }


}


