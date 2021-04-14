package com.game.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListaJogosApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ListaJogosApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
