package org.example.yoyager_backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String name;
  private String birthdate;
  private String travel_style;

  @Column(columnDefinition = "TEXT")
  private String profile_image;


  @Builder
  public UserEntity(String email, String password, String name, String birthdate, String travel_style, String profile_image) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.birthdate = birthdate;
    this.travel_style = travel_style;
    this.profile_image = profile_image;
  }
}
