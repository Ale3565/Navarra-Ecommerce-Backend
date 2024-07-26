package com.alexislevano.projectspring.controller;

import java.util.Date;

import com.alexislevano.projectspring.dao.ClientRepository;
import com.alexislevano.projectspring.dao.OrderItemRepository;
import com.alexislevano.projectspring.dao.OrderRepository;
import com.alexislevano.projectspring.dao.ProductRepository;
import com.alexislevano.projectspring.entities.Client;
import com.alexislevano.projectspring.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexislevano.projectspring.entities.OrderForm;
import com.alexislevano.projectspring.entities.OrderItem;
import com.alexislevano.projectspring.entities.OrderProduct;
import com.alexislevano.projectspring.entities.Product;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @PostMapping("/orders")
    public Order saveOrder(@RequestBody OrderForm orderForm){
        Client client=new Client();
        client.setName(orderForm.getClient().getName());
        client.setEmail(orderForm.getClient().getEmail());
        client.setAddress(orderForm.getClient().getAddress());
        client.setPhoneNumber(orderForm.getClient().getPhoneNumber());
        client.setUsername(orderForm.getClient().getUsername());
        client=clientRepository.save(client);
        System.out.println(client.getId());

        Order order=new Order();
        order.setClient(client);
        order.setDate(new Date());
        order=orderRepository.save(order);
        double total=0;
        for(OrderProduct p:orderForm.getProducts()){
           OrderItem orderItem=new OrderItem();
           orderItem.setOrder(order);
           Product product=productRepository.findById(p.getId()).get();
           orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(p.getQuantity());
            orderItemRepository.save(orderItem);
           total+=p.getQuantity()*product.getPrice();
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

}