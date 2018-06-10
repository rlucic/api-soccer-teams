package com.ro.soccer.teams.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ro.soccer.teams.model.Player;

@RestResource(path="players", rel="thePlayers")
public interface PlayerDAO	extends CrudRepository<Player, Long>{
		
}