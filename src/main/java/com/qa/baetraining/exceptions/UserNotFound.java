package com.qa.baetraining.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No user exists with that ID")
public class UserNotFound extends EntityNotFoundException {
	
}
