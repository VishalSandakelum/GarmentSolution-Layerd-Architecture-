package lk.ijse.garment.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeePay {
    String Date;
    String employee_id;
    String payment_id;
    double payment;
}
