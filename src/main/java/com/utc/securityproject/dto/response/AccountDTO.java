package com.utc.securityproject.dto.response;

import com.utc.securityproject.entity.Role;
import com.utc.securityproject.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class AccountDTO extends BaseEntity {
  private String email;
  private String username;
  private String password;
}
