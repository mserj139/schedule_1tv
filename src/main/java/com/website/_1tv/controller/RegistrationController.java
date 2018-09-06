package com.website._1tv.controller;

import com.website._1tv.repository1.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.website._1tv.domain.User;

import java.util.Map;


@Controller
public class RegistrationController {

  @Autowired
  private UserRepo userRepo;

  @GetMapping("/registration")
  public String registration(){
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Map<String, Object> model){
    User userFromDb = userRepo.findByUsername(user.getUsername());

    if (userFromDb != null){
      model.put("message", "User exists!");
      return "registration";
    }

    return "redirect:/login";
  }
}
