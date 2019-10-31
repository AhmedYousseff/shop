package com.mk.shop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;



@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Email
  @Column(name = "EMAIL")
  @NonNull
  private String email;

  @Column(name = "PASSWORD")
  @NonNull
  private String password;

}
