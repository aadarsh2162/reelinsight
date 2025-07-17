package com.reelinsight.controllers;

import com.reelinsight.dtos.LoginRequestDto;
import com.reelinsight.dtos.LoginResponseDto;
import com.reelinsight.dtos.SignupRequestDto;
import com.reelinsight.dtos.SignupResponseDto;
import com.reelinsight.services.implclasses.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174", "http://localhost:3000", "http://localhost:8080"})
public class AuthController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> saveUser(@RequestBody SignupRequestDto requestDto){
        return ResponseEntity.ok(authService.saveUser(requestDto));
    }

    @GetMapping("users/{id}")
    public  ResponseEntity<SignupResponseDto> getUser(@PathVariable Integer id){
        return  ResponseEntity.ok(authService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.loginUser(loginRequestDto));
    }

}
