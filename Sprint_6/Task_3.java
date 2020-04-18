import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double getPerimeter();
}
class Rectang extends Shape {
    private double height;
    private double width;
    
    
    public Rectang(double height, double width) {
        super();
        this.height = height;
        this.width = width;
    }


    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }


    public double getWidth() {
        return width;
    }


    public void setWidth(double width) {
        this.width = width;
    }


    public double getLength() {
        return height;
    }


    public void setLength(double length) {
        this.height = length;
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
        Rectang other = (Rectang) obj;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rectang [width=" + width + ", length=" + height + "]";
    }
    
}

class Square extends Shape{
    private double width;
    
    
    public Square(double width) {
        super();
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 4*width;
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
        Square other = (Square) obj;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Square [width=" + width + "]";
    }
    
}

public class MyUtils {
    public double sumPerimeter(List<Shape> figures) {
        double sum = 0.00;
        if (figures != null) {
            for (Shape shape : figures) {
                if (shape != null) {
                    sum += shape.getPerimeter();
                }

            }
        }
        return sum;
    }
}

