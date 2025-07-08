package com.mycompany.quantumbookstore;
/**
 * This class represents an eBook which can be sent via email.
 * It has no stock limit and is delivered digitally.
 */

public class EBook extends Book {
    private String fileType;

    public EBook(int ISBN, String title, int year, double price, String author, String fileType) {
        super(ISBN, title, year, price, author);
        this.fileType = fileType;
    }
 // Simulates sending the ebook via email when purchased
    @Override
    public double buyProduct(int quantity, String email, String address) {
        double total = price * quantity;
        MailService.sendProduct(this, email);
        System.out.println("Quantum book store: price is: " + total);
        return total;
    }
}
