package com.g.pos_software.service.impl;

import com.g.pos_software.domain.UserRole;
import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.mapper.CategoryMapper;
import com.g.pos_software.models.Category;
import com.g.pos_software.models.Store;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.CategoryDto;
import com.g.pos_software.repository.CategoryRepository;
import com.g.pos_software.repository.StoreRepository;
import com.g.pos_software.service.CategoryService;
import com.g.pos_software.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private  final UserService userService;
    private final StoreRepository storeRepository;

    @Override
    public CategoryDto createCategory(CategoryDto dto) throws Exception {
        User user=userService.getCurrentUser();
        Store store =storeRepository.findById(dto.getStoreId()).orElseThrow(()->new Exception("Store not found"));
        Category category=Category.builder()
                .name(dto.getName())
                .store(store)
                .build();
        checkAuthority(user,category.getStore());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toDto(savedCategory);
    }

    @Override
    public List<CategoryDto> getCategoriesByStoreId(Long storeId) {
        List<Category>  categories=categoryRepository.findByStoreId(storeId);


        return categories.stream().map(
                CategoryMapper::toDto
        ).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto) throws Exception {
        Category category=categoryRepository.findById(id).orElseThrow(()->new UserException("Category not found"));
        User user=userService.getCurrentUser();
        category.setName(dto.getName());
        checkAuthority(user,category.getStore());
        return CategoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        Category category=categoryRepository.findById(id).orElseThrow(
                ()->new UserException("Category not found")
        );

        User user=userService.getCurrentUser();
        checkAuthority(user,category.getStore());
        categoryRepository.delete(category);
    }

    private void checkAuthority(User user, Store store) throws Exception {
        boolean isAdmin =user.getRole().equals(UserRole.ROLE_ADMIN);
        boolean isManager=user.getRole().equals(UserRole.ROLE_STORE_MANAGER);
        boolean isSameStore= user.equals(store.getStoreAdmin());

        if(!(isAdmin && isSameStore)&& !isManager){
            throw new Exception("You are not authorized to perform this action");
        }

    }

}
