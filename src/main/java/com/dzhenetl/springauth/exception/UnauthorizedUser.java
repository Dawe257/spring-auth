package com.dzhenetl.springauth.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedUser extends RuntimeException {

    Logger logger = LoggerFactory.getLogger(UnauthorizedUser.class);

    public UnauthorizedUser(String msg) {
        super(msg);
        logger.warn(msg);
    }
}
