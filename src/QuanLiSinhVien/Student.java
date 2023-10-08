package QuanLiSinhVien;

import java.util.Scanner;

public class Student extends Person {
    String rollNo;
    float mark;
    String email;

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ma sinh vien");
        while (true) {
            String rollNoInput = input.nextLine();
            boolean check = setRollNo(rollNoInput);
            if (check) {
                break;
            }
        }

        System.out.println("nhap diem sinh vien");
        while (true) {
            float markInput = Float.parseFloat(input.nextLine());
            boolean check = setMark(markInput);
            if (check) {
                break;
            }
        }

        System.out.println("nhap email sinh vien");
        while (true) {
            // nhap vao dia chi email
            String emailInput = input.nextLine();
            // chuyen dia chi email vao thuoc tinh email
            boolean check = setEmail(emailInput);
            if (check) {
                break;
            }
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Student{" +
                        "rollNo='" + rollNo + '\'' +
                        ", mark=" + mark +
                        ", email='" + email + '\'' +
                        '}'
        );
    }

    public boolean checkScholarship() {
        if (mark >= 8) {
            return true;
        } else {
            return false;
        }
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if (rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.err.println("nhap lai ma sinh vien");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.out.println("nhap lai diem");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        }
        System.err.println("nhap lai dia chi email");
        return false;
    }
}
