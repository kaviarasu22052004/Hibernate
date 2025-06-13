package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Model.Book;
import util.HibernateUtil;

public class BookDao implements BookDaoI {

    SessionFactory factory;

    public BookDao() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void addBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
    }

	@Override
	public void updatePrice(int bookId, double newPrice) {
		 Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Book book = session.get(Book.class, bookId);
	        if (book != null) {
	            book.setPrice(newPrice);
	            session.update(book);
	            System.out.println("Price updated successfully!");
	        } else {
	            System.out.println("Book not found!");
	        }
	        tx.commit();
	        session.close();
		
	}

	@Override
	public void deleteBook(int bookId) {
		 Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Book book = session.get(Book.class, bookId);
	        if (book != null) {
	            session.delete(book);
	            System.out.println("Book deleted successfully!");
	        } else {
	            System.out.println("Book not found!");
	        }
	        tx.commit();
	        session.close();
	}
	
	 @Override
	    public void generateBill(int bookId, int quantity) {
	        Session session = factory.openSession();
	        Book book = session.get(Book.class, bookId);
	        if (book != null) {
	            if (book.getQuantity() >= quantity) {
	                double total = book.getPrice() * quantity;
	                System.out.println("Total Amount: " + total);
	            } else {
	                System.out.println("Insufficient stock!");
	            }
	        } else {
	            System.out.println("Book not found!");
	        }
	        session.close();
	    }
	 

	    @Override
	    public void searchByTitleOrId(String title, int bookId) {
	         Session session = factory.openSession();
	           Query<Book> q = session.createQuery(
	                "from Book where title = :title or bookId = :bookId", Book.class);
	        q.setParameter("title", title);
	        q.setParameter("bookId", bookId);

	        List<Book> booksList = q.list();
	        for (Book b : booksList) {
	            System.out.println(b);

	    }}
}
