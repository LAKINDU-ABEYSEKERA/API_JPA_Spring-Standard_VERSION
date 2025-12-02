package edu.icet.ecom.model.dto;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ProductDTO {
    private Integer productId;
    private String name;
    private int price;
}
