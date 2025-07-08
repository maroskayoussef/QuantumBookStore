package com.mycompany.quantumbookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the main Book Store system.
 * It allows adding books, buying books, and removing outdated ones.
 * It uses a simple list to keep track of the inventory.
 */
public class QuantumBookStore {
    
    // This list stores all the books currently in the bookstore's inventory
    private List<Book> inventory = new ArrayList<>();

    /**
     * Adds a new book to the inventory.
     * It checks if a book with the same ISBN already exists to avoid duplicates.
     */
    public void addBook(Book book) {
        for (Book b : inventory) {
            if (b.getISBN() == book.getISBN()) {
                throw new IllegalArgumentException("Quantum book store: Book with ISBN " + book.getISBN() + " already exists");
            }
        }
        inventory.add(book);
        System.out.println("Quantum book store: Added book – " + book.getTitle());
    }

    /**
     * Handles buying a book by ISBN.
     * It finds the book, checks if it's available, and calls its specific purchase logic.
     */
    public double buyBook(int isbn, int quantity, String email, String address) {
        for (Book book : inventory) {
            if (book.getISBN() == isbn) {
                return book.buyProduct(quantity, email, address);
            }
        }
        throw new IllegalArgumentException("Quantum book store: Book not found with ISBN: " + isbn);
    }

    /**
     * Removes all books from the inventory that are older than the given threshold.
     * Returns a list of the removed outdated books.
     */
    public List<Book> removeOutdatedBooks(int currentYear, int thresholdYears) {
        List<Book> removed = new ArrayList<>();
        List<Book> stillValid = new ArrayList<>();

        for (Book book : inventory) {
            if (currentYear - book.getYear() > thresholdYears) {
                removed.add(book);
                System.out.println("Quantum book store: Removed outdated book – " + book.getTitle());
            } else {
                stillValid.add(book);
            }
        }

        inventory = stillValid; // Update inventory to exclude removed books
        return removed;
    }
}
