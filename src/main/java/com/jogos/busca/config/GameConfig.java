package com.jogos.busca.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jogos.busca.entities.Game;
import com.jogos.busca.repositories.GameRepository;

@Configuration
public class GameConfig {
	@Bean
	CommandLineRunner commandLineRunner(GameRepository gameRepository) {
		return args -> {
			Game ds1 = new Game("Dark Souls", "PS3", "101");

			Game ds2 = new Game("Dark Souls 2", "PS3", "102");

			gameRepository.saveAll(List.of(ds1, ds2));
		};
	}
}
