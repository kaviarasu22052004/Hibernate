package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
     int bookId;
    String title;
     String author;
    double price;
     int quantity;

    public Book() {
    	
    }

    
    public int getBookId() { 
    	return bookId; 
    	}
    public void setBookId(int bookId) {
    	this.bookId = bookId;
    	}

    public String getTitle() {
    	return title;
    	}
    public void setTitle(String title) {
    	this.title = title; 
    	}

    public String getAuthor() {
    	return author;
    	}
    public void setAuthor(String author) { 
    	this.author = author; 
    	}

    public double getPrice() { 
    	return price; 
    	}
    public void setPrice(double price) { 
    	this.price = price; 
    	}

    public int getQuantity() { 
    	return quantity; 
    	}
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    	}

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=" + title + ", Author=" + author +
                ", Price=" + price + ", Quantity=" + quantity + "]";
    }
}
