package com.fooddelievery.event;


import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderCreatedEvent {
    private String orderId;
    private String productName;
    private Integer quantity;
    private String customerId;
    private LocalDateTime timestamp;
    private String status;
    private String item;
    private String eventId;

/*
    public OrderCreatedEvent(CreateOrderCommand command) {
        this.orderId = java.util.UUID.randomUUID().toString();
        this.productName = command.getProductName();
        this.quantity = command.getQuantity();
        this.customerId = command.getCustomerId();
        this.timestamp = LocalDateTime.now();
    }
*/


    public OrderCreatedEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }


}