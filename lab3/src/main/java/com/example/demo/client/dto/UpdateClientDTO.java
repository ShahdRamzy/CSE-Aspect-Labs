package com.example.demo.client.dto;


import com.example.demo.order.Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class UpdateClientDTO {

    private String name;

    private String email;



    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

    // Default constructor
    public UpdateClientDTO() {
    }

    // Constructor with fields
    public UpdateClientDTO(String name, String email, List<Order> orders) {
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