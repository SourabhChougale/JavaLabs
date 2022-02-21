import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void readCustomerData() {
        Main m=new Main();
        ArrayList<Customer> arr=m.readCustomerData();
        assertEquals("mark",arr.get(1).getName());

    }

    @org.junit.jupiter.api.Test
    void readVehicleData() {
        Main m=new Main();
        ArrayList<Vehicle> arr=m.readVehicleData();
        assertEquals("DE8547",arr.get(0).getLicense_plate());
    }

}