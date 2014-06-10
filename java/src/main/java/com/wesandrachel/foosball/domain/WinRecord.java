package com.wesandrachel.foosball.domain;

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

@Entity @Table(name="RECORDS_WINS")
@Cacheable @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WinRecord implements Serializable {
	
	private static final long serialVersionUID = 8191126637182143936L;
	
	private long id;
	private int count;
	private Player player1;
	private Player player2;
	private Date startDate;
	private Date endDate;
	
	@Id @GeneratedValue
	@Column(name="RECORD_ID")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="COUNT")
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@ManyToOne
	@JoinColumn(name="PLAYER_1", referencedColumnName="PLAYER_ID")
	public Player getPlayer1() {
		return player1;
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	@ManyToOne
	@JoinColumn(name="PLAYER_2", referencedColumnName="PLAYER_ID")
	@NotFound(action=NotFoundAction.IGNORE)
	public Player getPlayer2() {
		return player2;
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="END_DATE")
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
