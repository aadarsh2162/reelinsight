package com.reelinsight.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponseDto {

    private  Integer userId;
    private String name;


    private String username;


    private String email;


  private  String membership;
    private String mobile;

}
