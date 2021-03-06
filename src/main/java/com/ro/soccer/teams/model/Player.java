package com.ro.soccer.teams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

@ApiModel(
		description="Model POJO describing a soccer player. Persisted in the 'player' table.",
		value="Player")
@XmlRootElement
@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	String position;
	
	public Player(){
		super();
	}
	
	public Player(String name, String position) {
		this();
		this.name = name;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
