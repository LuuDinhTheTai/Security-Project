package com.utc.securityproject.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
  
  ENTITY_NOT_FOUND(404, "Account not found", HttpStatus.NOT_FOUND),
  INVALID_EMAIL(400, "Uncategorized error", HttpStatus.BAD_REQUEST),
  INVALID_PARAM(400, "Invalid param", HttpStatus.BAD_REQUEST),
  USER_NOT_EXISTED(404, "User not exists", HttpStatus.NOT_FOUND),
  UNAUTHENTICATED(400, "Unauthenticated", HttpStatus.BAD_REQUEST),
  ;
  
  ErrorCode(int code, String message, HttpStatusCode statusCode) {
    this.code = code;
    this.message = message;
    this.statusCode = statusCode;
  }
  
  private final int code;
  private final String message;
  private final HttpStatusCode statusCode;
}