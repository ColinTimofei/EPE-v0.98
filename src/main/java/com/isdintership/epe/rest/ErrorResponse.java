package com.isdintership.epe.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String title;
    private String details;
}
