package com.iarcos.b2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {
		@Server(url = "http://localhost:8080/", description = "Desarrollo local") }, 
info = @Info(description = "Examen 2 Brains", title = "Exam 2B", version = "0.0.1"))
@SpringBootApplication
public class ExamApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}
}
