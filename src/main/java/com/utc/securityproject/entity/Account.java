package com.utc.securityproject.entity;

import com.utc.securityproject.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
  
  @Column(unique = true)
//  @ValidateEmail
  private String email;
  @Column(nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @ManyToMany
  private Set<Role> roles;
}