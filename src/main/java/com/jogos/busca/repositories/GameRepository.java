package com.jogos.busca.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jogos.busca.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	@Query("SELECT obj FROM Game obj WHERE obj.personalCode = ?1")
	Optional<Game> findGameByPersonalcode(String personalCode);

	@Query("SELECT obj FROM Game obj WHERE obj.console = ?1")
	List<Optional<Game>> findAllGamesByConsole(String console);

}
