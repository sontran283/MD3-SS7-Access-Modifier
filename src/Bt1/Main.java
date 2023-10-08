package Bt1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        MyClass myClass=new MyClass();

        System.out.println("Nhap gia tri myString muon thay doi");
        String str= scanner.nextLine();
        myClass.setMyString(str);
    }
}
