package com.ro.soccer.teams.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

@ApiModel(
		description="Model POJO describing a soccer team. Persisted in the 'team' table.",
		value="Team")
@XmlRootElement
@Entity
@Table(name="team")
public class Team {

	@Id
	@GeneratedValue
	Long id;
	String name;
	String location;
	String mascotte;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="teamId")
	Set<Player> players;
	

	public Team(){
		super();
	}
	
	public Team(String location, String name, Set<Player> players) {
		this();
		this.location = location;
		this.name = name;
		this.players = players;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMascotte() {
		return mascotte;
	}
	public void setMascotte(String mascote) {
		this.mascotte = mascote;
	}


	public Set<Player> getPlayers() {
		return players;
	}


	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	
	
}
