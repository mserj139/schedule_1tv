package com.website._1tv.controller;

import com.website._1tv.domain.Message;
import com.website._1tv.repository1.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

  @Autowired
  private MessageRepo repo;

  @GetMapping("/")
  public String greeting(Map<String, Object> model) {

    return "greeting";
  }

  @GetMapping("/main")
  public String index(Map<String, Object> model){
    Iterable<Message> messages = repo.findAll();
    model.put("messages", messages);
    return "index";
  }

  @PostMapping("/index")
  public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
    Message message = new Message(text, tag);

    repo.save(message);
    Iterable<Message> messages = repo.findAll();
    model.put("messages", messages);

    return "index";
  }

  @PostMapping("filter")
  public String filter(@RequestParam String filter, Map<String, Object> model){
    Iterable<Message> messages;

    if (filter != null && !filter.isEmpty()){
      messages = repo.findByTag(filter);
    } else {
      messages = repo.findAll();
    }

    model.put("messages", messages);

    return "index";
  }
}