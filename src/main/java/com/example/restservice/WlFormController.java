package com.example.restservice;

import java.io.File;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WlFormController {

  @GetMapping("/json-endpoint")
  public String parsingDemo(@RequestParam(value = "name", defaultValue = "World") String name) {
    String rawJson = "";
    ObjectMapper mapper = new ObjectMapper();
    GenericFormNode genericFormNode = null;
    try {
      File resource = new ClassPathResource("form-template.json").getFile();
      rawJson = new String(Files.readAllBytes(resource.toPath()));
      genericFormNode = mapper.readValue(rawJson, GenericFormNode.class);
      System.out.println("node created: " + genericFormNode.toString());

    } catch(Exception e) {
      System.out.println("exception " + e.getMessage());
    }

    return genericFormNode.toString();
  }
}