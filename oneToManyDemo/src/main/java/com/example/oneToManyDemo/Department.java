package com.example.oneToManyDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String block;
	private String hod;
	
	@OneToMany(mappedBy="department")
	private List<Employe>employees=new ArrayList<Employe>();
	
    public Department() {
		
	}


	
	public Department(int id, String name, String block, String hod) {
	super();
	this.id = id;
	this.name = name;
	this.block = block;
	this.hod = hod;
}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public List<Employe> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}



	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", block=" + block + ", hod=" + hod + "]";
	}

	

	
}
