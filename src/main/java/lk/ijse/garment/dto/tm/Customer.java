package lk.ijse.garment.dto.tm;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Customer {

    private String name;
    private String customer_id;
    private String nic_number;
    private Integer contact_number;
    private String address;
    private Integer bank_number;
    private String gmail;
    private String Date;

    public Customer(String name, String nic_number, Integer contact_number, String address, Integer bank_number, String gmail, String customer_id) {
        this.name = name;
        this.customer_id = customer_id;
        this.nic_number = nic_number;
        this.contact_number = contact_number;
        this.address = address;
        this.bank_number = bank_number;
        this.gmail = gmail;
    }
}
