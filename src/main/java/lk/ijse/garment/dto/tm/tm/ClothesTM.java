package lk.ijse.garment.dto.tm.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ClothesTM {
    private String type;
    private String sku;
    private String color;
    private String amount;
    private double price;
    private String mat_id;
    private String date;
    private double total;
}
