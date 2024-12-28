package com.utc.securityproject.dto.request;

import com.hina.socialmedia.validation.ValidateEmail;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
  @NotEmpty
  @ValidateEmail
  private String email;
  
  private String password;
}
