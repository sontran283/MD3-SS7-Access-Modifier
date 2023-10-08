package Student;

import Book.BookManagement;

import java.util.Scanner;

public class SchoolManagement {
    static Scanner scanner = new Scanner(System.in);
    static int StudentIndex = 0;
    static int indexMark = 0;
    static int SubIndex = 0;
    static StudentManagement[] studentManagements = new StudentManagement[100];
    static Mark[] marks = new Mark[100];
    static Subject[] subjects = new Subject[100];

    public static void main(String[] args) {
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*** Menu SchoolManagement ***");
            System.out.println("--- danh muc ---");
            System.out.println("1_Quản lý student");
            System.out.println("2_Quản lý subject");
            System.out.println("3_Quản lí mark");
            System.out.println("4_Exit");
            System.out.println("moi nhap lua chon cua ban: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagerment();
                    break;
                case 2:
                    SubjectManagerment();
                    break;
                case 3:
                    MarkManagerment();
                    break;
                default:
                    System.exit(1);
                    break;
            }
        } while (true);
    }

    // quan li hoc sinh
    private static void StudentManagerment() {
        int choice1;
        do {
            System.out.println(" *** quan li hoc sinh    *** ");
            System.out.println("1_ Thêm mới học sinh");
            System.out.println("2_ Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3_ Thay đổi thông tin học sinh theo mã id");
            System.out.println("4_ Xóa học sinh theo mã id (kiểm tra xem nếu sinh viên có điểm thi thì không xóa được)");
            System.out.println("5_ Exit");
            System.out.println("moi nhap lua chon cua ban: ");
            choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    allStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                default:
                    System.exit(1);
                    break;
            }
        } while (true);
    }

    private static void addStudent() {
        // tao mot doi tuong moi studentManagement
        StudentManagement studentManagement = new StudentManagement();
        // goi den phuong thuc inputData, nhan vao 2 tham so
        studentManagement.inputData(studentManagements, StudentIndex);
        // push studentManagement vao trong mang
        studentManagements[StudentIndex++] = studentManagement;
    }

    private static void allStudent() {
        System.out.println("danh sach tat ca hoc sinh");
        for (int i = 0; i < StudentIndex; i++) {
            studentManagements[i].displayData();
        }
    }

    private static void editStudent() {
        System.out.println("nhap thong tin can sua theo id");
        int editId = Integer.parseInt(scanner.nextLine());   // hien thong tin id tu nguoi dung vua nhap
        for (int i = 0; i < StudentIndex; i++) {
            if (studentManagements[i].getStudentId() == editId) {
                studentManagements[i].inputData(studentManagements, StudentIndex);
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("khong tim thay hoc sinh co id " + editId);
    }

    private static void deleteStudent() {
        System.out.println("nhap id hoc sinh can xoa");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < StudentIndex; i++) {
            if (studentManagements[i].getStudentId() == deleteId) {
                for (int j = i; j < StudentIndex; j++) {
                    studentManagements[j] = studentManagements[j + 1];
                }
                System.out.println("xoa thanh cong!");
                StudentIndex--;
                return;
            }
        }
        System.out.println("khong tim thay ai co id la: " + deleteId);
    }

    // quan li diem thi
    private static void MarkManagerment() {
        int choice2;
        do {
            System.out.println(" *** quan li diem thi  *** ");
            System.out.println("1_ Thêm mới diem thi");
            System.out.println("2_ Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3_ Thay đổi điểm theo mã id");
            System.out.println("4_ Xóa điểm theo mã id");
            System.out.println("5_ Hiển thị danh sách điểm thi theo mã môn học ");
            System.out.println("6_ Hiển thị đánh giá học lực của từng học sinh theo mã môn học ");
            System.out.println("7_ thoat");
            System.out.println("moi nhap lua chon cua ban: ");
            choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    addMark();
                    break;
                case 2:
                    allMarkWithCount();
                    break;
                case 3:
                    editMark();
                    break;
                case 4:
                    deleteMark();
                    break;
                case 5:
                    allWithMark();
                    break;
                case 6:
                    allAcademicWithMark();
                    break;
                default:
                    System.exit(1);
                    break;
            }
        } while (true);
    }

    private static void addMark() {
        StudentManagement studentManagement = new StudentManagement();
        Subject subject = new Subject();
        String idObject;
        while (true) {
            System.out.println("nhap id hoc sinh");
            int idHs = Integer.parseInt(scanner.nextLine());
            boolean flag = false;
            for (int i = 0; i < StudentIndex; i++) {
                if (studentManagements[i].getStudentId() == idHs) {
                    studentManagement = studentManagements[i];
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        ;
        while (true) {
            System.out.println("nhap id mon hoc");
            String idSj = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < SubIndex; i++) {
                if (subjects[i].getSubjectId().equals(idSj)) {
                    subject = subjects[i];
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        ;
        Mark mark = new Mark();
//        mark.inputData(student, subject);
        marks[indexMark++] = mark;
//        return mark;
    }

    private static void allMarkWithCount() {

    }

    private static void editMark() {

    }

    private static void deleteMark() {

    }

    private static void allWithMark() {

    }

    private static void allAcademicWithMark() {

    }

    // quan li mon hoc
    private static void SubjectManagerment() {
        int choice3;
        do {
            System.out.println(" *** quan li mon hoc  *** ");
            System.out.println("1_ Thêm mới môn học");
            System.out.println("2_ Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3_ Thay đổi thông tin học môn học theo mã id");
            System.out.println("4_ Xóa môn học theo mã id (kiểm tra nếu môn học  có điểm thi thì không xóa được ");
            System.out.println("5_ thoat");
            System.out.println("moi nhap lua chon cua ban: ");
            choice3 = Integer.parseInt(scanner.nextLine());
            switch (choice3) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    allShowSubject();
                    break;
                case 3:
                    editSubjectwithId();
                    break;
                case 4:
                    deleteWithId();
                    break;
                default:
                    System.exit(1);
                    break;
            }
        } while (true);
    }

    private static void addSubject() {
        Subject subject = new Subject();
        subject.inputData();
        subjects[SubIndex++] = subject;
    }

    private static void allShowSubject() {
        System.out.println("hien thi thong tin tat ca mon hoc");
        for (int i = 0; i < SubIndex; i++) {
            subjects[i].displayData();
        }
    }

    private static void editSubjectwithId() {
        System.out.println("nhap id mon hoc can edit: ");
        String editSubjectId = scanner.nextLine();
        for (int i = 0; i < SubIndex; i++) {
            if (subjects[i].getSubjectId().equals(editSubjectId)) {
                subjects[i].inputData();
                System.out.println("cap nhap thanh cong!");
            }
        }
        System.out.println("khong tim thay mon hoc co id la: " + editSubjectId);
    }

    private static void deleteWithId() {
        System.out.println("nhap id mon hoc can delete: ");
        String deleteSubjectId = scanner.nextLine();
        for (int i = 0; i < SubIndex; i++) {
            if (subjects[i].getSubjectId().equals(deleteSubjectId)) {
                for (int j = i; j < SubIndex; j++) {
                    subjects[j] = subjects[j + 1];
                }
                System.out.println("cap nhat thong tin thanh cong!");
                SubIndex--;
                return;
            }
        }
        System.out.println("khong tim thay mon hoc co id: " + deleteSubjectId);
    }
}
