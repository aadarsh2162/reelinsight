package com.reelinsight.services.implclasses;

import com.reelinsight.dtos.LoginRequestDto;
import com.reelinsight.dtos.LoginResponseDto;
import com.reelinsight.dtos.SignupRequestDto;
import com.reelinsight.dtos.SignupResponseDto;
import com.reelinsight.exceptions.ResourceNotFoundException;
import com.reelinsight.models.User;
import com.reelinsight.repository.UserRepository;
import com.reelinsight.security.JwtUtil;
import com.reelinsight.services.interfaces.AuthService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

     @Autowired
     private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtService;

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public SignupResponseDto saveUser(SignupRequestDto signupRequestDto) {
        if (userRepository.existsByUsername(signupRequestDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Check if email exists
        if (userRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Check if mobile number exists
        if (userRepository.existsByMobile(signupRequestDto.getMobile())) {
            throw new RuntimeException("Mobile number already exists");
        }

           User user = User.builder()
                   .name(signupRequestDto.getName())
                   .email(signupRequestDto.getEmail())
                   .username(signupRequestDto.getUsername())
                   .mobile(signupRequestDto.getMobile())
                   .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                   .createdAt(LocalDateTime.now())
                   .membership(signupRequestDto.getMembership() != null ? signupRequestDto.getMembership() : "FREE")
                   .build();

           User saveduser = userRepository.save(user);

           return new SignupResponseDto(
                   saveduser.getId(),
                   saveduser.getName(),
                   saveduser.getUsername(),
                   saveduser.getEmail(),
                   saveduser.getMembership(),
                   saveduser.getMobile()

           );

    }


    @Override
    public SignupResponseDto getUserById(Integer userId) {
        User  user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User Not Found With Id : " + userId));


        return new SignupResponseDto(
               user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getMembership(),
                user.getMobile()
        );

    }

    @Override
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
        String identifier = loginRequestDto.getUsernameOrMobileOrEmail();

        // Authenticate credentials
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        identifier,
                        loginRequestDto.getPassword()
                )
        );

        // Load userDetails from DB
        UserDetails userDetails = userDetailsService.loadUserByUsername(identifier);

        // Generate token using userDetails
        String jwtToken = jwtService.generateToken(userDetails);

        // Get user from repository for membership and name
        User user = userRepository
                .findByUsernameOrEmailOrMobile(identifier, identifier, identifier)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return new LoginResponseDto(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                jwtToken,
                "Bearer ",
                user.getMembership()
        );
    }

}
