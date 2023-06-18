package lk.ijse.garment.entity;

public class Customer {

    private String name;
    private String customer_id;
    private String nic_number;
    private int contact_number;
    private String address;
    private int bank_number;
    private String gmail;
    private String Date;

    public Customer(){}

    public Customer(String name, String customer_id, String nic_number, int contact_number, String address, int bank_number, String gmail, String date) {
        this.name = name;
        this.customer_id = customer_id;
        this.nic_number = nic_number;
        this.contact_number = contact_number;
        this.address = address;
        this.bank_number = bank_number;
        this.gmail = gmail;
        Date = date;
    }

    public Customer(String name, String nic_number, Integer contact_number, String address, Integer bank_number, String gmail, String customer_id) {
        this.name = name;
        this.customer_id = customer_id;
        this.nic_number = nic_number;
        this.contact_number = contact_number;
        this.address = address;
        this.bank_number = bank_number;
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getNic_number() {
        return nic_number;
    }

    public void setNic_number(String nic_number) {
        this.nic_number = nic_number;
    }

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBank_number() {
        return bank_number;
    }

    public void setBank_number(int bank_number) {
        this.bank_number = bank_number;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", nic_number='" + nic_number + '\'' +
                ", contact_number=" + contact_number +
                ", address='" + address + '\'' +
                ", bank_number=" + bank_number +
                ", gmail='" + gmail + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
