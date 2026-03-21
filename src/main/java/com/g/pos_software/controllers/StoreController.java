package com.g.pos_software.controllers;

import com.g.pos_software.domain.StoreStatus;
import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.logger.AppLogger;
import com.g.pos_software.mapper.StoreMapper;
import com.g.pos_software.models.Store;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.StoreDto;
import com.g.pos_software.payload.response.ApiResponse;
import com.g.pos_software.service.StoreService;
import com.g.pos_software.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor


@RequestMapping("/api/store")
public class StoreController {
    private  final StoreService storeService;
    private  final UserService userService;
    private final AppLogger logger;

    @PostMapping
    public ResponseEntity<StoreDto>createStore(@RequestBody StoreDto storeDto,
                                               @RequestHeader("Authorization")String jwt) throws UserException {
        User user=userService.getUserFromJwtToken(jwt);
        logger.info("Use Extracted from jwt Token is "+user.getEmail());
        return ResponseEntity.ok(storeService.createStore(storeDto,user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto>getStoreById(@PathVariable Long id,
                                               @RequestHeader("Authorization")String jwt) throws Exception {

        return ResponseEntity.ok(storeService.getStoreById(id));
    }


    @GetMapping
    public ResponseEntity<List<StoreDto>>getAllStore(
                                                     @RequestHeader("Authorization")String jwt) throws UserException {
        logger.info("Getting all stores");
        return ResponseEntity.ok(storeService.getAllStores());
    }


    @GetMapping("/admin")
    public ResponseEntity<StoreDto>getStoreByAdmin(
                                                @RequestHeader("Authorization")String jwt) throws UserException {

        return ResponseEntity.ok(StoreMapper.toDto(storeService.getStoreByAdmin()));
    }

    @GetMapping("/employee")
    public ResponseEntity<StoreDto>getStoreByEmployee(
            @RequestHeader("Authorization")String jwt) throws UserException {

        return ResponseEntity.ok(storeService.getStoreByEmployee());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDto>updateStore(@PathVariable Long id,
            @RequestHeader("Authorization")StoreDto storeDto) throws Exception {

        return ResponseEntity.ok(storeService.updateStore(id,storeDto));
    }

    @PutMapping("/{id}/moderate")
    public ResponseEntity<StoreDto>moderateStore(@PathVariable Long id,
                                               @RequestParam StoreStatus storeStatus
                                              ) throws Exception {

        return ResponseEntity.ok(storeService.moderateStore(id,storeStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStore(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {

        storeService.deleteStore(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .status(true)
                        .message("Store deleted successfully")
                        .data(null)
                        .build()
        );
    }


}
