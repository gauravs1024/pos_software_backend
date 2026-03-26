package com.g.pos_software.controllers;


import com.g.pos_software.payload.dto.CategoryDto;
import com.g.pos_software.payload.response.ApiResponse;
import com.g.pos_software.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private  final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto>createCategory(@RequestBody  CategoryDto categoryDto) throws Exception {
        CategoryDto createdCategory=categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDto>>getCategoriesByStoreId(
            @PathVariable Long storeId) throws Exception {
        return ResponseEntity.ok(categoryService.getCategoriesByStoreId(storeId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto>updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(categoryService.updateCategory(id,categoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse>deleteCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Long id) throws Exception {

        categoryService.deleteCategory(id);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("Category deleted successfully");
        apiResponse.setStatus(true);
        return ResponseEntity.ok(apiResponse);
    }




}
