package lk.ijse.garment.entity;

public class Order {

    private String customer_id;
    private String type;
    private String order_date;
    private String dead_date;
    private String order_id;

    public Order(){}

    public Order(String customer_id, String type, String order_date, String dead_date, String order_id) {
        this.customer_id = customer_id;
        this.type = type;
        this.order_date = order_date;
        this.dead_date = dead_date;
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getDead_date() {
        return dead_date;
    }

    public void setDead_date(String dead_date) {
        this.dead_date = dead_date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer_id='" + customer_id + '\'' +
                ", type='" + type + '\'' +
                ", order_date='" + order_date + '\'' +
                ", dead_date='" + dead_date + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
