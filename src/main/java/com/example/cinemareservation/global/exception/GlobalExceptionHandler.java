package com.example.cinemareservation.global.exception;

import com.example.cinemareservation.global.exception.ErrorResponse.ValidationError;
import java.util.List;
import lombok.NonNull;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = {"com.example.cinemareservation.domain"})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		ErrorCase errorCase = ErrorCase.RESOURCE_NOT_FOUND;
		ErrorResponse errorResponse = ErrorResponse.builder()
			.code(errorCase.getCode())
			.message(errorCase.getMessage())
			.build();
		return ResponseEntity.status(errorCase.getHttpStatus())
			.body(errorResponse);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e) {
		ErrorCase errorCase = ErrorCase.INVALID_INPUT;
		ErrorResponse errorResponse = ErrorResponse.builder()
			.code(errorCase.getCode())
			.message(errorCase.getMessage())
			.build();
		return ResponseEntity.status(errorCase.getHttpStatus())
			.body(errorResponse);
	}

	@Override
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		@NonNull MethodArgumentNotValidException ex,
		@NonNull HttpHeaders headers,
		@NonNull HttpStatusCode status,
		@NonNull WebRequest request
	) {
		ErrorCase errorCase = ErrorCase.INVALID_INPUT;
		return handleExceptionInternal(ex, errorCase);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(
		ConstraintViolationException ex,
		HttpHeaders headers,
		HttpStatusCode status,
		WebRequest request
	) {
		ErrorCase errorCase = ErrorCase.INVALID_INPUT;
		return handleExceptionInternal(ex, errorCase);
	}

	private ResponseEntity<Object> handleExceptionInternal(BindException e, ErrorCase errorCase) {
		return ResponseEntity.status(errorCase.getHttpStatus())
			.body(makeErrorResponse(e, errorCase));
	}

	private ResponseEntity<Object> handleExceptionInternal(ConstraintViolationException e, ErrorCase errorCase) {
		return ResponseEntity.status(errorCase.getHttpStatus())
			.body(makeErrorResponse(e, errorCase));
	}

	private ErrorResponse makeErrorResponse(BindException e, ErrorCase errorCase) {
		List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(ErrorResponse.ValidationError::of)
			.toList();

		return ErrorResponse.builder()
			.code(errorCase.getCode())
			.message(errorCase.getMessage())
			.errors(validationErrorList)
			.build();
	}

	private ErrorResponse makeErrorResponse(ConstraintViolationException e, ErrorCase errorCase) {
		List<ValidationError> validationErrors = List.of(ValidationError.builder()
			.field(e.getConstraintName())
			.build());
		return ErrorResponse.builder()
			.code(errorCase.getCode())
			.message(errorCase.getMessage())
			.errors(validationErrors)
			.build();
	}
}
