package com.utc.securityproject.dto.response;

import com.utc.securityproject.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountDTO extends BaseEntity {
  private Long id;
  private String createdBy;
  private LocalDateTime createdAt;
  private String lasUpdatedBy;
  private LocalDateTime lastUpdatedAt;
  private String email;
  private String password;
  
  private String roles;
  
}
