package com.example.demo.order;



import com.example.demo.client.Client;
import com.example.demo.client.ClientRepository;
import com.example.demo.order.dto.CreateOrderDTO;
import com.example.demo.order.dto.UpdateOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ClientRepository clientRepo;

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // Get an order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }

    // Create a new order
    public Order createOrder(CreateOrderDTO createOrderDTO) {
        Optional<Client> clientOptional = clientRepo.findById(createOrderDTO.getClientId());
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            Order newOrder = new Order();
            newOrder.setStatus(createOrderDTO.getStatus());
            newOrder.setPaymentMethod(createOrderDTO.getPaymentMethod());
            newOrder.setClient(client);  // Set the client

            return orderRepo.save(newOrder);  // Save the order
        } else {
            throw new IllegalArgumentException("Client not found.");
        }
    }

    // Update an order
    public Optional<Order> updateOrder(Long id, UpdateOrderDTO updateOrderDTO) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(updateOrderDTO.getStatus());
            order.setPaymentMethod(updateOrderDTO.getPaymentMethod());

            Optional<Client> clientOptional = clientRepo.findById(updateOrderDTO.getClientId());
            clientOptional.ifPresent(order::setClient);

            return Optional.of(orderRepo.save(order));  // Save the updated order
        } else {
            return Optional.empty();
        }
    }

    // Delete an order
    public boolean deleteOrder(Long id) {
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
