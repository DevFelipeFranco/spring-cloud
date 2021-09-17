package co.com.poli.customer.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotEmpty(message = "El nit/numero no puede ser vacio")
    @Size(min = 8, message = "El tamaño del nit/numero debe ser minimo de 8")
    @Column(name = "number_id", unique = true,nullable = false)
    private String numberID;
    @NotEmpty(message = "El nombre no puede ser vacio")
    @Column(name="first_name")
    private String firstName;
    @NotEmpty(message = "El apellido no puede ser vacio")
    @Column(name="last_name")
    private String lastName;
    @Email(message = "NO es una direccion de email valida")
    @Column(unique = true,nullable = false)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(Id, customer.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
