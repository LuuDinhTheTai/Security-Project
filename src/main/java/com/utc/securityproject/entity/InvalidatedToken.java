package com.utc.securityproject.entity;

import java.util.Date;

import com.utc.securityproject.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class InvalidatedToken extends BaseEntity {
  
  Date expiryTime;
}
