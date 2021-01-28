package com.leaptechstudio.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.leaptechstudio.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		String author="Abidullah Khan";
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage msg = new ErrorMessage(new Date(), errorMessageDescription, author );
		return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		String author="Abidullah Khan";
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage msg = new ErrorMessage(new Date(), errorMessageDescription, author );
		return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
