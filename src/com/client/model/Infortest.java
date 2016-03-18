package com.client.model;

import java.io.Serializable;

public class Infortest implements Serializable {
	private String vehicle_id;
	private String indentify_id; 
	private String register_id;
	public Infortest()
	{
		
	}
	public Infortest(String vehicle_id,String indentify_id,String register_id)
	{
		this.vehicle_id=vehicle_id;
		this.indentify_id=indentify_id;
		this.register_id=register_id;
	}
	public void setvehicle(String vehicle_id)
	{
		
		this.vehicle_id=vehicle_id;
	}
	public void setindentify(String indentify_id)
	{
		
		this.indentify_id=indentify_id;
	}
	public void setregister_id(String register_id)
	{
		
		this.register_id=register_id;
	}
	public String getvehicle()
	{
		return vehicle_id;
	}
	public String getindentify()
	{
		return indentify_id;
	}
	public String getregister()
	{
		return register_id;
	}
}

