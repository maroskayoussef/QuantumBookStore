package com.mycompany.quantumbookstore;
/**
 * This class represents a physical paper book.
 * It includes a stock count and simulates shipping when purchased.
 */
public class PaperBook extends Book {
    private int stock;

    public PaperBook(int ISBN, String title, int year, double price, String author, int stock) {
        super(ISBN, title, year, price, author);
        this.stock = stock;
    }
// Handles the buying logic, updates stock, and calls the shipping service
    @Override
    public double buyProduct(int quantity, String email, String address) {
        if (stock < quantity) {
            throw new IllegalArgumentException("Quantum book store: this quantity is not available");
        }
        stock -= quantity;
        double total = price * quantity;
        ShippingService.shipProduct(this, address);
        System.out.println("Quantum book store: price is: " + total);
        return total;
    }
}
