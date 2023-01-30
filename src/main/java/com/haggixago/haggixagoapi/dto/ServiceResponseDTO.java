package com.haggixago.haggixagoapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ServiceResponseDTO {
    private String status;
    private String description;
    private Object data;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd HH:SS:MM")
    private Date timestamp;
}
