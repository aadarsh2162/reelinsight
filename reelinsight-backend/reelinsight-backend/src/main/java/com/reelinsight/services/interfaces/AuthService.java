package com.reelinsight.services.interfaces;

import com.reelinsight.dtos.LoginRequestDto;
import com.reelinsight.dtos.LoginResponseDto;
import com.reelinsight.dtos.SignupRequestDto;
import com.reelinsight.dtos.SignupResponseDto;

public interface AuthService {

    SignupResponseDto saveUser(SignupRequestDto signupRequestDto);

    LoginResponseDto loginUser(LoginRequestDto loginRequestDto);


    SignupResponseDto getUserById(Integer userId);
}
