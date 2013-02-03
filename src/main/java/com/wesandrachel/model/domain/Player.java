package com.wesandrachel.model.domain;

import com.wesandrachel.model.domain.Category;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="FOOSBALL_PLAYERS")
public class Player {

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
	private List<Category> categories;
	
	@Id
	@GeneratedValue
	@Column(name="PLAYER_ID", nullable=false)
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		if (playerId > -1) {
			this.playerId = playerId;
		}
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
	
	@Column(name="ELO_RATING", nullable=false)
	public int getEloRating() {
		return eloRating;
	}
	
	public void setEloRating(int eloRating) {
		this.eloRating = eloRating;
	}
	
	@Column(name="DOUBLES_WINS", nullable=false)
	public int getDoublesWins() {
		return doublesWins;
	}
	
	public void setDoublesWins(int doubleWins) {
		this.doublesWins = doubleWins;
	}
	
	@Column(name="DOUBLES_LOSSES", nullable=false)
	public int getDoublesLosses() {
		return doublesLosses;
	}
	
	public void setDoublesLosses(int doublesLosses) {
		this.doublesLosses = doublesLosses;
	}
	
	@Column(name="SINGLES_WINS", nullable=false)
	public int getSinglesWins() {
		return singlesWins;
	}
	
	public void setSinglesWins(int singlesWins) {
		this.singlesWins = singlesWins;
	}
	
	@Column(name="SINGLES_LOSSES", nullable=false)
	public int getSinglesLosses() {
		return singlesLosses;
	}
	
	public void setSinglesLosses(int singlesLosses) {
		this.singlesLosses = singlesLosses;
	}
	
	@Column(name="PREV_WINS", nullable=false)
	public int getPrevWins() {
		return prevWins;
	}
	
	public void setPrevWins(int prevWins) {
		this.prevWins = prevWins;
	}
	
	@Column(name="PREV_LOSSES", nullable=false)
	public int getPrevLosses() {
		return prevLosses;
	}
	
	public void setPrevLosses(int prevLosses) {
		this.prevLosses = prevLosses;
	}
}
