package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.CustomerDTO;
import edu.icet.ecom.model.dto.ProductDTO;
import edu.icet.ecom.model.entity.Product;
import edu.icet.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<ProductDTO> addCustomer(ProductDTO productDTO) {

        List<ProductDTO> productList = new ArrayList<>();
        int nextid = 1;

        for (ProductDTO array : productList) {
            if (array!=null){
                nextid++;
            } else {
                break;
            }
        }

        productRepository.save(
                new Product(
                        nextid,
                        productDTO.getName(),
                        productDTO.getPrice()
                )
        );

        return Optional.of(new ProductDTO(
                nextid,
                productDTO.getName(),
                productDTO.getPrice()
        ));
    }
}
