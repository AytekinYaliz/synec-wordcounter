package com.synec.wordcounterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.synec.wordcounterservice", "com.synec.wordcounterlib" })
public class WordcounterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordcounterServiceApplication.class, args);
	}

}
