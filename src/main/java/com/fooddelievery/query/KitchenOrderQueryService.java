package com.fooddelievery.query;

import com.fooddelievery.model.KItchenOrder;
import com.fooddelievery.repository.KitchenOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenOrderQueryService {

    private final KitchenOrderRepository repository;

    public KitchenOrderQueryService(KitchenOrderRepository repository) {
        this.repository = repository;
    }

    // Get all orders in the kitchen (for a queue view)
    public List<KItchenOrder> getAllOrders() {
        return repository.findAll(); // Uses JpaRepository's built-in method
    }

    // Get a specific order by its ID
    public KItchenOrder getOrderById(String orderId) {
        return repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    // Get all orders with a specific status (e.g., all "COOKING" orders)
    public List<KItchenOrder> getOrdersByStatus(String status) {
        // This requires a custom method in the Repository interface
        return repository.findByStatus(status);
    }
}