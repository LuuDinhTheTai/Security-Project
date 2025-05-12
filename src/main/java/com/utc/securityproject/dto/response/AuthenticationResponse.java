package com.utc.securityproject.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
  
  private String token;
  private boolean authenticated;
}

