package edu.icet.ecom.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Product {
    @Id
    private Integer productId;
    private String name;
    private int price;
}
