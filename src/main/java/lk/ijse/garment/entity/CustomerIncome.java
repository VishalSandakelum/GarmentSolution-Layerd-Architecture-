package lk.ijse.garment.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerIncome {
    String Date;
    String order_id;
    String payment_id;
    double payment;
}
