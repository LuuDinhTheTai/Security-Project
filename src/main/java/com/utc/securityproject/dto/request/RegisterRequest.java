package com.utc.securityproject.dto.request;

import com.utc.securityproject.exception.AppException;
import com.utc.securityproject.exception.ErrorCode;
import com.utc.securityproject.validation.ValidateEmail;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Data
@NoArgsConstructor
@Slf4j
public class RegisterRequest {
  
  @NotEmpty
  @ValidateEmail
  private String email;
  @NotEmpty
  private String username;
  @NotEmpty
  private String password;
  @NotEmpty
  private String confirmPassword;
  
  public void validate() {
    if (!Objects.equals(password, confirmPassword)) {
      log.error("(validate) password: {}, passwordConfirm: {} not equal", password, confirmPassword);
      throw new AppException(ErrorCode.INVALID_PARAM);
    }
  }
}
