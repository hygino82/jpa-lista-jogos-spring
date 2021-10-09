package com.jogos.busca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.busca.entities.Game;
import com.jogos.busca.services.GameService;

@RestController
@RequestMapping(path = "jogos")
public class GameController {
	private final GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping(path = "todos")
	public List<Game> getStudents() {
		return gameService.getGames();
	}

	@PostMapping(path = "adicionar")
	public void registerNewGame(@RequestBody Game game) {
		gameService.addNewGame(game);
	}

	@DeleteMapping(path = "deletar/{gameId}")
	public void deleteGame(@PathVariable("gameId") Long gameId) {
		gameService.deleteGame(gameId);
	}

	@PutMapping(path = "alterar/{gameId}")
	public void updateGame(@PathVariable("gameId") Long gameId, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String personalCode) {
		gameService.updateGame(gameId, name, personalCode);
	}
	
	@GetMapping(path = "console/{console}")
	public List<Optional<Game>> findAllGamesByConsole(@PathVariable("console")String console) {
		return gameService.findAllGamesByConsole(console);
	}
}
