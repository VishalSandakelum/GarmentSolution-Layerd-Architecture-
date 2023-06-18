package lk.ijse.garment.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeePayment {
    String Date;
    String employee_id;
    String payment_id;
    double payment;
}
