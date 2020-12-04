package SWIapp.OrdersProcessing.model;

import java.util.List;
import java.util.Optional;

public interface ListOfOrders {
    //    abstract method which insert new order with id in the list of orders
    int insertOrder(long id, Order order);

    //    abstract method which filter orders in database by id
    Optional<Order> orderById(long id);

    //    abstract method which select and view all orders from database
    List<Order> allOrders();

    //    abstract method which delete order from database
    int deleteOrder(long id);

    //    abstract method which update order in database
    int updateOrder(long id, Order order);
}
