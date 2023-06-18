package lk.ijse.garment.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Material {
    private String materialname;
    private String material_id;
    private String id;
    private String amount;
    private Double price;

    public Material(String materialname, String id, String amount, double price, String material_id) {
        this.materialname = materialname;
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.material_id = material_id;
    }

    public Material(String material_id) {
        this.material_id = material_id;
    }
}
