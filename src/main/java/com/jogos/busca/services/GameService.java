package com.jogos.busca.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jogos.busca.entities.Game;
import com.jogos.busca.repositories.GameRepository;

@Service
public class GameService {
	private final GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public List<Game> getGames() {
		return gameRepository.findAll();
	}

	public void addNewGame(Game game) {
		Optional<Game> gameOptional = gameRepository.findGameByPersonalcode(game.getPersonalCode());
		if (gameOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		gameRepository.save(game);
	}

	public void deleteGame(Long gameId) {
		boolean exists = gameRepository.existsById(gameId);
		if (!exists) {
			throw new IllegalStateException("Game with id " + gameId + " does not exists");
		}
		gameRepository.deleteById(gameId);
	}

	@Transactional
	public void updateGame(Long gameId, String name, String personalCode) {
		Game game = gameRepository.findById(gameId)
				.orElseThrow(() -> new IllegalStateException("Student id " + gameId + " does not exists"));

		if (name != null && name.length() > 0 && !Objects.equals(game.getName(), name)) {
			game.setName(name);
		}
		
		if (personalCode != null && personalCode.length() > 0 && !Objects.equals(game.getPersonalCode(), personalCode)) {
			game.setPersonalCode(personalCode);
		}
		
	}

	public List<Optional<Game>> findAllGamesByConsole(String console) {
		return gameRepository.findAllGamesByConsole(console);	
	}

}
