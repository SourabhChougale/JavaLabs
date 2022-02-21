package Exercise2;

public class Shape {

    private double area;
    private double perimeter;
    //Parameterized Constructor
    public Shape(){
        this.area=0;
        this.perimeter=0;
    }
    //Getter methods
    public double getArea() {
        return area;
    }
    public double getPerimeter() {
        return perimeter;
    }

    //Method for calculating area and perimeter of circle of given radius
    public void circle(double radius)
    {
        area=Math.PI*radius*radius;
        perimeter=2*Math.PI*radius;
        System.out.println("Perimeter of circle:"+String.format("%.2f",perimeter));
        System.out.println("Area of circle:"+String.format("%.2f",area));
    }

    //Method for calculating area and perimeter of square of given length
    public void square(double length)
    {
        area=length*length;
        perimeter=4*length;
        System.out.println("Perimeter of square:"+String.format("%.2f",perimeter));
        System.out.println("Area of square:"+String.format("%.2f",area));
    }

    //Method for calculating area and perimeter of rectangle of given length and breadth
    public void rectangle(double length,double breadth)
    {
        area=breadth*length;
        perimeter=2*(length+breadth);
        System.out.println("Perimeter of rectangle:"+String.format("%.2f",perimeter));
        System.out.println("Area of rectangle:"+String.format("%.2f",area));
    }



    public static void main(String[] args){

        Shape s=new Shape();
        s.circle(1.5);
        s.square(5);
        s.rectangle(4,8);
    }
}
