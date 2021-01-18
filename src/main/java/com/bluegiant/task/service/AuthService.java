package com.bluegiant.task.service;

import com.bluegiant.task.dto.LoginRequestDto;
import com.bluegiant.task.dto.SignupRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthService {

    String doSignup(@RequestBody @Valid SignupRequestDto signUpRequest);

    String doSignin(@RequestBody @Valid LoginRequestDto loginRequest);
}
