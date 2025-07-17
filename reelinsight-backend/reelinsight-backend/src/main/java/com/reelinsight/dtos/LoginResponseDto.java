package com.reelinsight.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponseDto {
    private String name;
    private String username;
    private String email;
    private String token;
    private String tokenType = "Bearer";
    private String membershipType;
}
