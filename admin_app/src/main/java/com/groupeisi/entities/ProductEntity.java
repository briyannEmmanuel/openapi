package com.groupeisi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(unique = true, nullable = false, length = 200)
    private String name;
    @Column(nullable = false)
    private double qtStock;
    @ManyToOne
    private AppUserEntity appUserEntity;
}
