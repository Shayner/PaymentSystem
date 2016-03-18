package com.client.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataMessage {
	private int datatype;
	private int length;
	private byte[] data;
	public void settype(int datatype)
	{
		this.datatype=datatype;
	}
	public int gettype()
	{
		return datatype;
	}
	public void setlength(int length)
	{
		this.length=length;
	}
	public int getlength()
	{
		return length;
	}
	public void setbyte(byte[] data)
	{
		this.data=data;
	}
	public byte[] getbyte()
	{
		return data;
	}
	public void ObjectToByte(Object message)
	{
		try{
		 ByteArrayOutputStream bo = new ByteArrayOutputStream();  
		 ObjectOutputStream oo = new ObjectOutputStream(bo); 
		 System.out.println("Data freeMemory::"+Runtime.getRuntime().freeMemory()/(1024*1024));
		 oo.writeObject(message);  
		 data = bo.toByteArray();  
		 bo.close();  
		 oo.close();	
		} catch (Exception e) {  
			System.out.println("translation" + e.getMessage());  
			e.printStackTrace();  
		}
		length=data.length;
	}
	public Object ByteToObject()
	{
		Object obj=null;
		try {    
			ByteArrayInputStream bi = new ByteArrayInputStream(data);  
			ObjectInputStream oi = new ObjectInputStream(bi);  
			obj = oi.readObject();  
			bi.close();  
			oi.close();  
			} catch (Exception e) {  
				System.out.println("translation" + e.getMessage());  
				e.printStackTrace();  
			} 
		return obj;
	}
}

