package mx.com.lickodev.stocktaking.commons.advice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mx.com.lickodev.stocktaking.commons.exceptions.ProductNotFoundException;
import mx.com.lickodev.stocktaking.commons.exceptions.UserNotFoundException;

/**
 * 
 * @author saul_
 * 
 *         refs:
 * 
 *         -https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f
 * 
 *         -https://github.com/jovannypcg/exception_handler
 * 
 *         -https://zetcode.com/springboot/controlleradvice/
 */
@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * Este permite capturar las excepciones que se generan al utilizar la
	 * anotación @Valid de Java para validación de objetos con ayuda del controller
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();

		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());

		body.put("errors", errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	/**
	 * Eset captura las excepciones que se marcan en el valor del @ExceptionHandler
	 * y te permite manipularlas para darles formato o algo antes de enviarlas a
	 * quien solicitó la petición, de esta forma puedes dar una mejor presentación a
	 * los mensajes de error.
	 * 
	 * @param ex      excepcion generica qeu captura todas las excepciones que
	 *                extiendan de ella
	 * @param request el request de la solicitud
	 * @return un objeto que contiene los errores conformato e información adicional
	 *         para el solicitante
	 */
	@ExceptionHandler({ UserNotFoundException.class, ProductNotFoundException.class })
	public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);

	}

}
