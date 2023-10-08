package QuanLiSinhVien;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        int choose;
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            System.out.println("choose: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    int n;
                    System.out.println("nhap so sinh vien can them");
                    n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Student student = new Student();
                        student.inputInfo();
                        studentList.add(student);
                    }
                    break;
                case 2:
                    System.out.println("hien thi thong tin sinh vien");
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 3:
                    // 2 bien luu vi tri sv co dtb cao va thap nhat
                    int minIndex = 0, maxIndex = 0;
                    float minMark, maxMark;
                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();
                    for (int i = 1; i < studentList.size(); i++) {
                        if (studentList.get(i).getMark() < minMark) {
                            minIndex = i;
                            minMark = studentList.get(i).getMark();
                        }
                        if (studentList.get(i).getMark() > maxMark) {
                            maxIndex = i;
                            maxMark = studentList.get(i).getMark();
                        }
                    }
                    System.out.println("sinh vien co dtb cao nhat: ");
                    studentList.get(maxIndex).showInfo();
                    System.out.println("sinh vien co dtb thap nhat: ");
                    studentList.get(minIndex).showInfo();
                    break;
                case 4:
                    System.out.println("nhap ma sinh vien can tim kiem");
                    String rollNoSearch = scanner.nextLine();
                    int count = 0;

                    for (Student student : studentList) {
                        if (student.getRollNo().equalsIgnoreCase(rollNoSearch)) {
                            student.showInfo();
                        }
                    }

                    if (count == 0) {
                        System.out.println("khong tim thay sv nao");
                    }
                    break;
                case 5:
                    // b1: sap xep thong tin theo thu tu a-z
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            int cmp = o1.getName().compareTo(o2.getName());
                            if (cmp >= 0) {
                                return -1;
                            }
                            return 1;
                        }
                    });

                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 6:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getMark() >= o2.getMark() ? -1 : 1;
                        }
                    });

                    // hien thi:
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).checkScholarship()) {
                            studentList.get(i).showInfo();
                        }
                    }
                    break;
                case 7:
                    System.out.println("thoat thanh cong, hen gap lai ban");
                    break;
                default:
                    System.err.println("thong tin ko hop le");
                    break;
            }
        } while (choose != 7);
    }

    static void showMenu() {
        System.out.println("1- nhap vao N sinh vien");
        System.out.println("2- hien thi thong tin sinh vien");
        System.out.println("3- hien thi sinh vien dtb cao va thap nhat");
        System.out.println("4- tim kiem theo ma sinh vien");
        System.out.println("5- hien thi tat ca danh sach sinh vien");
        System.out.println("6- hien thi sv duoc hoc bong, sap xep diem theo thu tu giam dan");
        System.out.println("7- thoat khoi chuong trinh");
    }
}
