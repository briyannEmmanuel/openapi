package com.groupeisi.mapping;

import com.groupeisi.entities.AppUserEntity;
import com.groupeisi.entities.ProductEntity;
import com.groupeisi.generated.model.ProductDTO;
import com.groupeisi.generated.model.UserDTO;
import com.groupeisi.generated.model.UsersResultListDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AppUserMapper {
    UserDTO toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser(UserDTO userDTO);
    //UsersResultListDTO usersListDTO(List<AppUserEntity> appUserEntities);

    List<UserDTO> usersListDTO(List<AppUserEntity> appUserEntities);
}
