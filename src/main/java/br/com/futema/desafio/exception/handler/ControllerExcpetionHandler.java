package br.com.futema.desafio.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.futema.desafio.exception.BusinessException;
import br.com.futema.desafio.view.ResponseView;

@ControllerAdvice
public class ControllerExcpetionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ResponseView> objectNotFound(BusinessException e, HttpServletRequest request) {
		
		ResponseView error = new ResponseView(e.getCode(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
}