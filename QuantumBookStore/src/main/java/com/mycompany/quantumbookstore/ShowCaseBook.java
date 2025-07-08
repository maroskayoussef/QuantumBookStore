package com.mycompany.quantumbookstore;
/**
 * This class is for books that are only for display and not for sale.
 * Attempting to purchase this type will throw an error.
 */
public class ShowCaseBook extends Book {
    public ShowCaseBook(int ISBN, String title, int year, String author) {
        super(ISBN, title, year, 0, author);
    }
// Buying is not allowed for showcase books
    @Override
    public double buyProduct(int quantity, String email, String address) {
        System.out.println("Quantum book store: this is not for sale");
        throw new UnsupportedOperationException("Showcase book not for sale");
    }
}
