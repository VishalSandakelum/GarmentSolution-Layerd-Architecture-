package lk.ijse.garment.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Order {

    private String customer_id;
    private String type;
    private String order_date;
    private String dead_date;
    private String order_id;

}
