package com.example.model;

public class Employee {
	private int empid;
	private String empname;
	private int empage;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpage() {
		return empage;
	}

	public void setEmpage(int empage) {
		this.empage = empage;
	}

	public Employee() {
		super();
	}

	public Employee(int empid, String empname, int empage) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empage = empage;
	}

}
