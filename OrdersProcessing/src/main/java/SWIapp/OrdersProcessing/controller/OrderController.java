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

@RestController()
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private final ListOfOrders listOfOrders;
    private final String messageDestination;
    private final JmsTemplate jmsTemplate;

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

    @GetMapping("")
    public List<Order> getOrders() {
        return listOfOrders.allOrders();
    }

//    @PostMapping
//    public void insertOrder(@RequestBody long id, @RequestBody Order order) {
//        listOfOrders.insertOrder(long id, Order order);
//    }

    @GetMapping (path = "{id}")
    public Order orderById(@PathVariable("id") long id) {
        return listOfOrders.orderById(id)
                .orElse(null);
    }

    @DeleteMapping(path = {"id"})
    public void deleteOrderById(@PathVariable("id") long id) {
        listOfOrders.deleteOrder(id);
    }

    @PutMapping(path = {"id"})
    public void updateOrder(@PathVariable("id") long id, @RequestBody Order orderToUpdate) {
        listOfOrders.updateOrder(id, orderToUpdate);
    }
}
