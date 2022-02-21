package Exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballTest {

    @Test
    void updatePoints() {
        Football f=new Football("Chelsea",40,"Happy Foot");
        f.updatePoints("Win");
        assertEquals(43,f.getPoints());
    }
}