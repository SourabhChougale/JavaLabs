

public class Customer {

    private String name;
    private String id_num;
    private int id_code;
    private String startDate;
    private String endDate;

    public Customer(String name, String id_num, int id_code, String startDate, String endDate) {
        this.name = name;
        this.id_num = id_num;
        this.id_code = id_code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getId_num() {
        return id_num;
    }


    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getId_code() {
        return id_code;
    }

}



