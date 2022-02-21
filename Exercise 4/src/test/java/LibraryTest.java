import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @org.junit.jupiter.api.Test
    void getBookCount() {
        Library l=new Library();
        int a=l.getBookCount("J.K. Rowling");
        assertEquals(7,a);
    }



    @org.junit.jupiter.api.Test
    void getHeader() {
        Library l=new Library();
        Map<String,Integer> headers=l.getHeader();
        assertEquals(8,headers.get("original_title"));
    }


    @org.junit.jupiter.api.Test
    void getBookDetails() {
        Library l=new Library();
        l.getBookDetails();
        assertEquals("Suzanne Collins",l.getB_list().get(0).getAuthors().getName());
    }
}