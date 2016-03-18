package com.client.model;

import java.io.Serializable;

public class Filetest implements Serializable{
	private static final long serialVersionUID = 1L;
	//private String filename;
	private long length=0;
	private byte[] filebyte;
	public Filetest()
	{
		
	}
	public Filetest(byte[] bytedata)
	{
		this.filebyte = bytedata;
		//this.filename = filename;
	}

	public void setfilebyte(byte[] filebyte)
	{
		this.filebyte = filebyte;
	}

	public byte[] getfilebyte()
	{
		return filebyte;
	}
	public void setlenth(long lenth)
	{
		this.length=lenth;
	}
	public long getlength()
	{
		return length;
	}
}
