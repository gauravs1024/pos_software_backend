package com.g.pos_software.repository;

import com.g.pos_software.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByStoreId(Long storeId);
}
