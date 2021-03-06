package Lesson09.View;

import Lesson09.Controller.BookController;
import Lesson09.Model.DTO.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class BookView {

    BookController bookController = new BookController();
    Scanner sc = new Scanner(System.in);

    public void execute() {
        while (true) {
            System.out.println("1. Show");
            System.out.println("2. Add");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("0. Exit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    ArrayList<Book> allBooks = bookController.getAllBooks();
                    for (int i = 0; i < allBooks.size(); i++) {
                        System.out.println(allBooks.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("Enter name book: ");
                    String name = sc.next();
                    System.out.println("Enter price book: ");
                    int price = sc.nextInt();
                    Book book = new Book(name, price);
                    if (bookController.addBook(book)) {
                        System.out.println("Succes");
                    } else {
                        System.out.println("Fail");
                    }
                    break;
                case 3:
                    System.out.println("Enter name book you want to delete: ");
                    String nameDeleteBook = sc.next();
                    int resultDelete = bookController.deleteBook(nameDeleteBook);
                    if (resultDelete == 1) {
                        System.out.println("Success");
                    } else if (resultDelete == -1) {
                        System.out.println("Fail");
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter name of book you want to update: ");
                    String nameUpdateBook = sc.next();

                    if (bookController.isExistBook(nameUpdateBook)) {
                        System.out.println("Name:");
                        String newName = sc.next();
                        System.out.println("Price:");
                        int newPrice = sc.nextInt();
                        int resultUpdate = bookController.updateBook(nameUpdateBook, bookController.createBook(newName, newPrice));
                        if (resultUpdate == 1) {
                            System.out.println("Success");
                        } else if (resultUpdate == -1) {
                            System.out.println("Fail");
                        }
                    } else {
                        System.out.println("Book not found");
                    }
                    break;

                default:
                    //Exit
                    return;
            }
        }

    }

}
