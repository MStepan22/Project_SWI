package SWIapp.OrdersProcessing.controller;

import SWIapp.OrdersProcessing.model.ListOfOrders;
import SWIapp.OrdersProcessing.model.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("api/orders")
public class OrderController {


    private final ListOfOrders listOfOrders;
    private final String messageDestination;
    private final JmsTemplate jmsTemplate;

    @Autowired
    public OrderController(ListOfOrders listOfOrders, @Value("${message.destination}") String messageDestination, JmsTemplate jmsTemplate) {
        this.listOfOrders = listOfOrders;
        this.messageDestination = messageDestination;
        this.jmsTemplate = jmsTemplate;
    }

    @Operation(summary = "Gets a list of all orders in the list of orders.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "A list of all orders",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Order.class)))}),
    })

    @PostMapping
    public void insertOrder(@RequestBody Order order) {
        listOfOrders.insertOrder(order);
    }

    @GetMapping("")
    public List<Order> getOrders() {
        return listOfOrders.allOrders();
    }

    @GetMapping (path = "{id}")
    public Order orderById(@PathVariable("id") UUID id) {
        return listOfOrders.orderById(id)
                .orElse(null);
    }

    @DeleteMapping (path = "{id}")
    public void deleteOrderById(@PathVariable("id") UUID id) {
        listOfOrders.deleteOrder(id);
    }

    @PutMapping (path = "{id}")
    public void updateOrder(@PathVariable("id") UUID id, @RequestBody Order orderToUpdate) {
        listOfOrders.updateOrder(id, orderToUpdate);
    }
}
