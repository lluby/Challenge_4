package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order AddOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(String OrderId);
    void getOrderDetails(String selectedOrderName);
    List<Order> getAllOrder();
}
