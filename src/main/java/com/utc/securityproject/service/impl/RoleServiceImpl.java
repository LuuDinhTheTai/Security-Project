package com.utc.securityproject.service.impl;

import com.utc.securityproject.entity.Role;
import com.utc.securityproject.repository.RoleRepository;
import com.utc.securityproject.repository.base.BaseRepository;
import com.utc.securityproject.service.RoleService;
import com.utc.securityproject.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
  
  public RoleServiceImpl(RoleRepository repository) {
    super(repository);
  }
}
