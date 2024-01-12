package com.groupeisi.dao;

import com.groupeisi.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
}
