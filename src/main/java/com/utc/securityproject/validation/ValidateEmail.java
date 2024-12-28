package com.utc.securityproject.validation;


import com.hina.socialmedia.exception.AppException;
import com.hina.socialmedia.exception.ErrorCode;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Constraint(validatedBy = ValidateEmail.EmailValidation.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
public @interface ValidateEmail {
  String message() default "Invalid email";
  
  Class<?>[] groups() default {};
  
  Class<? extends Payload>[] payload() default {};
  
  class EmailValidation implements ConstraintValidator<ValidateEmail, String> {
    
    @Override
    public void initialize(ValidateEmail constraintAnnotation) {}
    
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
      String regexEmail =
              "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
      if (!email.matches(regexEmail)) {
        throw new AppException(ErrorCode.INVALID_EMAIL);
      }
      return true;
    }
  }
}
