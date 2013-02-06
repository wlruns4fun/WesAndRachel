package com.wesandrachel.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FOOSBALL_CATEGORIES")
public class Category implements Serializable {

	private int categoryId;
	private String categoryName;
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID", nullable=false)
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name="CATEGORY_NAME", nullable=false)
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
