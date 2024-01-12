package com.groupeisi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(nullable = false, length = 150)
    private String firstname;
    @Column(nullable = false, length = 200)
    private String lastname;
    @Column(nullable = false, length = 200)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;
    @ManyToMany
    private List<AppRolesEntity> appRoleEntities;
    @OneToMany(mappedBy = "appUserEntity")
    private List<ProductEntity> productEntities;
}
