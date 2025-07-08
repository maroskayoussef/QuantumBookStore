 #  Quantum Book Store

A simple Java-based bookstore management system that simulates handling different types of books (eBooks, paper books, and showcase books), supports purchasing, and removes outdated inventory.

Features

- Add Books to inventory (with duplicate ISBN prevention)
- Buy Books based on type:
  -  `PaperBook` (requires stock, ships to address)
  -  `EBook` (no stock needed, sent via email)
  -  `ShowCaseBook` (not for sale)
- Remove outdated books based on publication year
- Uses service classes for:
  - Email delivery (`MailService`)
  - Physical shipping (`ShippingService`)
- Full test suite included in `QuantumBookstoreFullTest`

---

Class Overview

Book
Base class with common attributes:  
- ISBN  
- Title  
- Year  
- Price  
- Author  

public abstract double buyProduct(int quantity, String email, String address);

EBook
Delivered via email (no stock management).
Overrides buyProduct() to simulate sending the book using MailService.

 PaperBook
Requires stock and a valid shipping address.
On purchase, reduces stock and uses ShippingService to ship.

 ShowCaseBook
Not available for sale.
Attempting to purchase it throws an exception (UnsupportedOperationException).

QuantumBookStore
Maintains an inventory of Book objects.
Supports:
Adding new books
Purchasing books by ISBN
Removing outdated books based on a threshold (year)

MailService & ShippingService
MailService: Simulates email delivery for eBooks
ShippingService: Simulates physical delivery for paper books

QuantumBookstoreFullTest
Demonstrates and tests the full functionality of the bookstore:
Adding sample books
Purchasing eBooks and paper books
Attempting to purchase a showcase book (should fail)
Removing outdated books from inventory

 How to Run
Clone the repository or open it in NetBeans or any Java IDE.
Ensure all .java files are in the same package or organized in logical sub-packages.
Compile and run the QuantumBookstoreFullTest class to simulate the bookstore operations.

Requirements
Java Development Kit (JDK) 8 or later
No external libraries required (pure Java)

![Main](Screenshot%20(161).png)
![Main](Screenshot%20(162).png)
![Main](Screenshot%20(163).png)
![Main](Screenshot%20(164).png)
