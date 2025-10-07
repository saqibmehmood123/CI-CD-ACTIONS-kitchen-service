package com.fooddelievery.command;


import com.fooddelievery.event.OrderCreatedEvent;
import com.fooddelievery.event.OrderPreparedEvent;
import com.fooddelievery.model.KItchenOrder;
import com.fooddelievery.repository.KitchenOrderRepository;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class KitchenOrderCommandService {

    private final KitchenOrderRepository repository;
   // private final KafkaTemplate<String, Object> kafkaTemplate; // Inject KafkaTemplate

    public KitchenOrderCommandService(KitchenOrderRepository repository
    //                                  KafkaTemplate<String, Object> kafkaTemplate
    ) {
        this.repository = repository;
    ///    this.kafkaTemplate = kafkaTemplate;
    }

   /// @KafkaListener(topics = "order-created-topic", groupId = "kitchen-service-group")
    @Transactional
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("Received order for kitchen: " + event.getOrderId());
        System.out.println("   ----------------------   this  is kitchen miocroservice    -------------------------- ");
        System.out.println("   ----------------------   this  is kitchen miocroservice   -------------------------- ");
        System.out.println("   ----------------------   this  is kitchen miocroservice   -------------------------- ");

        // 1. Convert event and save to DB
        KItchenOrder kitchenOrder = new KItchenOrder();
        kitchenOrder.setOrderId(event.getOrderId());
        kitchenOrder.setItem(event.getItem() );
        kitchenOrder.setQuantity(event.getQuantity());
        kitchenOrder.setStatus("ACCEPTED");
        repository.save(kitchenOrder);

        System.out.println("Order saved. Starting cooking simulation for: " + event.getOrderId());

        // 2. Simulate cooking process (e.g., wait for 5 seconds)
        simulateCooking();

        // 3. Update status in the Kitchen Service's database
        kitchenOrder.setStatus("READY_FOR_DELIVERY");
        repository.save(kitchenOrder); // Update the status

        // 4. Publish the new event to the "order-prepared-topic"
/*
        OrderPreparedEvent preparedEvent = new OrderPreparedEvent(
                event.getOrderId(),
                "READY_FOR_DELIVERY"
        );
*/


        OrderCreatedEvent  orderCreatedEvent = preparedOrderCreated(event);
      ///  kafkaTemplate.send("order-prepared-topic", orderCreatedEvent);

        System.out.println("Order prepared and event published: " + event.getOrderId());
    }

    private void simulateCooking() {
        try {
            // Simulate 5 seconds of cooking time
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Cooking interrupted", e);
        }
    }

private  OrderCreatedEvent preparedOrderCreated(OrderCreatedEvent event)
{
    event.setStatus("READY_FOR_DELIVERY");
    event.setTimestamp(LocalDateTime.now());
    event.setEventId(UUID.randomUUID().toString());
    return event;
}

}