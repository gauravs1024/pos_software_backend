package com.g.pos_software.service;

import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createdProduct (ProductDto productDto, User user) throws Exception;
    ProductDto updateProduct (Long id,ProductDto productDto,User user) throws Exception;
    void deleteProduct(Long id,User user) throws Exception;
    List<ProductDto> getProductByStoreId(Long storeId);
    List<ProductDto>searchByKeyword(Long storeId, String keyword);



}
