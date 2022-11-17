package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    private static Library library = new Library("Library 1");

    @BeforeAll
    public static void fillLibrary() {
        library.books.add(new Book("One Hundred Years of Solitude", "Gabriel García Márquez", LocalDate.ofYearDay(1967, 1)));
        library.books.add(new Book("Brave New World", "Aldous Huxley", LocalDate.ofYearDay(1932, 1)));
        library.books.add(new Book("The Lion, The Witch And The Wardrobe", "C.S. Lewis ", LocalDate.ofYearDay(1950, 1)));
    }

    @Test
    public void testGetBooksShallowCopy() {
        // Given
        Library originalLibrary = new Library("FirstLibrary");
        originalLibrary.books.addAll(library.books);

        Library shallowLibrary = new Library("ShallowLibrary");
        try {
            shallowLibrary = originalLibrary.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        Book addedBook = new Book("The Master and Margarita", "Mikhail Bulgakov", LocalDate.ofYearDay(1966, 1));
        originalLibrary.getBooks().add(addedBook);

        //Then
        assertEquals(originalLibrary.getBooks(), shallowLibrary.getBooks());
        assertTrue(shallowLibrary.getBooks().contains(addedBook));
    }

    @Test
    public void testGetBooksDeepCopy() {
        // Given
        Library originalLibrary = new Library("FirstLibrary");
        originalLibrary.books.addAll(library.books);

        Library deepLibrary = new Library("DeepLibrary");
        try {
            deepLibrary = originalLibrary.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        Book addedBook = new Book("The Master and Margarita", "Mikhail Bulgakov", LocalDate.ofYearDay(1966, 1));
        originalLibrary.getBooks().add(addedBook);

        //Then
        assertNotEquals(originalLibrary.getBooks(), deepLibrary.getBooks());
        assertFalse(deepLibrary.getBooks().contains(addedBook));
    }
}

