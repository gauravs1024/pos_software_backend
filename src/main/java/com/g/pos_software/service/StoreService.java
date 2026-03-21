package com.g.pos_software.service;

import com.g.pos_software.domain.StoreStatus;
import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.models.Store;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.StoreDto;

import java.util.List;

public interface StoreService {

    StoreDto createStore(StoreDto storeDto, User user);
    StoreDto getStoreById(Long id) throws  Exception;
    List<StoreDto> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDto updateStore(Long id,StoreDto storeDto) throws Exception;
    void deleteStore(Long id) throws UserException;
    StoreDto getStoreByEmployee() throws UserException;
    StoreDto moderateStore(Long id, StoreStatus storeStatus) throws  Exception;

}
