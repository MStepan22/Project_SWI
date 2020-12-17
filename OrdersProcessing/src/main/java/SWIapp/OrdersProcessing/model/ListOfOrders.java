package SWIapp.OrdersProcessing.model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ListOfOrders {
    //    abstract method which insert new order with id in the list of orders
    int insertOrder(UUID id, Order order);

    //    abstract method which insert new person with random id
    default int insertOrder (Order order) {
        UUID id = UUID.randomUUID();
        return insertOrder(id, order);
    }

    //    abstract method which filter orders in database by id
    Optional<Order> orderById(UUID id);

    //    abstract method which select and view all orders from database
    List<Order> allOrders();

    //    abstract method which delete order from database
    int deleteOrder(UUID id);

    //    abstract method which update order in database
    int updateOrder(UUID id, Order order);
}
