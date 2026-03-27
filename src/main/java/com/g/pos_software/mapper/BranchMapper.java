package com.g.pos_software.mapper;

import com.g.pos_software.models.Branch;
import com.g.pos_software.models.Store;
import com.g.pos_software.payload.dto.BranchDto;

public class BranchMapper {

    public static BranchDto toDto(Branch branch){
        return BranchDto.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .phone(branch.getPhone())
                .email(branch.getEmail())
                .workingDays(branch.getWorkingDays())
                .openTime(branch.getOpenTime())
                .closeTime(branch.getCloseTime())
                .createdAt(branch.getCreatedAt())
                .updatedAt(branch.getUpdatedAt())
                .storeId(branch.getStore()!=null?branch.getStore().getId():null)
//                .manager(UserMapper.toDto(branch.getManager()))
                .build();
    }
    public static Branch toEntity(BranchDto branchDto, Store store) {
        return Branch.builder()
                .id(branchDto.getId())
                .name(branchDto.getName())
                .address(branchDto.getAddress())
                .store(store)
                .phone(branchDto.getPhone())
                .email(branchDto.getEmail())
                .closeTime(branchDto.getCloseTime())
                .openTime(branchDto.getOpenTime())
                .workingDays(branchDto.getWorkingDays())
                .createdAt(branchDto.getCreatedAt())
                .updatedAt(branchDto.getUpdatedAt())
                .build();
    }

}
