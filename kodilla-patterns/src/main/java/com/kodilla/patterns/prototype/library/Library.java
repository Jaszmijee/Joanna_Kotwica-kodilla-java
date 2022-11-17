package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends LibraryPrototype<Library> {

    final String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedlibrary = super.clone();
        clonedlibrary.books = new HashSet<>();
        for (Book bookSet : books) {
            clonedlibrary.getBooks().add(bookSet);
        }
        return clonedlibrary;
    }
}
