package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTest {

    public static int n = 0;

    public static String getSignature() {
        n++;
        return String.valueOf(n);
    }

    @Test
    void publicationYearMedian() {
        // Given
        Set<Book> booksLibraryA = new HashSet<>() {{
            add(new Book("Leo Tolstoy", "Anna Karenina", 1878, getSignature()));
            add(new Book("The Shining", "Stephen King", 1977, String.valueOf(n++)));
            add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, String.valueOf(n++)));
            add(new Book("Pride and Prejudice", "Jane Austen", 1813, String.valueOf(n++)));
        }};

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int result = medianAdapter.publicationYearMedian(booksLibraryA);

        //Then
        assertEquals(1916, result);
    }
}


