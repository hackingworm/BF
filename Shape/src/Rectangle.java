public class Rectangle extends Shape {
    Rectangle(int width, int height) {
        value1 = width;
        value2 = height;
    }

    private double area() {
        return value1 * value2;
    }

    void printArea() {
        System.out.println(area());
    }
}
