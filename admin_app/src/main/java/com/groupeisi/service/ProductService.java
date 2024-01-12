package com.groupeisi.service;

import com.groupeisi.dao.IProductRepository;
import com.groupeisi.exception.EntityNotFoundException;
import com.groupeisi.exception.RequestException;
import com.groupeisi.generated.model.ProductDTO;
import com.groupeisi.generated.model.ProductsResultListDTO;
import com.groupeisi.mapping.ProductMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class ProductService {
    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;
    MessageSource messageSource;

    public ProductService(IProductRepository iProductRepository, ProductMapper productMapper, MessageSource messageSource) {
        this.iProductRepository = iProductRepository;
        this.productMapper = productMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProduct() {

        return productMapper.productsListDTO(iProductRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ProductDTO getProduct(int id) {
        return productMapper.toProduct(iProductRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("product.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        return productMapper.toProduct(iProductRepository.save(productMapper.fromProduct(productDTO)));
    }

    @Transactional
    public ProductDTO updateProduct(long id, ProductDTO productDTO) {
        return iProductRepository.findById((int) id)
                .map(entity -> {
                    productDTO.setIdProduct(id);
                    return productMapper.toProduct(
                            iProductRepository.save(productMapper.fromProduct(productDTO)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("product.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteProduct(int id) {
        try {
            iProductRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("product.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
