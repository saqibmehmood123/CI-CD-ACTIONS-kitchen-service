package com.fooddelievery.query;

import com.fooddelievery.model.KItchenOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kitchen/orders")
public class KitchenOrderQueryController {

    @GetMapping
    public String getAllOrders() {
        return "  kitchen order is working ";
    }



/*
    private final KitchenOrderQueryService queryService;

    public KitchenOrderQueryController(KitchenOrderQueryService queryService) {
        this.queryService = queryService;
    }
*/

    // Get all orders in the kitchen queue
    // GET http://localhost:8082/kitchen/orders
/*
    @GetMapping
    public List<KItchenOrder> getAllOrders() {
        return queryService.getAllOrders();
    }

    // Get a specific order by its ID
    // GET http://localhost:8082/kitchen/orders/order-123
    @GetMapping("/{orderId}")
    public KItchenOrder getOrderById(@PathVariable String orderId) {
        return queryService.getOrderById(orderId);
    }

    // Get all orders with a specific status
    // GET http://localhost:8082/kitchen/orders/status/COOKING
    @GetMapping("/status/{status}")
    public List<KItchenOrder> getOrdersByStatus(@PathVariable String status) {
        return queryService.getOrdersByStatus(status);
    }
*/


}