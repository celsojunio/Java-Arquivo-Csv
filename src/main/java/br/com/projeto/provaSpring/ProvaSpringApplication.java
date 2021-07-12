package br.com.projeto.provaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProvaSpringApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProvaSpringApplication.class, args);//Spring inicia e termina
	}
}
