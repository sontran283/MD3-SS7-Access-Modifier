package Student;

import java.util.Scanner;

public class StudentManagement {
    static int count = 1;
    private int studentId;
    private String studentName;
    private String birthday;
    private String address;
    private boolean gender;
    private String phoneNumber;

    public StudentManagement() {
        this.studentId = StudentManagement.count++;
    }


    Scanner scanner = new Scanner(System.in);

    public void inputData(StudentManagement[] studentManagements, int StudentIndex) {
        System.out.println("*** vui long nhap thong tin: ");

        while (true) {
            System.out.println("nhap ten hoc sinh: ");
            this.studentName = scanner.nextLine();
            if (!this.studentName.isEmpty()) {
                break;
            }
        }

        while (true) {
            System.out.println("nhap ngay thang nam sinh (vi du: 01/01/1990) ");
            this.birthday = scanner.nextLine();
            if (this.birthday.matches("(0[1-9]|1[0-2])/([1-9]|[12]\\d|3[01])/\\d{4}")) {
                System.out.println("ngay thang nam sinh hop le");
                break; // Thoát khỏi vòng lặp khi nhập ngày tháng hợp lệ
            } else {
                System.out.println("ngay thang nam sinh ko hop le");
            }
        }

        while (true) {
            System.out.println("Nhập địa chỉ");
            this.address = scanner.nextLine();
            if (!this.address.isEmpty()) {
                break;
            }
        }

        System.out.println("nhap gioi tinh: ");
        System.out.println("1.male ");
        System.out.println("2.female ");
        int g = Integer.parseInt(scanner.nextLine());
        this.gender = g == 1 ? true : false;

        while (true) {
            String regex = "^0\\d{9,10}$";
            System.out.print("nhap so dien thoai (vi du : 0123456789) ");
            this.phoneNumber = scanner.nextLine();
            if (this.phoneNumber.matches(regex)) {
                boolean check = true;
                for (int i = 0; i < StudentIndex; i++) {
                    if (studentManagements[i].getPhoneNumber().equals(this.phoneNumber)) {
                        System.out.println("so dien thoai da ton tai, vui long nhap lai");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    break;
                }
            } else {
                System.out.println("so dien thoai khong hop le");
            }
        }
        System.out.println("them moi thanh cong");
    }

    public void displayData() {
        System.out.println(
                "StudentManagement{" +
                        "studentId=" + studentId +
                        ", studentName='" + studentName + '\'' +
                        ", birthday='" + birthday + '\'' +
                        ", address='" + address + '\'' +
                        ", gender= '" + (gender ? "male" : "female") + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        '}'
        );
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
