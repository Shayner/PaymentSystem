package com.client.mina;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.client.model.DataMessage;
import com.client.model.Filetest;
import com.client.model.Infortest;

public class MinaClientHandler extends IoHandlerAdapter{
	private final static Logger log = LoggerFactory.getLogger(MinaClientHandler.class.getName());
	@Override
	public void sessionOpened(IoSession session) throws Exception {  
		System.out.println("¿Í»§¶ËµÇÂ½");
		
		 /*    Infortest client = new Infortest("5555","333","222");
		     DataMessage data=new DataMessage();
		     data.settype(1);
		     data.ObjectToByte(client);
		     session.write(data);*/

		 File file=new File("E://mysql.zip");
		 
		 InputStream is=new FileInputStream(file);
		 ByteArrayOutputStream bao=new ByteArrayOutputStream();
		 byte [] bytes=new byte[1024];
		 int length=0;
		 long count = 0;
		 long heapsize = Runtime.getRuntime().totalMemory();
	     System.out.println("heapsize is :: " + heapsize/(1024*1024));
		 while((length=is.read(bytes))!=-1)
		 {
			 count++;
			 if(count%1024 == 0)
				 System.out.println("freeMemory["+count+"]::"+Runtime.getRuntime().freeMemory()/(1024*1024));
			 bao.write(bytes,0,length);
		 }
		 is.close();
		 System.out.println("freeMemory::"+Runtime.getRuntime().freeMemory()/(1024*1024));
		 Filetest filesent=new Filetest();
		 filesent.setlenth(file.length());
		 filesent.setfilebyte(bao.toByteArray());
		 bao.close();
		 System.out.println("freeMemory::"+Runtime.getRuntime().freeMemory()/(1024*1024));
		 DataMessage msg=new DataMessage();
		 msg.settype(0);
		 msg.ObjectToByte(filesent);
		 session.write(msg);
	 } 
	      
	 @Override
	public void sessionClosed(IoSession session)  
	 {  
	   System.out.println("client close");  
	 }  
	   
	 @Override
	public void messageReceived(IoSession session , Object message)throws Exception  
	 {  
	  System.out.println("OK!") ;  
	    
	 }  
}
