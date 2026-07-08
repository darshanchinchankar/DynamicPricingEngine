package com.dynamicpricing.util;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {

    private String message;
    private Integer status;
    private LocalDateTime timestamp;

}