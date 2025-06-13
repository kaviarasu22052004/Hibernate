package Dao;

import Model.Book;

public interface BookDaoI {
    void addBook(Book book);
    void updatePrice(int bookId, double newPrice);
    void deleteBook(int bookId);
    void generateBill(int bookId, int quantity);
    void searchByTitleOrId(String title, int bookId);
    
}
