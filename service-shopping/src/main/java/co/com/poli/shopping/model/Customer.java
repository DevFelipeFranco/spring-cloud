package co.com.poli.shopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long Id;
    private String numberID;
    private String firstName;
    private String lastName;
    private String email;
}
