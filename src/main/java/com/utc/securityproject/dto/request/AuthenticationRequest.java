package com.utc.securityproject.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequest {
  
  private String email;
  private String password;
}
