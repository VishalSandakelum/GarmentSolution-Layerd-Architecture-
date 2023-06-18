package lk.ijse.garment.dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee {

    private String name;
    private String nic;
    private String gmail;
    private Integer conumber;
    private String address;
    private String id;
    private Integer banumber;
    private String Date;

    public Employee(String name, String nic, String gmail, Integer conumber, String address, Integer banumber, String id) {
        this.name = name;
        this.nic = nic;
        this.gmail = gmail;
        this.conumber = conumber;
        this.address = address;
        this.banumber = banumber;
        this.id = id;
    }
}
