package com.sfx.pojo;

import java.time.LocalDate;

public class User {
	private Long id;
	private String name;
	private LocalDate joinedDate;

	public User(Long id, String name, LocalDate joinedDate) {
		super();
		this.id = id;
		this.name = name;
		this.joinedDate = joinedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", joinedDate=" + joinedDate + "]";
	}

}
