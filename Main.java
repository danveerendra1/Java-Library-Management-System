
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static LibraryManager manager = new LibraryManager();

    public static void main(String[] args) {

        int choice;

        while (true) {

            System.out.println("\n====================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Book ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    manager.addBook(new Book(id, title, author));

                    break;

                case 2:

                    manager.viewBooks();

                    break;

                case 3:

                    System.out.print("User ID: ");
                    int uid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("User Name: ");
                    String uname = sc.nextLine();

                    manager.addUser(new User(uid, uname));

                    break;

                case 4:

                    manager.viewUsers();

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    manager.issueBook(sc.nextInt());

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    manager.returnBook(sc.nextInt());

                    break;

                case 7:

                    System.out.println("\nThank You for Using Library Management System!");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("❌ Invalid Choice!");
            }
        }
    }
}