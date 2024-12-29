package com.utc.securityproject.mapper;

import com.utc.securityproject.dto.request.PermissionRequest;
import com.utc.securityproject.dto.response.PermissionResponse;
import com.utc.securityproject.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
  Permission toPermission(PermissionRequest request);
  
  PermissionResponse toPermissionResponse(Permission permission);
}

