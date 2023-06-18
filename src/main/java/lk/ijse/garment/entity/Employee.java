package lk.ijse.garment.entity;

public class Employee {

    private String name;
    private String nic;
    private String gmail;
    private int conumber;
    private String address;
    private String id;
    private int banumber;
    private String Date;

    public Employee() {
    }

    public Employee(String name, String nic, String gmail, int conumber, String address, String id, int banumber, String date) {
        this.name = name;
        this.nic = nic;
        this.gmail = gmail;
        this.conumber = conumber;
        this.address = address;
        this.id = id;
        this.banumber = banumber;
        Date = date;
    }

    public Employee(String name, String nic, String gmail, Integer conumber, String address, Integer banumber, String id) {
        this.name = name;
        this.nic = nic;
        this.gmail = gmail;
        this.conumber = conumber;
        this.address = address;
        this.banumber = banumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getConumber() {
        return conumber;
    }

    public void setConumber(int conumber) {
        this.conumber = conumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBanumber() {
        return banumber;
    }

    public void setBanumber(int banumber) {
        this.banumber = banumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", gmail='" + gmail + '\'' +
                ", conumber=" + conumber +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", banumber=" + banumber +
                ", Date='" + Date + '\'' +
                '}';
    }
}
