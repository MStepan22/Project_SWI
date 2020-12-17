package SWIapp.OrdersProcessing.model;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryListOfOrders implements ListOfOrders{

    private final List<Order> orders = new ArrayList<>();

    //    method insert new order in database
    @Override
    public int insertOrder(UUID id, Order order) {
        orders.add(new Order (id, order.getOrderName()));
        return 1;
    }

    //    method filter order from database by id
    @Override
    public Optional<Order> orderById(UUID id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
    }

    //    method returns all orders from database
    @Override
    public List<Order> allOrders() {
        return Collections.unmodifiableList(orders);
    }

    //    method delete existing order from database
    @Override
    public int deleteOrder(UUID id) {
        Optional<Order> orderMaybe = orderById(id);
        if (orderMaybe == null) {
            return 0;
        }
        orders.remove(orderMaybe.get());
        return 1;
    }

    //    method update existing order from database
    @Override
    public int updateOrder(UUID id, Order order) {
        return orderById(id)
                .map(o -> {
                    int indexOfOrderToUpdate = orders.indexOf(order);
                    if (indexOfOrderToUpdate >= 0) {
                        orders.set(indexOfOrderToUpdate, order);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
