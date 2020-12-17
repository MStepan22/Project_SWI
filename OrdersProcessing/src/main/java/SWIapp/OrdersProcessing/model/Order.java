package SWIapp.OrdersProcessing.model;

import java.util.UUID;

public class Order {

    private final UUID id;
    private final String orderName;

    public Order(UUID id, String orderName) {
        this.id = id;
        this.orderName = orderName;
    }

    public UUID getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }
}
