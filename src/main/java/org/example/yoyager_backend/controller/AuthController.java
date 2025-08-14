package org.example.yoyager_backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.yoyager_backend.controller.Request.RegisterRequest;
import org.example.yoyager_backend.controller.Response.RegisterResponse;
import org.example.yoyager_backend.service.SignUpService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final SignUpService signUpService;

  @PostMapping("/signup")
  public RegisterResponse signUp(@RequestBody RegisterRequest request) {
    return signUpService.signUp(request);
  }
}
