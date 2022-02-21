

public class Vehicle {
    private int id_code;
    private String brand;
    private String model;
    private int seats;
    private String license_plate;
    private boolean availability;

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getId_code() {
        return id_code;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public boolean isAvailability() {
        return availability;
    }


    public Vehicle(int id_code, String brand, String model, int seats, String license_plate, boolean availability) {
        this.id_code = id_code;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.license_plate = license_plate;
        this.availability = availability;
    }


}

