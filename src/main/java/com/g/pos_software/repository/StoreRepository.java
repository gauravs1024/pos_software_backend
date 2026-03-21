package com.g.pos_software.repository;

import com.g.pos_software.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
    Store findByStoreAdminId(Long adminId);
}
