package Exercise1;

public class Employee {

    private String name;
    private int hours;
    private double salPerHour;
    private double salPerDay;
    private double baseSalary;

    //Parameterized constructor
    public Employee(String name,int hours, double salPerHour) {
        this.name = name;
        this.hours=hours;
        this.salPerHour=salPerHour;
    }

    //Getter methods
    public double getSalPerDay() {
        return salPerDay;
    }
    public double getBaseSalary() {
        return baseSalary;
    }

    //Calculating salary for the day using total number of hours and salary per hour
    public void calSalPerDay(){
        salPerDay=hours*salPerHour;
    }

    //Adding 5$ to salary per day if total number of hours is greater than 6
    public void addWork() {
        calSalPerDay();
        if (hours > 6) salPerDay += 5;
    }

    //Calculating base salary of 20 days using salary per day
    public void computeBaseSalary(){
        addWork();
        baseSalary=20*(salPerDay);
    }

    //Adding 10$ to base salary if basa salary for 20 days is less than 500$
    public void addSal(){
        computeBaseSalary();
        if(baseSalary<500) baseSalary+=10;
    }

    //Returning the final salary of the employee for the month
    public double getFinalSalary(){
        addSal();
        return baseSalary;
    }

    //Printing the output
    public void result(){
        System.out.println("Final Base Salary of "+name+" is :"+ getFinalSalary()+"$");
    }


    public static void main(String[] args) {
        //Creating objects and calling the methods
        Employee e1=new Employee("John",5,10);
                e1.result();

        Employee e2=new Employee("Sandra",4,5);
                e2.result();

        Employee e3=new Employee("Gio",7,12);
                e3.result();

        }

}
