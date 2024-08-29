public class Circle extends Shape {
    Circle(int radius) {
        value1 = radius;
    }

    private double area() {
        return Math.PI * value1 * value1;
    }

    void printArea() {
        System.out.println(area());
    }
}
