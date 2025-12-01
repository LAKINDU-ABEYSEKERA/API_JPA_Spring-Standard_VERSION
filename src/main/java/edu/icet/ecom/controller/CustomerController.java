package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.CustomerDTO;
import edu.icet.ecom.model.entity.Customer;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerSaved = customerService.addCustomer(customerDTO);
        return ResponseEntity.ok(customerSaved);
    }

    @GetMapping("/searchCustomer={id}")
    public ResponseEntity<?> searchCustomer(@PathVariable int id) {
        Optional<CustomerDTO> result = customerService.searchCustomer(id);

        return result.isPresent()? ResponseEntity.ok(result.get()) : ResponseEntity.status(404).body("Customer Not Found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        String msg = customerService.removeCustomer(id);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("getAllCustomers")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        List<CustomerDTO> list = customerService.getAllCustomers();
        return ResponseEntity.ok(list);

    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable int id,
            @RequestBody CustomerDTO dto
    ){
        Optional<CustomerDTO> updated = customerService.updateCustomer(id,dto);

        return updated.isPresent()
                ? ResponseEntity.ok(updated.get())
                : ResponseEntity.status(404).body("Customer doesn't exist!");
    }
}
