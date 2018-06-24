package com.ro.soccer.teams.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ro.soccer.teams.model.Player;

@Repository
public interface PlayerDAO extends CrudRepository<Player, Long>{

}
