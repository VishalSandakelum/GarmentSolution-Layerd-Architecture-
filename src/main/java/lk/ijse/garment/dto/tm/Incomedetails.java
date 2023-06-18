package lk.ijse.garment.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Incomedetails {
    private String id;
    private String month;
    private Double empaymenttotal;
    private Double cuspaymentotal;
    private Double proflose;

    public Incomedetails(String month, Double empaymenttotal, Double cuspaymentotal, Double proflose) {
        this.month = month;
        this.empaymenttotal = empaymenttotal;
        this.cuspaymentotal = cuspaymentotal;
        this.proflose = proflose;
    }
}
