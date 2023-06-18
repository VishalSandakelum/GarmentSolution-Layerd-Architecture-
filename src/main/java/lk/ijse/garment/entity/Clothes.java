package lk.ijse.garment.entity;

public class Clothes {

    private String clothes_type;
    private String sku;
    private String color;
    private String amount;
    private double price;
    private String material_id;
    private String date;
    private double Total;

    public Clothes(){
    }

    public Clothes(String clothes_type, String sku, String color, String amount, double price, String material_id, String date, double total) {
        this.clothes_type = clothes_type;
        this.sku = sku;
        this.color = color;
        this.amount = amount;
        this.price = price;
        this.material_id = material_id;
        this.date = date;
        Total = total;
    }

    public String getClothes_type() {
        return clothes_type;
    }

    public void setClothes_type(String clothes_type) {
        this.clothes_type = clothes_type;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "clothes_type='" + clothes_type + '\'' +
                ", sku='" + sku + '\'' +
                ", color='" + color + '\'' +
                ", amount='" + amount + '\'' +
                ", price=" + price +
                ", material_id='" + material_id + '\'' +
                ", date='" + date + '\'' +
                ", Total=" + Total +
                '}';
    }

}
