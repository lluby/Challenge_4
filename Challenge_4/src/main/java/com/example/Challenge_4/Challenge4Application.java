package com.example.Challenge_4;

import com.example.Challenge_4.Controller.BinarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;

@SpringBootApplication
public class Challenge4Application {

	@Autowired
	static BinarController binarController;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(Challenge4Application.class, args);
		binarController.Menu();
	}

}
