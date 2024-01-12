package com.groupeisi.mapping;

import com.groupeisi.entities.ProductEntity;
import com.groupeisi.generated.model.ProductDTO;
import com.groupeisi.generated.model.ProductsResultListDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {
    ProductDTO toProduct(ProductEntity productEntity);
    ProductEntity fromProduct(ProductDTO productDTO);
    //ProductsResultListDTO productsListDTO(List<ProductEntity> productEntities);

    List<ProductDTO> productsListDTO(List<ProductEntity> productEntities);
}
