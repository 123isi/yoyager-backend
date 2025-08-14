package org.example.yoyager_backend.controller.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.yoyager_backend.domain.UserEntity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
  private Long id;
  private String email;
  private String name;

  public static RegisterResponse from(UserEntity user) {
    return new RegisterResponse(
            user.getId(),
            user.getEmail(),
            user.getName()
    );
  }
}
