package com.robert.RelationHibDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private int lapId;
	private String lName;
	private int price;
	@ManyToOne
	@JoinColumn(name="rollNo")
	private Student student;

	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", lName=" + lName + ", price=" + price + "]";
	}

}
