package lk.ijse.garment.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Place {

    private String order_id;
    private String sku;
    private String quantity;
    private String unitprice;
    private String date;
    private double discount;
    private double total;

}
