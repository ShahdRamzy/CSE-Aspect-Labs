package com.example.demo.order;

import com.example.demo.client.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String paymentMethod;


    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;


    public Order(String status, String paymentMethod) {
        this.status = status;
        this.paymentMethod = paymentMethod;

    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client=client;
    }


}

