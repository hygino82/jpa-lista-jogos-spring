package com.game.list.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//marca a classe como uma entidade
@Table(name = "tb_games")//marca a tabela tb_games para guardar elementos desta classe
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//faz o id ser gerado automaticamente
	private Long id;//id tipo Long
	
	private String name;
	private Integer maxPlayers;
	private String gameId;
	
	public Game() {		
	}

	public Game(Long id, String name, Integer maxPlayers, String gameId) {
		super();
		this.id = id;
		this.name = name;
		this.maxPlayers = maxPlayers;
		this.gameId = gameId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Integer getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
}
