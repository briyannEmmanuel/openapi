package com.groupeisi.controller;

import com.groupeisi.generated.api.ProductsApi;
import com.groupeisi.generated.model.ProductDTO;
import com.groupeisi.generated.model.ProductsResultListDTO;
import com.groupeisi.service.ProductService;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductsApi {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductsResultListDTO> getAllProducts(Integer currentPage, Integer sizePage) throws Exception {

        ProductsResultListDTO productsResultListDTO = new ProductsResultListDTO();
        productsResultListDTO.setProductList(productService.getAllProduct());
        return new ResponseEntity<>(productsResultListDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody(required = false) ProductDTO productDTO) throws Exception {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> getProduct(@ApiParam(value = "",required=true) @PathVariable("idProduct") Long idProduct) throws Exception {
        return new ResponseEntity<>(productService.getProduct(idProduct.intValue()),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> updateProduct(@ApiParam(value = "",required=true) @PathVariable("idProduct") Long idProduct,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) ProductDTO productDTO) throws Exception {
        return new ResponseEntity<>(productService.updateProduct(idProduct.intValue(),productDTO),HttpStatus.OK);
    }
}
