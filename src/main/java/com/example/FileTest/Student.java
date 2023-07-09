package com.example.FileTest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private long id;
    private String name;
    private String Email;
	public Student() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
}
