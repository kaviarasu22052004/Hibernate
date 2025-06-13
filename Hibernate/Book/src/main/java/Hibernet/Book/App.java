package Hibernet.Book;

import Service.BookService;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        BookService service = new BookService();
        //service.saveBook();
        //service.updateBookPrice();
        //service.deleteBook();
        //service.generateBill();
        //service.searchByTitleOrId();
        
    }
}
