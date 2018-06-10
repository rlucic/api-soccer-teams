package com.ro.soccer.teams.dao;

import org.springframework.data.repository.CrudRepository;
import com.ro.soccer.teams.model.Player;

public interface PlayerDAO extends CrudRepository<Player, Long>{

}
