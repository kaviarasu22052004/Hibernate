package Service;

import java.util.Scanner;
import Dao.BookDao;
import Model.Book;

public class BookService {

    Scanner sc;
    BookDao dao;

    public BookService() {
        dao = new BookDao();
        sc = new Scanner(System.in);
    }

    public void saveBook() {
        Book b = new Book();

        System.out.println("Enter Book ID:");
        b.setBookId(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter Title:");
        b.setTitle(sc.nextLine());

        System.out.println("Enter Author:");
        b.setAuthor(sc.nextLine());

        System.out.println("Enter Price:");
        b.setPrice(sc.nextDouble());

        System.out.println("Enter Quantity:");
        b.setQuantity(sc.nextInt());

        dao.addBook(b);
        System.out.println(" Book added successfully!");
    }
    
    public void updateBookPrice() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Price: ");
        double price = sc.nextDouble();
        
        dao.updatePrice(id, price);
       
    }
    
    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        dao.deleteBook(id);
    }
    
    public void generateBill() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        dao.generateBill(id, qty);
    }
    
    public void searchByTitleOrId() {
      System.out.println("Enter Book Title:");
      String title = sc.nextLine();
      System.out.println("Enter Book ID:");
      int bookId = sc.nextInt();
      dao.searchByTitleOrId(title, bookId);
  }
    
    
}
