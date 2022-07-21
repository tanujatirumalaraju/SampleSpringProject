package com.example.demosprings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentationDemo {
@GetMapping("/")
public void Getdata()
{
	System.out.println("hii");
}
}
