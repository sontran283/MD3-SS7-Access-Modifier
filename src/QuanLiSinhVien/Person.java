package QuanLiSinhVien;

import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String birthday;
    private String address;

    public Person() {

    }

    public Person(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public void inputInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ten");
        name = input.nextLine();

        System.out.println("nhap gioi tinh");
        gender = input.nextLine();

        System.out.println("nhap ngay sinh");
        birthday = input.nextLine();

        System.out.println("nhap dia chi");
        address = input.nextLine();
    }

    public void showInfo() {
        System.out.println(
                "Person{" +
                        "name='" + name + '\'' +
                        ", gender='" + gender + '\'' +
                        ", birthday='" + birthday + '\'' +
                        ", address='" + address + '\'' +
                        '}'
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
