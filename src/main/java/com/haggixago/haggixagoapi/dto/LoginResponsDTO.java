package com.haggixago.haggixagoapi.dto;

import com.haggixago.haggixagoapi.model.UserAuth;
import lombok.Data;

@Data
public class LoginResponsDTO {
    private UserAuth userAuth;
    private String token;
}
