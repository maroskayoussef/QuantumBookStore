package com.mycompany.quantumbookstore;
/**
 * This is the base abstract class for all types of books in the bookstore.
 * It includes common attributes like ISBN, title, year, price, and author.
 * All specific book types must implement the buyProduct method.
 */
public abstract class Book {
    protected int ISBN;
    protected String title;
    protected int year;
    protected double price;
    protected String author;

    public Book(int ISBN, String title, int year, double price, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public int getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getAuthor() { return author; }
// Abstract method to be implemented differently depending on book type
    public abstract double buyProduct(int quantity, String email, String address);
}
