package com.fooddelievery.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "kitchen_orders")
// Important: Your class must have a default (no-arg) constructor for JSON deserialization!
@Data
public class KItchenOrder {
    @Id
    private String orderId; // This comes from the OrderCreatedEvent

    private String item;
    private int quantity;

    private String status; // e.g., PENDING, ACCEPTED, COOKING, READY

    private LocalDateTime receivedAt;

    // Constructor, Getters, and Setters
    public KItchenOrder() {
        this.receivedAt = LocalDateTime.now();
    }

    public KItchenOrder(String orderId, String item, int quantity) {
        this();
        this.orderId = orderId;
        this.item = item;
        this.quantity = quantity;
        this.status = "PENDING";
    }
    // ... (getters and setters for all fields)


}
