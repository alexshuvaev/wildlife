package com.alexshuvaev.wildlife.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionInfoHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ErrorInfo notFound(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ErrorInfo nullEntity(HttpServletRequest req, NullPointerException e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo handleError(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getLocalizedMessage());
    }
}