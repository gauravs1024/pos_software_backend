package com.g.pos_software.service.impl;

import com.g.pos_software.domain.UserRole;
import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.mapper.BranchMapper;
import com.g.pos_software.models.Branch;
import com.g.pos_software.models.Store;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.BranchDto;
import com.g.pos_software.repository.BranchRepository;
import com.g.pos_software.repository.StoreRepository;
import com.g.pos_software.repository.UserRepository;
import com.g.pos_software.service.BranchService;
import com.g.pos_software.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl  implements BranchService {

    private  final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private  final UserService userService;

    @Override
    public BranchDto createBranch(BranchDto branchDto) throws UserException {
        User currentUser=userService.getUserById(branchDto.getManagerId());
        boolean isManager=currentUser.getRole().equals(UserRole.ROLE_STORE_MANAGER);
        if(!isManager){
            throw new UserException("Manager with this"+ branchDto.getManagerId() +"id doesn't exist");
        }
        Store store=storeRepository.findByStoreAdminId(currentUser.getId());
        Branch branch= BranchMapper.toEntity(branchDto,store,currentUser);
        Branch savedBranch=branchRepository.save(branch);
        return BranchMapper.toDto(savedBranch);
    }

    @Override
    public BranchDto updateBranch(Long id, BranchDto branchDto) throws Exception {
        Branch existing=branchRepository.findById(id).orElseThrow(() -> new Exception("Branch not found"));
        existing.setName(branchDto.getName());
        existing.setAddress(branchDto.getAddress());
        existing.setPhone(branchDto.getPhone());
        existing.setEmail(branchDto.getEmail());
        existing.setWorkingDays(branchDto.getWorkingDays());
        existing.setOpenTime(branchDto.getOpenTime());
        existing.setCloseTime(branchDto.getCloseTime());
        existing.setUpdatedAt(branchDto.getUpdatedAt());
       Branch branch= branchRepository.save(existing);

        return BranchMapper.toDto(branch);
    }

    @Override
    public void deleteBranch(Long id) throws Exception {
        Branch existing=branchRepository.findById(id).orElseThrow(() -> new Exception("Branch not found"));
    branchRepository.delete(existing);

    }

    @Override
    public List<BranchDto> getAllBranchesByStoreId(Long storeId) {
        List<Branch> branches=branchRepository.findByStoreId(storeId);
        return branches.stream().map(BranchMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public BranchDto getBranchById(Long id) throws Exception {
        Branch existing=branchRepository.findById(id).orElseThrow(() -> new Exception("Branch not found"));
        return BranchMapper.toDto(existing);
    }
}
