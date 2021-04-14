package com.game.list.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.game.list.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	@Query("SELECT obj FROM Game obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<Game> searchByName(String name, Pageable pageable);
	
	Page<Game> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
