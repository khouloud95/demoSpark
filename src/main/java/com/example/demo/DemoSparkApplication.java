package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entities.Contact;

@SpringBootApplication
//@EntityScan("com.exemple.demo.entities.*")
//@EnableJpaRepositories("com.exemple.demo.dao.*")

public class DemoSparkApplication implements CommandLineRunner {
	@Autowired

	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSparkApplication.class, args);
	}

	@Override

	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		contactRepository.save(new Contact("Khouloud", "Bouchaala", df.parse("02/09/1995"),
				"khouloud.bouchaala@spark-it.tn", 44189749, "khouloud.jpeg"));
		contactRepository.save(new Contact("Rahma", "FakhFakh", df.parse("26/06/1995"), "rahma.fakhfakh@spark-it.tn",
				22222222, "rahma.jpeg"));
		contactRepository.save(new Contact("Nesrin", "Thabet", df.parse("04/05/1996"), "Nesrin.Thabet@spark-it.tn",
				22222222, "nesrin.jpeg"));
		contactRepository.findAll().forEach(c -> {
			System.out.println(c.getNom());
		});

	}

}
