package Student;

import java.util.Scanner;

public class Mark {
    static int count = 1;
    private int markId;
    private String student;
    private String subject;
    private double point;

    public Mark() {
        this.markId = Mark.count++;
    }

    public Mark(int markId, String student, String subject, double point) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    Scanner scanner = new Scanner(System.in);

    public void inputData() {
        System.out.println("nhap thong tin danh sach hoc sinh va mon hoc:");

        System.out.println("nhap ten sinh vien: ");
        this.student = scanner.nextLine();

        System.out.println("nhap mon hoc: ");
        this.subject = scanner.nextLine();

        do {
            System.out.println("nhap diem thi: ");
            this.point = Double.parseDouble(scanner.nextLine());
        } while (this.point > 0 || this.point < 10);
    }

    public void displayData() {
        System.out.println(
                "Mark{" +
                        "markId='" + markId + '\'' +
                        ", student='" + student + '\'' +
                        ", subject='" + subject + '\'' +
                        ", point=" + point +
                        '}'
        );
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
