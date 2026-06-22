package org.example.ordermanagementjpa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // we dont want to type for getter setter lombok boilerplate definition handler

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "New_customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)


}
