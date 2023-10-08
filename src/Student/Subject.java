package Student;

import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
        // tra ve so ngau nhien tu 0- 1098
        this.subjectId = "MH" + (Math.round(Math.random() + 999) + 100);
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    Scanner scanner = new Scanner(System.in);
    public void inputData() {
        System.out.println("nhap thong tin cua mon hoc: ");
        do {
            System.out.println("nhap ten mon hoc: ");
            this.subjectName = scanner.nextLine();
        } while (this.subjectName.isEmpty());
    }

    public void displayData() {
        System.out.println(
                "Subject{" +
                        "subjectId='" + subjectId + '\'' +
                        ", subjectName='" + subjectName + '\'' +
                        '}'
        );
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
