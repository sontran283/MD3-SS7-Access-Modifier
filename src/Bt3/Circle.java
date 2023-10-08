package Bt3;

public class Circle {
    private static double radius;
    private static final double PI=3.14;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public static double getArea(double radius){
        return radius*radius*PI;
    }
}
