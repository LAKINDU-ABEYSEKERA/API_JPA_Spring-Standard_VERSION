package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.CustomerDTO;
import edu.icet.ecom.model.entity.Customer;
import edu.icet.ecom.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        int nextId = 1;
        List<Customer> customers = customerRepository.findAll();

        for (Customer tempCus : customers) {
            if (nextId!=tempCus.getCustomerId()){
                nextId++;
            } else {
                break;
            }
        }

        Customer customer = customerRepository.save(
                new Customer(
                        nextId,
                        customerDTO.getName(),
                        customerDTO.getAddress(),
                        customerDTO.getContact()
                ));

        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getContact()
        );
    }


    public Optional<CustomerDTO> searchCustomer(int id) {
        return customerRepository.findById(id).map(
                c -> new CustomerDTO(
                    c.getCustomerId(),
                    c.getName(),
                    c.getAddress(),
                    c.getContact()
                )
        );
    }
}