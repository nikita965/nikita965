package com.cg.demo.model;

public class Report
{
	private String	name;
	private String	age;


	public String getName()
	{
		return this.name;
	}


	public void setName(final String name)
	{
		this.name = name;
	}


	public String getAge()
	{
		return this.age;
	}


	public void setAge(final String age)
	{
		this.age = age;
	}


	@Override
	public String toString()
	{
		return "Report [name=" + this.name + ", age=" + this.age + "]";
	}

}
