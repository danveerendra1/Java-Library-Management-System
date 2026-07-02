
public class LibraryManager {

    private Library library = new Library();

    // Add Book
    public void addBook(Book book) {
        for (Book b : library.getBooks()) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("❌ Book ID already exists!");
                return;
            }
        }
        library.getBooks().add(book);
        System.out.println("✅ Book Added Successfully!");
    }

    // View Books
    public void viewBooks() {

        if (library.getBooks().isEmpty()) {
            System.out.println("No Books Available.");
            return;
        }

        System.out.printf("%-8s %-25s %-20s %-10s%n",
                "ID", "Title", "Author", "Status");

        for (Book book : library.getBooks()) {

            String status = book.isIssued() ? "Issued" : "Available";

            System.out.printf("%-8d %-25s %-20s %-10s%n",
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    status);
        }
    }

    // Add User
    public void addUser(User user) {

        for (User u : library.getUsers()) {
            if (u.getUserId() == user.getUserId()) {
                System.out.println("❌ User ID already exists!");
                return;
            }
        }

        library.getUsers().add(user);

        System.out.println("✅ User Added Successfully!");
    }

    // View Users
    public void viewUsers() {

        if (library.getUsers().isEmpty()) {
            System.out.println("No Users Available.");
            return;
        }

        System.out.printf("%-10s %-20s%n", "User ID", "User Name");

        for (User user : library.getUsers()) {

            System.out.printf("%-10d %-20s%n",
                    user.getUserId(),
                    user.getUserName());
        }
    }

    // Search Book
    public Book searchBook(int id) {

        for (Book book : library.getBooks()) {

            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }

    // Issue Book
    public void issueBook(int id) {

        Book book = searchBook(id);

        if (book == null) {
            System.out.println("❌ Book Not Found!");
            return;
        }

        if (book.isIssued()) {
            System.out.println("❌ Book Already Issued!");
            return;
        }

        book.setIssued(true);

        System.out.println("✅ Book Issued Successfully!");
    }

    // Return Book
    public void returnBook(int id) {

        Book book = searchBook(id);

        if (book == null) {
            System.out.println("❌ Book Not Found!");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("❌ Book is already available.");
            return;
        }

        book.setIssued(false);

        System.out.println("✅ Book Returned Successfully!");
    }
}