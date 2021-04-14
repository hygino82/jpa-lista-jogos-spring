package com.game.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.list.entities.Game;
import com.game.list.repositories.GameRepository;


@RestController//marca classe como RestController
@RequestMapping(value = "/games")//controlador disponível em /users
public class GameController {
	@Autowired
	private GameRepository repository;//insere GameRepository(impementação jpa)
	
	@GetMapping//retorna a lita de todos os usuários 
	public ResponseEntity<List<Game>> findAll() {
		List<Game> result = repository.findAll();
		return ResponseEntity.ok(result);
	}
	//retorna a lita de todos os usuários de forma paginada
	@GetMapping(value = "/page")//se usa Page ao invés de List com argumento Pageable 
	public ResponseEntity<Page<Game>> findAll(Pageable pageable) {
	    Page<Game> result = repository.findAll(pageable);
	    return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<Game>> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable) {
	    Page<Game> result = repository.findByNameContainingIgnoreCase(name, pageable);
	    return ResponseEntity.ok(result);
	}
}
