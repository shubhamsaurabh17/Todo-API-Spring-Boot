package com.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int t_id;
	private String t_title;
	private String t_desc;
	private boolean t_isCompleted;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	public boolean isT_isCompleted() {
		return t_isCompleted;
	}
	public void setT_isCompleted(boolean t_isCompleted) {
		this.t_isCompleted = t_isCompleted;
	}
	@Override
	public String toString() {
		return "Todo [t_id=" + t_id + ", t_title=" + t_title + ", t_desc=" + t_desc + ", t_isCompleted=" + t_isCompleted
				+ "]";
	}
	public Todo(int t_id, String t_title, String t_desc, boolean t_isCompleted) {
		super();
		this.t_id = t_id;
		this.t_title = t_title;
		this.t_desc = t_desc;
		this.t_isCompleted = t_isCompleted;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
