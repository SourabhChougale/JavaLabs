package Exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketballTest {

    @Test
    void updatePoints() {
        Basketball b=new Basketball("Boston",32);
        b.updatePoints("Win");
        assertEquals(34,b.getPoints());
    }
}