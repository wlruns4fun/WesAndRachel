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

@Entity @Table(name="FOOSBALL_WIN_RECORDS")
@Cacheable @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WinRecord implements Serializable {
	
	private static final long serialVersionUID = 8191126637182143936L;
	
	private int id;
	private int count;
	private Player winner1;
	private Player winner2;
	private Date startDate;
	private Date endDate;
	
	@Id @GeneratedValue
	@Column(name="WIN_RECORD_ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="WIN_COUNT")
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
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
