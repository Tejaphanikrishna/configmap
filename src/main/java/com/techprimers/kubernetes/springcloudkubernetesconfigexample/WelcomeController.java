package com.techprimers.kubernetes.springcloudkubernetesconfigexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/welcome")
@RestController
public class WelcomeController {

    @Value("${message:Welcome to Configmap}")
    private String message;

    @GetMapping("/")
	public String welcome() {
		String prefix = System.getenv().getOrDefault("USERNAME", "Unknown");
		System.out.println(message);
		return "Hi " + prefix;
	}
}
