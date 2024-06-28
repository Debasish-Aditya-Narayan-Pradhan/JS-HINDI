package com.resister.bank;

public class getSet {
	private  String name;
	private  String phn;
	private  String pass;
	
	public void setName(String username)
	{
		this.name = username;
	}
	
	public void setPhn(String phone)
	{
		this.phn = phone;
		
	}
	
	public void setPass(String password)
	{
		this.pass = password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhn()
	{
		return phn;
	}
	
	public String getPass()
	{
		return pass;
	}
}
