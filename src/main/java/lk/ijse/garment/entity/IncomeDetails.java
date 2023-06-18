package lk.ijse.garment.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class IncomeDetails {
    int id;
    String month;
    double empaymentotal;
    double cuspaymentotal;
    double proflose;

    public IncomeDetails(String month, Double empaymenttotal, Double cuspaymentotal, Double proflose) {
        this.month = month;
        this.empaymentotal = empaymenttotal;
        this.cuspaymentotal = cuspaymentotal;
        this.proflose = proflose;
    }
}
