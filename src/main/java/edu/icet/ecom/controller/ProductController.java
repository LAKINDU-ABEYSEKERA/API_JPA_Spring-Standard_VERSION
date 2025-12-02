package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.CustomerDTO;
import edu.icet.ecom.model.dto.ProductDTO;
import edu.icet.ecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public Optional<ProductDTO> addCustomer(@RequestBody ProductDTO productDTO){
        return productService.addCustomer(productDTO);
    }



}
