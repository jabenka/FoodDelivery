package com.food.food.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ORDERS")
public class DeliveryForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name="email")
    private String email;
    public DeliveryForm(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public DeliveryForm() {
    }
}
