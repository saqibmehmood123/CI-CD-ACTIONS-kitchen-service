package com.fooddelievery.event;


import java.util.UUID;

public class OrderPreparedEvent {

    private String eventId;
    private String orderId;
    private String status; // e.g., "READY_FOR_DELIVERY"
    private long timestamp;

    // Default constructor (required for JSON deserialization)
    public OrderPreparedEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    // Convenience constructor
    public OrderPreparedEvent(String orderId, String status) {
        this();
        this.orderId = orderId;
        this.status = status;
    }

    // Getters and Setters
    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "OrderPreparedEvent{" +
                "eventId='" + eventId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}