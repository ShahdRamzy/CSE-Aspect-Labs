package com.example.demo.client;

import com.example.demo.client.dto.CreateClientDTO;
import com.example.demo.client.dto.UpdateClientDTO;

import com.example.demo.order.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }


    public Client createClient(CreateClientDTO clientDTO) {

            Client newClient = new Client();
            newClient.setName(clientDTO.getName());
            newClient.setEmail(clientDTO.getEmail());

            // Set client reference for each order before saving
            for (Order order : clientDTO.getOrders()) {
                order.setClient(newClient);  // Link order to client
            }

            newClient.setOrders(clientDTO.getOrders());  // Set orders for the client

            // Save client, cascading saves the orders as well due to CascadeType.ALL
            return clientRepository.save(newClient);
        }




    public Client updateClient(Long id, UpdateClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("client not found with id: " + id));

        // Copy only non-null properties from DTO to entity
        BeanUtils.copyProperties(clientDTO, existingClient, getNullPropertyNames(clientDTO));

        return clientRepository.save(existingClient);
    }


    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        clientRepository.delete(client);
    }


    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}