package com.wesandrachel.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name="FOOSBALL_PLAYERS")
public class User {

	private int playerId;
	private String lastName;
	private String firstName;
	private int eloRating = 2000;
	private int doublesWins = 0;
	private int doublesLosses = 0;
	private int singlesWins = 0;
	private int singlesLosses = 0;
	private int prevWins = 0;
	private int prevLosses = 0;
	
	@Id
	@GeneratedValue
	@Column(name="PLAYER_ID")
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	//@NotNull
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//@NotNull
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//@NotNull
	@Column(name="ELO_RATING")
	public int getEloRating() {
		return eloRating;
	}
	
	public void setEloRating(int eloRating) {
		this.eloRating = eloRating;
	}
	
	//@NotNull
	@Column(name="DOUBLES_WINS")
	public int getDoublesWins() {
		return doublesWins;
	}
	
	public void setDoublesWins(int doubleWins) {
		this.doublesWins = doubleWins;
	}
	
	//@NotNull
	@Column(name="DOUBLES_LOSSES")
	public int getDoublesLosses() {
		return doublesLosses;
	}
	
	public void setDoublesLosses(int doublesLosses) {
		this.doublesLosses = doublesLosses;
	}
	
	//@NotNull
	@Column(name="SINGLES_WINS")
	public int getSinglesWins() {
		return singlesWins;
	}
	
	public void setSinglesWins(int singlesWins) {
		this.singlesWins = singlesWins;
	}
	
	//@NotNull
	@Column(name="SINGLES_LOSSES")
	public int getSinglesLosses() {
		return singlesLosses;
	}
	
	public void setSinglesLosses(int singlesLosses) {
		this.singlesLosses = singlesLosses;
	}
	
	//@NotNull
	@Column(name="PREV_WINS")
	public int getPrevWins() {
		return prevWins;
	}
	
	public void setPrevWins(int prevWins) {
		this.prevWins = prevWins;
	}
	
	//@NotNull
	@Column(name="PREV_LOSSES")
	public int getPrevLosses() {
		return prevLosses;
	}
	
	public void setPrevLosses(int prevLosses) {
		this.prevLosses = prevLosses;
	}
}
