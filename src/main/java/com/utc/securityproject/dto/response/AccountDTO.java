package com.utc.securityproject.dto.response;

import com.utc.securityproject.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO extends BaseEntity {
  
  private String email;
  private String username;
  private String password;
}
