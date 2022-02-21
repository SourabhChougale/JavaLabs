package Exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getSalPerDay(){
        Employee e1=new Employee("Mark",7,8);
        e1.calSalPerDay();
        assertEquals(56,e1.getSalPerDay());
    }


    @Test
    void addWork() {
        Employee e1=new Employee("Mark",7,8);
        e1.addWork();
        assertEquals(61,e1.getSalPerDay());

    }

    @Test
    void computeBaseSalary() {
        Employee e1=new Employee("John",7,8);
        e1.computeBaseSalary();
        assertEquals(1220,e1.getBaseSalary());
    }

    @Test
    void addSal() {
        Employee e1=new Employee("John",7,8);
        e1.addSal();
        assertEquals(1220, e1.getBaseSalary());

    }

    @Test
    void getFinalSalary() {
        Employee e1=new Employee("John",7,8);
        double salary=e1.getFinalSalary();
        assertEquals(1220,salary);
    }


}