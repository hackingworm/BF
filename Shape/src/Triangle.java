public class Triangle extends Shape {
    Triangle(int width, int height) {
        value1 = width;
        value2 = height;
    }

    private double area() {
        return value1 * value2 / 2;
    }

    void printArea() {
        System.out.println(area());
    }
}
