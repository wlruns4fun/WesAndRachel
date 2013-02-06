package com.wesandrachel.model.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Entity
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Table(name="FOOSBALL_PLAYERS")
@MappedSuperclass
public abstract class Player implements Serializable {

	private int playerId;
	private String lastName;
	private String firstName;
	
	@Id
	@GeneratedValue
	@Column(name="PLAYER_ID", nullable=false)
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	@Column(name="LAST_NAME", nullable=false)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="FIRST_NAME", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
