import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    //Method to read data from Customer csv file
    public ArrayList<Customer> readCustomerData() {
        ArrayList<Customer> c_obj = new ArrayList<>();  //Arraylist to store Customer class objects
        List<String> data = new ArrayList<>();        //List to store data from customer csv file
        try {
            File file = new File("src/main/resources/Customer.csv");
            if (!file.exists()) {
                BufferedWriter wr = new BufferedWriter(new FileWriter(file));
                wr.close();
            }

            //Reading file and storing it in List data which has each row of file as a string element
            BufferedReader br1 = new BufferedReader(new FileReader(file));
            data = br1.lines().collect(Collectors.toList());

            if (!data.isEmpty()) data.remove(0);  //To remove headers of colum
             } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //Iterating through List data and creating Customer object to store in Customer Object array
        for (String l : data) {
            String[] l1 = l.split(",");
            Customer c = new Customer(l1[0], l1[1], Integer.parseInt(l1[2]), l1[4], (l1[4]));
            c_obj.add(c);
        }
        return c_obj; //returning object array
    }

    //Method to write data in Customer csv file where customer object array is passed as parameter
    public void writeCustomerData(ArrayList<Customer> c_obj) {
        try {
            File file = new File("src/main/resources/Customer.csv");

            BufferedWriter buffer1 = new BufferedWriter(new FileWriter(file));
            buffer1.write("Customer name,Customer Id,Vehicle Id Code,Start Date,End Date\n");
            buffer1.close();

            //writing data in customer csv using customer object array
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));
            for (Customer c : c_obj) {
                buffer.write(c.getName() + "," + c.getId_num() + "," + c.getId_code() + "," + c.getStartDate() + "," + c.getEndDate() + "\n");
            }

            buffer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    //Method to read data from Vehicle csv file
    public ArrayList<Vehicle> readVehicleData() {
        ArrayList<Vehicle> v_obj = new ArrayList<>();  //Arraylist to store Vehicle class objects
        List<String> data = new ArrayList<>();        //List to store data from vehicle csv file
        try {
            File file = new File("src/main/resources/Vehicle.csv");
            if (!file.exists()) {
                BufferedWriter wr = new BufferedWriter(new FileWriter(file));
                wr.close();
            }


            //Reading file and storing it in List data which has each row of file as a string element
            BufferedReader br1 = new BufferedReader(new FileReader(file));
            data = br1.lines().collect(Collectors.toList());
            if (!data.isEmpty()) data.remove(0);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //Iterating through List data and creating vehicle object to store in vehicle Object array
        for (String l : data) {
            String[] l1 = l.split(",");
            Vehicle v = new Vehicle(Integer.parseInt(l1[0]), l1[1], l1[2], Integer.parseInt(l1[3]), l1[4], Boolean.parseBoolean(l1[5]));
            v_obj.add(v);
        }
        return v_obj;
    }

    //Method to write data in vehicle csv file where vehicle object array is passed as parameter
    public void writeVehicleData(ArrayList<Vehicle> v_obj) {
        try {
            File file = new File("src/main/resources/Vehicle.csv");

            BufferedWriter buffer1 = new BufferedWriter(new FileWriter(file));
            buffer1.write("Id code,Brand,Model,Seats,License plate,Availability\n");
            buffer1.close();

            //writing data in vehicle csv using vehicle object array
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));
            for (Vehicle v : v_obj) {
                buffer.write(v.getId_code() + "," + v.getBrand() + "," + v.getModel() + "," + v.getSeats() + "," + v.getLicense_plate() + "," + v.isAvailability() + "\n");
            }
            buffer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Main m = new Main();

        boolean flag1 = true;
        while (flag1) {
            int id_code;
            String brand;
            String model;
            int seats;
            String license_plate;


            Scanner sc = new Scanner(System.in);
            System.out.println("\n" +
                    "Enter your choice:\n" +
                    "1.Add new vehicle to car fleet\n" +
                    "2.Remove a vehicle from car fleet\n" +
                    "3.Display available vehicles\n" +
                    "4.Add new rental\n" +
                    "5.Return the rented vehicle\n" +
                    "6.Display overall rental fleet\n" +
                    "7.Import data from csv to add vehicles to car fleet\n" +
                    "8.End");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Enter identification code: ");
                    id_code = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter brand:");
                    brand = sc.nextLine();
                    System.out.println("Enter model:");
                    model = sc.nextLine();
                    System.out.println("Enter number of seats:");
                    seats = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter license plate:");
                    license_plate = sc.nextLine();


                    //getting vehicle data and storing it in object array
                    ArrayList<Vehicle> v_obj = m.readVehicleData();


                    //Checking if entered vehicle id already exists
                    boolean flag = false;
                    for (Vehicle v : v_obj) {
                        if (v.getId_code() == id_code) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        Vehicle v = new Vehicle(id_code, brand, model, seats, license_plate, true);
                        v_obj.add(v);
                        m.writeVehicleData(v_obj);
                    } else System.out.println("This identification number already exits");
                    break;
                }
                case 2: {
                    System.out.println("Enter the id_no of vehicle to be removed from car fleet");
                    id_code = sc.nextInt();
                    sc.nextLine();
                    int i = 0;

                    //checking if entered vehicle id exists and also if the vehicle is already rented it cannot be removed
                    boolean flag2 = false;
                    ArrayList<Vehicle> v_obj = m.readVehicleData();
                    for (Vehicle v : v_obj) {
                        if (v.getId_code() == id_code) {
                            if (v.isAvailability()) {
                                flag2 = true;
                                break;
                            }
                        }
                        i++;
                    }
                    if (!flag2)
                        System.out.println("Cannot remove this vehicle");
                    else v_obj.remove(i);
                    m.writeVehicleData(v_obj);
                    break;
                }
                case 3: {
                    ArrayList<Vehicle> v_obj = m.readVehicleData();

                    for (Vehicle v : v_obj) {
                        if (v.isAvailability()) {
                            System.out.println(v.getId_code() + " " + v.getBrand() + " " + v.getModel() + " " + v.getSeats() + " " + v.getLicense_plate() + " " + v.isAvailability());
                        }
                    }
                    break;
                }
                case 4: {

                    //Getting customer data from csv file and storing in object array
                    ArrayList<Customer> c_obj = m.readCustomerData();
                    String name;
                    String id_num;
                    System.out.println("Enter name of customer:");
                    name = sc.nextLine();
                    System.out.println("Enter identification number:");
                    id_num = sc.nextLine();
                    System.out.println("Enter id_no of vehicle to be rented:");
                    id_code = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Start Date (dd/mm/yyyy)");
                    String startDate = sc.nextLine();
                    System.out.println("Enter End Date (dd/mm/yyyy)");
                    String endDate = sc.nextLine();
                    try {
                        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate); //converting string to date type
                        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
                        if (date2.compareTo(date1) < 0) { //check if end date is less than start date
                            System.out.println("Enter proper dates");
                        } else {
                            ArrayList<Vehicle> v_obj = m.readVehicleData();
                            Customer c = new Customer(name, id_num, id_code, startDate, endDate);

                            //check if vehicle with entered id is present in car fleet
                            boolean flag = false;
                            for (Vehicle v : v_obj) {
                                if (v.getId_code() == id_code) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                for (Vehicle v : v_obj) {
                                    if (v.getId_code() == id_code) {
                                        if (v.isAvailability()) { // checking if vehicle is already rented
                                            c_obj.add(c);  //adding the customer object to array
                                            m.writeCustomerData(c_obj);  //writing the data to customer csv file
                                            v.setAvailability(false); //changing availability of vehicle to false
                                            m.writeVehicleData(v_obj); //writing data to vehicle csv file
                                            break;
                                        } else System.out.println("Sorry, this vehicle is already rented");
                                    }
                                }

                            } else System.out.println("This vehicle is not in car fleet");

                        }
                    } catch (ParseException p) {
                        p.printStackTrace();
                    }


                    break;
                }
                case 5: {
                    System.out.println("Enter the id_no of vehicle rented");
                    id_code = sc.nextInt();
                    sc.nextLine();
                    ArrayList<Vehicle> v_obj = m.readVehicleData();

                    boolean flag=false;
                    for (Vehicle v : v_obj) {
                        if (v.getId_code() == id_code) {flag = true;
                            if(!v.isAvailability()) {  //checking if its already returned
                                v.setAvailability(true); //if not changing availability to true
                                m.writeVehicleData(v_obj); //writing update in csv file

                                break;
                            }else System.out.println("Already returned");
                        }

                    }
                    if(!flag) System.out.println("Vehicle is not available in car fleet");
                    break;
                }
                case 6: {
                    ArrayList<Vehicle> v_obj = m.readVehicleData();

                    for (Vehicle v : v_obj) {
                        System.out.println(v.getId_code() + " " + v.getBrand() + " " + v.getModel() + " " + v.getSeats() + " " + v.getLicense_plate() + " " + v.isAvailability());

                    }
                    break;
                }
                case 7:
                    System.out.println("Enter file location");
                    String fileLoc = sc.nextLine(); //getting file location of file to be imported

                    try {
                        //reading data from imported file
                        BufferedReader buffer = new BufferedReader(new FileReader(fileLoc));
                        List<String> data = buffer.lines().collect(Collectors.toList());
                        ArrayList<Vehicle> v_obj = m.readVehicleData();
                        ArrayList<Integer> id_list = new ArrayList<>();

                        //creating list of vehicle id in car fleet
                        for (Vehicle v1 : v_obj) {
                            id_list.add(v1.getId_code());
                        }
                        for (String l : data) {
                            String[] l1 = l.split(",");
                            if (!id_list.contains(Integer.parseInt(l1[0]))) { // checking if any vehicle id is already present in car fleet
                                Vehicle v = new Vehicle(Integer.parseInt(l1[0]), l1[1], l1[2], Integer.parseInt(l1[3]), l1[4], true);
                                v_obj.add(v);
                            }
                        }
                        m.writeVehicleData(v_obj);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    flag1 = false;
                    break;
                default:
                    break;
            }
        }
    }
}
