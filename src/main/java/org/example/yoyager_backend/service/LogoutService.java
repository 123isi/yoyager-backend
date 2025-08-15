package org.example.yoyager_backend.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.yoyager_backend.repository.TokenRepository;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LogoutService {
  private final TokenRepository tokenRepository;
  public void logout(String accessToken) {

  }
}
