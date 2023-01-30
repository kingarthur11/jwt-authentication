package com.haggixago.haggixagoapi.controller;

import com.haggixago.haggixagoapi.config.JwtUtil;
import com.haggixago.haggixagoapi.dto.LoginDTO;
import com.haggixago.haggixagoapi.dto.LoginResponsDTO;
import com.haggixago.haggixagoapi.dto.ServiceResponseDTO;
import com.haggixago.haggixagoapi.model.UserAuth;
import com.haggixago.haggixagoapi.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class UserAuthController {
    @Autowired
    UserAuthService userAuthService;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<ServiceResponseDTO> registerUser(@RequestBody UserAuth userAuth) {
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();

        UserAuth response = userAuthService.saveUser(userAuth);

        serviceResponseDTO.setStatus("200");
        serviceResponseDTO.setDescription("User token retrieved");
        serviceResponseDTO.setData(response);
        serviceResponseDTO.setTimestamp(new Date());

        return new ResponseEntity<>(serviceResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ServiceResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        UserAuth userAuth = userAuthService.getUserAuthByEmail(loginDTO.getEmail());
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
        authenticationManager.authenticate(token);
        String generateJWTToken = jwtUtil.generate(loginDTO.getEmail());

        LoginResponsDTO loginResponsDTO = new LoginResponsDTO();
        loginResponsDTO.setUserAuth(userAuth);
        loginResponsDTO.setToken(generateJWTToken);

        serviceResponseDTO.setStatus("200");
        serviceResponseDTO.setDescription("User token retrieved");
        serviceResponseDTO.setData(loginResponsDTO);
        serviceResponseDTO.setTimestamp(new Date());

        return new ResponseEntity<>(serviceResponseDTO, HttpStatus.OK);
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello world");
    }
}
