package edu.icet.ecom.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Customer {
    @Id
    private int customerId;
    private String name;
    private String address;
    private String contact;
}
