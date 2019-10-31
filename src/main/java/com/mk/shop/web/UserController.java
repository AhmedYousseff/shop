package com.mk.shop.web;

import com.mk.shop.domain.User;

import com.mk.shop.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class UserController {
  private static final String ENTITY_NAME = "User";

  private final UserRepository userRepository;

  private Logger log = LoggerFactory.getLogger(UserRepository.class);

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("users")
  public ResponseEntity<User> createItem(@RequestBody User user) throws Exception {
    if (user.getId() != null) throw new Exception();
    User result = userRepository.save(user);
    return ResponseEntity.created(new URI("/api/items" + result.getId())).body(result);
  }

  @GetMapping("users")
  public ResponseEntity<List<User>> getItem() throws Exception {
    System.out.println("request received ");
    List<User> result = userRepository.findAll();
    return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
  }}
