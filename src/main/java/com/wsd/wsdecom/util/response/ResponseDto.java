package com.wsd.wsdecom.util.response;

import lombok.*;

@Data
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private int code;
    private String message;
    private T data;
    private String error;
    private boolean success;
}
