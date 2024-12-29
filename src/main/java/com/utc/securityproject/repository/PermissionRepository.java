package com.utc.securityproject.repository;

import com.utc.securityproject.entity.Permission;
import com.utc.securityproject.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends BaseRepository<Permission> {
}
