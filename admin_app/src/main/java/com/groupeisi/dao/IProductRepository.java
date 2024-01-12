package com.groupeisi.dao;

import com.groupeisi.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
}
