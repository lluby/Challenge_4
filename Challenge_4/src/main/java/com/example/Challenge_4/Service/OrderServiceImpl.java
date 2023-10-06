package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Order;
import com.example.Challenge_4.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order AddOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String MerchantCode) {
        orderRepository.deleteById(MerchantCode);
    }

    @Override
    public void getOrderDetails(String OrderId) {
        orderRepository.deleteById(OrderId);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
