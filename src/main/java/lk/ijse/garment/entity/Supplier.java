package lk.ijse.garment.entity;

public class Supplier {

    private String name;
    private String nic;
    private String gmail;
    private String address;
    private int conumber;
    private int banumber;
    private String id;

    public Supplier() {
    }

    public Supplier(String name, String nic, String gmail, String address, int conumber, int banumber, String id) {
        this.name = name;
        this.nic = nic;
        this.gmail = gmail;
        this.address = address;
        this.conumber = conumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getConumber() {
        return conumber;
    }

    public void setConumber(int conumber) {
        this.conumber = conumber;
    }

    public int getBanumber() {
        return banumber;
    }

    public void setBanumber(int banumber) {
        this.banumber = banumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
