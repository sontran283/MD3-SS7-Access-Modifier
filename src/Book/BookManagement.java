package Book;

import java.util.Scanner;

public class BookManagement {
    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private int quantity;
    private boolean bookStatus;
    private static int idCount = 1;

    public BookManagement() {
        this.bookId = idCount++;
        this.bookStatus = true;
    }

    public BookManagement(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {
        System.out.println("*** moi nhap thong tin");

        System.out.println("nhap ten sach: ");
        this.bookName = scanner.nextLine();

        System.out.println("nhap ten tac gia: ");
        this.author = scanner.nextLine();

        System.out.println("nhap mo ta cuon sach: ");
        while (true) {
            this.description = scanner.nextLine();
            if (this.description.length() < 10) {
                System.out.println("mo ta phai co it nhat 10 ki tu,moi nhap lai: ");
            } else {
                break;
            }
        }

        System.out.print("nhap gia nhap khau: ");
        this.importPrice = Double.parseDouble(scanner.nextLine());
        while (this.importPrice <= 0) {
            System.out.println("gia nhap phai lon hon 0");
            System.out.print("moi nhap importPrice: ");
            this.importPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("nhap gia xuat khau: ");
        this.exportPrice = Double.parseDouble(scanner.nextLine());
        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.println("gia xuat phai toi thieu bang 1/2 gia nhap khau");
            System.out.print("moi nhap exportPrice: ");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("tinh toan loi nhuan: ");
        this.interest = (float) (this.exportPrice - this.importPrice);

        System.out.print("nhap so luong: ");
        this.quantity = Integer.parseInt(scanner.nextLine());
        while (this.quantity <= 0) {
            System.out.println("so luong phai lon hon 0");
            System.out.print("moi nhap quantity: ");
            this.quantity = Integer.parseInt(scanner.nextLine());
        }
//        Integer.parseInt(scanner.nextLine());
    }

    public void displayData() {
        System.out.println(
                "BookManagement {" +
                        "bookId=" + bookId +
                        ", bookName='" + bookName + '\'' +
                        ", author='" + author + '\'' +
                        ", description='" + description + '\'' +
                        ", importPrice=" + importPrice +
                        ", exportPrice=" + exportPrice +
                        ", interest=" + interest +
                        ", quantity=" + quantity +
                        ", bookStatus=" + bookStatus +
                        '}'
        );
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
