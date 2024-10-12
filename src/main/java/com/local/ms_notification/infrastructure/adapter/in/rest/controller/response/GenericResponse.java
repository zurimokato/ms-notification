package com.local.ms_notification.infrastructure.adapter.in.rest.controller.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {

    private String message;
    private String code;
    private Object data;
    private HttpStatus httpStatus;
    private PageResponse pageResponse;

    public static GenericResponse success() {
        return GenericResponse.builder()
                .code("200")
                .message("OK")
                .httpStatus(HttpStatus.OK)
                .build();
    }

}
