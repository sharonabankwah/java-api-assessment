package com.moodcha.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // Handles recipe not found exceptions
  @ExceptionHandler(RecipeNotFoundException.class)
  public ResponseEntity<String> handleNotFound(RecipeNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  // Handles type mismatch errors
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException exception) {
    String message = "Invalid value for parameter: " + exception.getName() + "'=" + exception.getValue();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }

  // Handles validation errors
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidation(MethodArgumentNotValidException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      .body("Validation error: " + exception.getBindingResult()
      .getFieldError().getDefaultMessage());
  }

  // Handles generic exceptions
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGeneric(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body("An unexpected error occurred: " + exception.getMessage());
  }

}
