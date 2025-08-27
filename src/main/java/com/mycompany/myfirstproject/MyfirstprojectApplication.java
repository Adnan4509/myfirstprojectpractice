package com.mycompany.myfirstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class MyfirstprojectApplication {

	public static void main(String[] args) {
        System.out.println("Hello World");
		SpringApplication.run(MyfirstprojectApplication.class, args);

	}

}
