package lk.ijse.garment.entity;

public class Material {

    private String materialname;
    private String material_id;
    private String id;
    private String amount;
    private Double price;

    public Material(String materialname, String material_id, String id, String amount, Double price) {
        this.materialname = materialname;
        this.material_id = material_id;
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public Material(){}

    public Material(String materialname, String id, String amount, Double price, String material_id) {
        this.materialname = materialname;
        this.material_id = material_id;
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public Material(String material_id) {
        this.material_id = material_id;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialname='" + materialname + '\'' +
                ", material_id='" + material_id + '\'' +
                ", id='" + id + '\'' +
                ", amount='" + amount + '\'' +
                ", price=" + price +
                '}';
    }

}
