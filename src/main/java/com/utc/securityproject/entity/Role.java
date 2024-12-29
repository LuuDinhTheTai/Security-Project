package com.utc.securityproject.entity;

import java.util.Set;

import com.utc.securityproject.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Role extends BaseEntity {
  String name;
  
  String description;
  
  @ManyToMany
  Set<Permission> permissions;
}

