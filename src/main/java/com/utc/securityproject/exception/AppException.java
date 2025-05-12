package com.utc.securityproject.exception;

import lombok.Data;

@Data
public class AppException extends RuntimeException {
  
  private ErrorCode errorCode;
  
  public AppException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
