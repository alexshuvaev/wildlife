package com.alexshuvaev.wildlife.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorInfo {
    private final String url;
    private final String detail;
}