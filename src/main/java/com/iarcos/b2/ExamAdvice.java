package com.iarcos.b2;

import static com.iarcos.b2.util.Constantes.EMPTY;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.iarcos.b2.domain.MssgResp;
import com.iarcos.b2.expo.ExamExpo;

@RestControllerAdvice
public class ExamAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExamAdvice.class);

	@ExceptionHandler(ExamExpo.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MssgResp handleGlobalException(Exception ex, WebRequest request) {
		final StringBuilder cadena = new StringBuilder("ERROR EN SERVICIO ")
				.append(ex.getMessage()).append(request.getDescription(true));
		
		LOGGER.error("::::::::::::::::::::::::::::");
		LOGGER.error(cadena.toString());
		LOGGER.error("::::::::::::::::::::::::::::");

		return new MssgResp(500, new Date(), EMPTY, "Error en Servicio Interno");
	}

	
}
