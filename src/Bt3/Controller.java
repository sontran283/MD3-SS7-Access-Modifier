package Bt3;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap kich thuoc hinh tron");
        System.out.println("R = ");
        double r=Double.parseDouble(scanner.nextLine());
        System.out.println("Dien tich hinh tron la: "+ Circle.getArea(r));
    }
}
