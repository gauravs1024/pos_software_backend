package com.g.pos_software.service;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.BranchDto;

import java.util.List;

public interface BranchService {
    BranchDto createBranch(BranchDto branchDto) throws UserException;
    BranchDto updateBranch(Long id,BranchDto branchDto) throws Exception;
    void deleteBranch(Long id) throws Exception;
    List<BranchDto> getAllBranchesByStoreId(Long storeId);
    BranchDto getBranchById(Long id) throws Exception;
}
