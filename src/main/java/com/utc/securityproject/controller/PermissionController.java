package com.utc.securityproject.controller;

import java.util.List;

import com.utc.securityproject.dto.request.PermissionRequest;
import com.utc.securityproject.dto.response.ApiResponse;
import com.utc.securityproject.dto.response.PermissionResponse;
import com.utc.securityproject.service.impl.PermissionService;
import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
  
  PermissionService permissionService;
  
  @PostMapping
  ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request) {
    return ApiResponse.<PermissionResponse>builder()
                   .result(permissionService.create(request))
                   .build();
  }
  
  @GetMapping
  ApiResponse<List<PermissionResponse>> getAll() {
    return ApiResponse.<List<PermissionResponse>>builder()
                   .result(permissionService.getAll())
                   .build();
  }
  
  @DeleteMapping("/{permission}")
  ApiResponse<Void> delete(@PathVariable String permission) {
    permissionService.delete(permission);
    return ApiResponse.<Void>builder().build();
  }
}

