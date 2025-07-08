package com.mycompany.quantumbookstore;

import java.util.List;

/**
 * This class is used to manually test the functionalities of the QuantumBookStore system.
 * It tests adding books, buying different types, and removing outdated books.
 * 
 */
public class QuantumBookstoreFullTest {

    public static void main(String[] args) {
        // Create a new bookstore object
        QuantumBookStore store = new QuantumBookStore();

        // Create sample books
        Book paperBook = new PaperBook(123, "Effective Java", 2008, 40.0, "Joshua Bloch", 10);
        Book ebook = new EBook(456, "Clean Code", 2010, 30.0, "Robert Martin", "PDF");
        Book showcaseBook = new ShowCaseBook(789, "Design Patterns", 1994, "Erich Gamma");

        // Add books to the store
        store.addBook(paperBook);
        store.addBook(ebook);
        store.addBook(showcaseBook);

        // Test purchasing different book types
        System.out.println("\n--- Testing book purchases ---");

        // Buy a paper book with quantity 2
        try {
            double total1 = store.buyBook(123, 2, "", "123 Main St");
            System.out.println("Quantum book store: Paid: " + total1);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Handle error if stock is low or book not found
        }

        // Buy an ebook (digital, doesn't depend on stock)
        try {
            double total2 = store.buyBook(456, 3, "user@example.com", "");
            System.out.println("Quantum book store: Paid: " + total2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Try to buy a showcase book (should not be allowed)
        try {
            store.buyBook(789, 1, "", "");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Expected to show "not for sale"
        }

        // Test removal of outdated books
        System.out.println("\n--- Removing outdated books (older than 15 years) ---");

        int currentYear = 2025; // Hardcoded year instead of using Calendar
        List<Book> removedBooks = store.removeOutdatedBooks(currentYear, 15); // Remove books older than 15 years

        // Print out the books that were removed
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books:");
        for (Book book : removedBooks) {
            System.out.println("- " + book.getTitle() + " (" + book.getYear() + ")");
        }
    }
}
