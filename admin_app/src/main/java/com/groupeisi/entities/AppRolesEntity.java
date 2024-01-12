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
@Table(name="roles")
public class AppRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Column(nullable = false, length = 100 )
    private String name;
    @ManyToMany(mappedBy = "appRoleEntities")
    private List<AppUserEntity> appUserEntity;
}
