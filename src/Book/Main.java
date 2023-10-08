package Book;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BookManagement[] bookManagements = new BookManagement[100];
    static int currentIndex = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1.	Xây dựng lớp Book trong package ra.bussiness gồm các thông tin sau:
        //o	Các thuộc tính private :
        //	bookId – mã sách – int (Tự động tăng)
        //	bookName – tên sách – String (Không được để trống)
        //	author – tác giả – String (Không được để trống)
        //	descriptions – mô tả về sách – String (Không  được để trống, ít nhất 10 ký tự)
        //	importPrice – giá nhập – double (phải lớn hơn 0)
        //	exportPrice – giá xuất – double (phải lớn hơn 1.2 lần giá nhập)
        //	interest – lợi nhuận – float
        //	quantity – int – số lượng sản phẩm phải lơn hơn 0
        //	bookStatus – trạng thái – Boolean (mặc định là true)
        //o	Các constructor
        //o	Các phương thức:
        //	Các phương thức getter/setter
        //	Xây dựngdựng phương thức inputData():
        //	Nhập thông tin sách từ bàn phím (trừ interest)
        //	Thực hiện tính interest = exportPrice – importPrice
        //	Xây dựng phương thức displayData() cho phép hiển thị tất cả thông tin sách.
        //2.	Xây dựng lớp có tên BookManagement có phương thức main() trong package ra.run thực hiện các chức năng sau:
        //                            **************** MENU***************
        //1.	Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách
        //(Nhập số sách (n) cần nhập thông tin từ bàn phím và thực hiện nhập thông tin cho n cuốn sách đó , yêu cầu validate dữ liệu.(danh sách tối đa là 100 phần tử))
        //2.	Hiển thị thông tin tất cả sách trong thư viện
        //3.	Thay đổi thông tin sách theo mã sách
        //4.	Xóa sách theo mã sách
        //5.	Sắp xếp sách theo lợi nhuận tăng dần
        //6.	Tìm kiếm tương đối sách theo tên sách hoặc mô tả
        //
        //7.	Nhập sách ( Cho phép người dùng nhập vào mã sách và số lượng sách cần nhập Tiến hành cộng số lượng vừa nhập vào quantity của sách có mã vừa nhập vào )
        //
        //8.	 Bán sách(Cho phép người dùng nhập vào tên sách và số lượng sách cần
        //       bán. Tiến hành trừ số lượng vừa bán từ quantity của sách có tên sách vừa nhập , số   lượng  còn lại tron kho không được âm)
        //9.	Thoát
        while (true) {
            System.out.println("*** Menu BookManagement ***");
            System.out.println("1_ nhap so luong sach them moi: ");
            System.out.println("2_ hien thi thong tin tat ca sach trong thu vien");
            System.out.println("3_ thay doi thong tin sach theo ma cua sach");
            System.out.println("4_ xoa sach theo ma sach");
            System.out.println("5_ sap xep sach theo loi nhuan tang dan");
            System.out.println("6_ tim kiem tuong doi sach theo ten sach va mo ta");
            System.out.println("7_ nhap sach, cho phep nhap vao ma sach va so luong");
            System.out.println("8_ ban sach, cho phep nhap vao ten sach va sl sach can ban");
            System.out.println("9_ thoat khoi chuong trinh");
            System.out.println("___ moi nhap lua chon cua ban___");
            int choise = Integer.parseInt(scanner.nextLine());
            handleMenu(choise);
        }
    }

    private static void handleMenu(int choise) {
        switch (choise) {
            case 1:
                Main.addCountBook();
                break;
            case 2:
                Main.allBook();
                break;
            case 3:
                Main.editBook();
                break;
            case 4:
                Main.deleteBook();
                break;
            case 5:
                Main.subBook();
                break;
            case 6:
                Main.searchBook();
                break;
            case 7:
                Main.inputList();
                break;
            case 8:
                Main.sellingBooks();
                break;
            case 9:
            default:
                System.exit(1);
        }
    }

    private static void sellingBooks() {
        System.out.println("nhap ten sach can ban");
        String bookName = scanner.nextLine();

        System.out.println("nhap so luong can ban: ");
        int quantityToSell = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookName().equalsIgnoreCase(bookName)) {
                int currentQuantity = bookManagements[i].getQuantity();
                if (currentQuantity >= quantityToSell) {
                    bookManagements[i].setQuantity(currentQuantity - quantityToSell);
                    System.out.println("ban sach thanh cong");
                    return;
                } else {
                    System.out.println("so luong sach khong du de ban ");
                    return;
                }
            }
        }
        System.out.println("k tim thay sach co ten " + bookName);
    }

    private static void inputList() {
        System.out.println("nhap ma sach can nhap them :");
        int importId=scanner.nextInt();
        scanner.nextLine();

        System.out.println("nhap sp luong can them : ");
        int quantityToAdd=scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookId()==importId){
                int currentQuantyti=bookManagements[i].getQuantity();
                bookManagements[i].setQuantity(currentQuantyti+quantityToAdd);
                System.out.println("nhap sach thanh cong");
                return;
            }
        }
        System.out.println("k tim thay sach co ma " + importId);
    }

    private static void searchBook() {
        System.out.print("nhap tu khoa tim kiem: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookName().contains(keyword) || bookManagements[i].getDescription().contains(keyword)) {
                System.out.println("cuon sach " + (i + 1) + ":");
                bookManagements[i].displayData();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("sorry, khong tim thay cuon sach nao, hay nhap lai");
        }
    }

    private static void subBook() {
        Arrays.sort(bookManagements, 0, currentIndex, (b1, b2) ->
                Float.compare(b1.getInterest(), b2.getInterest()));
        System.out.println("sap xep sach loi nhuan thanh cong");
    }

    private static void addCountBook() {
        System.out.println("nhap so luong sach can them: ");
        int addCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addCount; i++) {
            System.out.println("Them sach lan thu: " + i + 1);
            BookManagement bookManagement = new BookManagement();
            bookManagement.inputData(scanner);
            bookManagements[currentIndex++] = bookManagement;
            System.out.println("da them thanh cong!!!");
        }
    }

    private static void allBook() {
        System.out.println("danh sach tat ca thu vien: ");
        for (int i = 0; i < currentIndex; i++) {
            bookManagements[i].displayData();
        }
    }

    private static void deleteBook() {
        System.out.println("hay nhap id cua cuon sach can xoa: ");
        int deletedId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookId() == deletedId) {
                for (int j = i; j < currentIndex; j++) {
                    bookManagements[j] = bookManagements[j + 1];
                }
                currentIndex--;
            }
        }
    }

    private static void editBook() {
        System.out.println("hay nhap id cua cuon sach can sua: ");
        int editedId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookId() == editedId) {
                System.out.println("thong tin cua cuon sach ma ban muon sua la: ");
                bookManagements[i].displayData();
                bookManagements[i].inputData(scanner);
                System.out.println("da cap nhat thong tin thanh cong");
                return;
            }
        }
        System.out.println("khong tim thay cuon sach voi id vua nhap");
    }
}
