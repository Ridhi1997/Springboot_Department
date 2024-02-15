package com.example.demo.Controller;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
    @GetMapping("/")
	public String helloworld() {
		return welcomeMessage ;
		
	}
 
}
