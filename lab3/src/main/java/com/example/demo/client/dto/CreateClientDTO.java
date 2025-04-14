package com.example.demo.client.dto;

import com.example.demo.order.Order;
import java.util.List;

public class CreateClientDTO {

    private String name;
    private String email;
    private List<Order> orders;  // Just a List, no JPA annotations here

    // Default constructor
    public CreateClientDTO() {
    }

    // Constructor with fields
    public CreateClientDTO(String name, String email, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
