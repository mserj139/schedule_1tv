package com.website._1tv;

import com.website._1tv.domain.Message;
import com.website._1tv.repository1.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

  @Autowired
  private MyRepository repo;

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name="name", required=false, defaultValue="гость!") String name, Map<String, Object> model) {
    model.put("name", name);
    return "greeting";
  }

  @GetMapping
  public String index(Map<String, Object> model){
    Iterable<Message> messages = repo.findAll();
    model.put("messages", messages);
    return "index";
  }

  @PostMapping
  public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
    Message message = new Message(text, tag);

    repo.save(message);
    Iterable<Message> messages = repo.findAll();
    model.put("messages", messages);

    return "index";
  }
}