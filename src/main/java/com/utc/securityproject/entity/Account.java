package com.utc.securityproject.entity;

import com.utc.securityproject.constants.Constant;
import com.utc.securityproject.entity.base.BaseEntity;
import com.utc.securityproject.validation.ValidateEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
  @Column(unique = true)
  @ValidateEmail
  private String email;
  @Column(nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  
  @ManyToMany
  Set<Role> roles;
}