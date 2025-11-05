class AreaCalculator {
    public double area(double radius) {
        return Math.PI * radius * radius;
    }
    public double area(double length, double breadth) {
        return length * breadth;
    }
    public double area(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }
}

class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Compile-time polymorphism test
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Area of circle: " + calculator.area(7));
        System.out.println("Area of rectangle: " + calculator.area(4, 6));
        System.out.println("Area of triangle: " + calculator.area(4, 5, true));

        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        shape1.draw();  
        shape2.draw();  
    }
}
