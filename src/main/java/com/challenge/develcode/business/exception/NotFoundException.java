package com.challenge.develcode.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Registro não encontrado")
public class NotFoundException extends Exception {

}