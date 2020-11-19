import java.util.*;

public abstract class Shape {

    String colour;

    public Shape(String colour){
        this.colour = colour;
    }

    public abstract float getArea();
    public abstract float getPerimeter();
    public abstract String toString();

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Red", 2.0f));
        shapes.add(new Rectangle("Blue", 1.5f, 3.0f));
        for (Shape shape: shapes) {
        System.out.println("");
        System.out.println(shape.toString());
        System.out.printf("Area: %.2f\n", shape.getArea());
        System.out.printf("Perimeter: %.2f\n", shape.getPerimeter());
        }
    }
}

class Circle extends Shape {

    float radius;

    public Circle(String colour, float radius) {
        super(colour);
        this.radius = radius;
    }

    public float getArea(){
        float Area = (float)Math.PI * (this.radius * this.radius);
        return Area;
    }
    public float getPerimeter(){
        float Perimeter = 2 * (float)Math.PI * this.radius;
        return Perimeter;
    }

    public String toString(){
        return this.colour + " circle with radius " + this.radius;
    }
}

class Rectangle extends Shape {

    float length; 
    float width;

    public Rectangle(String colour, float length, float width){
        super(colour);
        this.length = length;
        this.width = width;
    }

    public float getArea() {
        float Area = this.length * this.width;
        return Area;
    }

    public float getPerimeter() {
        float Perimeter = (2 * this.length) + (2 * this.width);
        return Perimeter;
    }

    public String toString() {
        return this.colour + " rectangle with length " + this.length + " and width " + this.width;
    }
}
