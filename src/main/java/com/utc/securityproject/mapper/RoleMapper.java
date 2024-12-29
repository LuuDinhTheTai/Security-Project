package com.utc.securityproject.mapper;

import com.utc.securityproject.dto.request.RoleRequest;
import com.utc.securityproject.dto.response.RoleResponse;
import com.utc.securityproject.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
  @Mapping(target = "permissions", ignore = true)
  Role toRole(RoleRequest request);
  
  RoleResponse toRoleResponse(Role role);
}

