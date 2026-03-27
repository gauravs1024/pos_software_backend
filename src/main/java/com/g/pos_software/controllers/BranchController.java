package com.g.pos_software.controllers;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.mapper.BranchMapper;
import com.g.pos_software.models.Branch;
import com.g.pos_software.payload.dto.BranchDto;
import com.g.pos_software.payload.response.ApiResponse;
import com.g.pos_software.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branches")
public class BranchController {
    private  final BranchService branchService;

    @PostMapping
    public ResponseEntity<BranchDto>createBranch(@RequestBody BranchDto branchDto) throws Exception {
        BranchDto createdBranch=branchService.createBranch(branchDto);
      return  ResponseEntity.ok(createdBranch);
    }



    @GetMapping("/{id}")
    public  ResponseEntity<BranchDto>getBranchById(
            @PathVariable Long id
    ) throws Exception {
        BranchDto createBranch=branchService.getBranchById(id);

    return  ResponseEntity.ok(createBranch);
    }


    @GetMapping("/store/{storeId}")
    public  ResponseEntity<List<BranchDto>>getAllBranchesByStoreId(
            @PathVariable Long storeId
    )  {
        List<BranchDto>branches=branchService.getAllBranchesByStoreId(storeId);
        return  ResponseEntity.ok(branches);
    }

    @PutMapping("{id}")
    public  ResponseEntity<BranchDto>updateBranch(
            @PathVariable Long id,
            @RequestBody BranchDto branchDto
    ) throws Exception {
        BranchDto updatedBranch=branchService.updateBranch(id,branchDto);
        return  ResponseEntity.ok(updatedBranch);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse>deleteBranch(
                @PathVariable Long id
                ) throws Exception {
        branchService.deleteBranch(id);
        ApiResponse apiResponse=new ApiResponse<>();
        apiResponse.setMessage("Branch deleted successfully");
        return ResponseEntity.ok(apiResponse);
    }


}
