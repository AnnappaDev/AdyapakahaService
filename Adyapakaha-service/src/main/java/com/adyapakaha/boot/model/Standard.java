package com.adyapakaha.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Standard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int std;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	
}
