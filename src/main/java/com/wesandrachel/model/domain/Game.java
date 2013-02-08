package com.wesandrachel.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity @Table(name="FOOSBALL_HISTORY")
@Cacheable @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Game implements Serializable {

	private static final long serialVersionUID = -4633351524563529317L;
	
	private int id;
	private Date date;
	private Player winner1;
	private Player winner2;
	private Player loser1;
	private Player loser2;
	private boolean shutout;
	
	@Id
	@GeneratedValue
	@Column(name="GAME_ID", nullable=false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="DATE", nullable=false)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne
	@JoinColumn(name="WINNER_1", referencedColumnName="PLAYER_ID")
	public Player getWinner1() {
		return winner1;
	}
	
	public void setWinner1(Player winner1) {
		this.winner1 = winner1;
	}
	
	@ManyToOne
	@JoinColumn(name="WINNER_2", referencedColumnName="PLAYER_ID")
	@NotFound(action=NotFoundAction.IGNORE)
	public Player getWinner2() {
		return winner2;
	}
	
	public void setWinner2(Player winner2) {
		this.winner2 = winner2;
	}

	@ManyToOne
	@JoinColumn(name="LOSER_1", referencedColumnName="PLAYER_ID")
	public Player getLoser1() {
		return loser1;
	}
	
	public void setLoser1(Player loser1) {
		this.loser1 = loser1;
	}
	
	@ManyToOne
	@JoinColumn(name="LOSER_2", referencedColumnName="PLAYER_ID")
	@NotFound(action=NotFoundAction.IGNORE)
	public Player getLoser2() {
		return loser2;
	}
	
	public void setLoser2(Player loser2) {
		this.loser2 = loser2;
	}
	
	@Column(name="SHUTOUT")
	public boolean getShutout() {
		return shutout;
	}
	
	public void setShutout(boolean shutout) {
		this.shutout = shutout;
	}
}