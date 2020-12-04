package SWIapp.OrdersProcessing.model;

public class Order {

    private final long id;
    private final String orderName;

    public Order(long id, String orderName) {
        this.id = id;
        this.orderName = orderName;
    }

    public long getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }
}
