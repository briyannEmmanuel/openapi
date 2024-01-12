package com.groupeisi.mapping;

import com.groupeisi.entities.AppRolesEntity;
import com.groupeisi.entities.ProductEntity;
import com.groupeisi.generated.model.ProductDTO;
import com.groupeisi.generated.model.RoleDTO;
import com.groupeisi.generated.model.RolesResultListDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AppRolesMapper {
    RoleDTO toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(RoleDTO roleDTO);
    //RolesResultListDTO rolesListDTO(List<AppRolesEntity> rolesEntities);

    List<RoleDTO> rolesListDTO(List<AppRolesEntity> rolesEntities);
}
