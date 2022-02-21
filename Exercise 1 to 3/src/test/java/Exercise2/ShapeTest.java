package Exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

   @Test
    void circle(){
       Shape s=new Shape();
       s.circle(5.8);
       assertEquals("36.44",String.format("%.2f",s.getPerimeter()));
       assertEquals("105.68",String.format("%.2f",s.getArea()));

   }
    @Test
    void square(){
        Shape s=new Shape();
        s.square(4.6);
        assertEquals("18.40",String.format("%.2f",s.getPerimeter()));
        assertEquals("21.16",String.format("%.2f",s.getArea()));

    }
    @Test
    void rectangle(){
        Shape s=new Shape();
        s.rectangle(2.8,6.4);
        assertEquals("18.40",String.format("%.2f",s.getPerimeter()));
        assertEquals("17.92",String.format("%.2f",s.getArea()));

    }

}