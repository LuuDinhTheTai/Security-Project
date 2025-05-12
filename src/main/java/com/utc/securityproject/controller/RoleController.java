package com.utc.securityproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.utc.securityproject.dto.request.RoleRequest;
import com.utc.securityproject.dto.response.ApiResponse;
import com.utc.securityproject.dto.response.RoleResponse;
import com.utc.securityproject.entity.Role;
import com.utc.securityproject.mapper.RoleMapper;
import com.utc.securityproject.service.RoleService;
import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
  
  RoleService roleService;
  RoleMapper roleMapper;
  
  @PostMapping
  ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
    Role role = roleMapper.toRole(request);
    return ApiResponse.<RoleResponse>builder()
                   .result(roleMapper.toRoleResponse(roleService.create(role)))
                   .build();
  }
  
  @GetMapping
  ApiResponse<List<RoleResponse>> list() {
    return ApiResponse.<List<RoleResponse>>builder()
                   .result(roleService.list()
                                   .stream()
                                   .map(role -> roleMapper.toRoleResponse(role))
                                   .collect(Collectors.toList()))
                   .build();
  }
  
  @DeleteMapping("/{role}")
  ApiResponse<Void> delete(@PathVariable String role) {
    roleService.delete(role);
    return ApiResponse.<Void>builder().build();
  }
}

