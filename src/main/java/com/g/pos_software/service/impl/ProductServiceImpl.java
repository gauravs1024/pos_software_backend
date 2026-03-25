package com.g.pos_software.service.impl;

import com.g.pos_software.mapper.ProductMapper;
import com.g.pos_software.models.Category;
import com.g.pos_software.models.Product;
import com.g.pos_software.models.Store;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.ProductDto;
import com.g.pos_software.repository.CategoryRepository;
import com.g.pos_software.repository.ProductRepository;
import com.g.pos_software.repository.StoreRepository;
import com.g.pos_software.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto createdProduct(ProductDto productDto, User user) throws Exception {
//
//        Store store=storeRepository.findById(
//                productDto.getStoreId()
//        ).orElseThrow(()->new Exception("Store not found"));
        Store store= productDto.getStore();
        if(store==null){
            throw new Exception("Store not found");
        }
        Category category=categoryRepository.findById(productDto.getCategoryId()).orElseThrow(()->new Exception("Category not found"));

        Product product= ProductMapper.toEntity(productDto,store,category);
        Product savedProduct= productRepository.save(product);
        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto, User user) throws Exception {
        Product product=productRepository.findById(id).orElseThrow(()->new Exception("Product not found"));

        product.setName(productDto.getName());
        product.setMrp(productDto.getMrp());
        product.setSellingPrice(productDto.getSellingPrice());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setSku(productDto.getSku());
        product.setUpdatedAt(LocalDateTime.now());
        if(productDto.getCategoryId()!=null){
            Category category=categoryRepository.findById(productDto.getCategoryId()).orElseThrow(()->new Exception("Category not found"));
            product.setCategory(category);

        }
       Product savedProduct= productRepository.save(product);
        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public void deleteProduct(Long id, User user) throws Exception {
        Product product=productRepository.findById(id).orElseThrow(()->new Exception("Product not found"));
        productRepository.delete(product);

    }

    @Override
    public List<ProductDto> getProductByStoreId(Long storeId) {
        List<Product>products=productRepository.findByStoreId(storeId);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> searchByKeyword(Long storeId, String keyword) {
        List<Product>products=productRepository.searchByKeyword(storeId,keyword);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }
}
