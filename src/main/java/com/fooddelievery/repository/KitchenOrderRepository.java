package com.fooddelievery.repository;


import com.fooddelievery.model.KItchenOrder;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface KitchenOrderRepository extends JpaRepository<KItchenOrder, String> {
    // The ID is the orderId (String)
    // JpaRepository provides save(), findById(), findAll(), etc. automatically.

    // Spring Data JPA will automatically implement this method based on its name!
    // It translates to: SELECT * FROM kitchen_orders WHERE status = ?
  //  List<KItchenOrder> findByStatus(String status);
//}

public class KitchenOrderRepository
{

}