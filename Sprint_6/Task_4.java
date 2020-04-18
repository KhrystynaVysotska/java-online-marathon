import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Shape {
    private String name;
    public abstract double getArea();
    
    public Shape(String name) {
        super();
        this.name = name;
    }
    public Shape() {
        
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Circle extends Shape{
    public final static double PI = 3.14;
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circle other = (Circle) obj;
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}

class Rectangle extends Shape {
    private double height;
    private double width;
    
    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }
    
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return 2*(width + height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rectangle [height=" + height + ", width=" + width + "]";
    }
    
}

public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Circle> circles = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();
        List<Shape> maxShapes = new ArrayList<>();
        if (shapes.size() > 1) {
            for (Shape shape : shapes) {
                if (shape instanceof Circle) {
                    circles.add((Circle) shape);
                }
                if (shape instanceof Rectangle) {
                    rectangles.add((Rectangle) shape);
                }
            }

            Circle maxCircle = Collections.max(circles, Comparator.comparing(circle -> circle.getArea()));
            Rectangle maxRectangle = Collections.max(rectangles,
                    Comparator.comparing(rectangle -> rectangle.getArea()));

            for (Shape shape : shapes) {
                if (shape instanceof Circle) {
                    if (shape.getArea() == maxCircle.getArea() && !maxShapes.contains(shape)) {
                        maxShapes.add(shape);
                    }
                } else if (shape instanceof Rectangle) {
                    if (shape.getArea() == maxRectangle.getArea() && !maxShapes.contains(shape)) {
                        maxShapes.add(shape);
                    }
                }
            }
        } else if (shapes.size() == 1) {
            maxShapes.add(shapes.get(0));
        }
        return maxShapes;
    }
}
