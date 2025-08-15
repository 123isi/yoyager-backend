package org.example.yoyager_backend.service;

import lombok.RequiredArgsConstructor;
import org.example.yoyager_backend.controller.Request.LoginRequest;
import org.example.yoyager_backend.controller.Response.LoginResponse;
import org.example.yoyager_backend.domain.UserEntity;
import org.example.yoyager_backend.global.JwtProvider;
import org.example.yoyager_backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtProvider jwtProvider;

  public LoginResponse login(LoginRequest request) {
    UserEntity user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("이메일이 존재하지 않습니다."));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new RuntimeException("비밀번호가 일치하지 않습니다.");
    }

    String token = jwtProvider.generateToken(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getBirthdate()
    );
    return new LoginResponse(token);
  }
}
