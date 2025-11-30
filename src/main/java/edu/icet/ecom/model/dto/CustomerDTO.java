package edu.icet.ecom.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerDTO {

    private Integer customerId;
    private String name;
    private String address;
    private String contact;
}
