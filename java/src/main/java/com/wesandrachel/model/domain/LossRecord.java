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

@Entity @Table(name="FOOSBALL_LOSS_RECORDS")
@Cacheable @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LossRecord implements Serializable {

	private static final long serialVersionUID = 2063531637815212570L;
	
	private int id;
	private int count;
	private Player loser1;
	private Player loser2;
	private Date startDate;
	private Date endDate;
	
	@Id @GeneratedValue
	@Column(name="LOSS_RECORD_ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="LOSS_COUNT")
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
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
