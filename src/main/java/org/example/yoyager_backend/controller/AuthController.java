package org.example.yoyager_backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.yoyager_backend.controller.Request.LoginRequest;
import org.example.yoyager_backend.controller.Request.RegisterRequest;
import org.example.yoyager_backend.controller.Response.LoginResponse;
import org.example.yoyager_backend.controller.Response.RegisterResponse;
import org.example.yoyager_backend.service.LoginService;
import org.example.yoyager_backend.service.SignUpService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final SignUpService signUpService;
  private final LoginService loginService;
  @PostMapping("/signup")
  public RegisterResponse signUp(@RequestBody RegisterRequest request) {
    return signUpService.signUp(request);
  }
  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest request) {
    return loginService.login(request);
  }
}
