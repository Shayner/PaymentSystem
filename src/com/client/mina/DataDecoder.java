package com.client.mina;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import com.client.mina.DataDecoder.Context;
import com.client.model.DataMessage;
import com.client.model.Filetest;
import com.client.setting.Command;


public class DataDecoder extends CumulativeProtocolDecoder{
	private final AttributeKey CONTEXT = new AttributeKey(this.getClass(), "context");

	@Override
	protected boolean doDecode(IoSession session, IoBuffer buff, ProtocolDecoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		//CharsetDecoder charset = Charset.forName("UTF-8").newDecoder(); 
		
		System.out.println("继续解码......." + buff.remaining()); 
		Context ctx = this.getContext(session); 
		int type=ctx.gettype();
 
		int length=ctx.getLength();
 
		IoBuffer buffer=ctx.getBuffer();
		int matchlength=ctx.getMatchLength();
		if(length==0)
		{
			 type=buff.getInt();
			 System.out.println(type); 
	         length=buff.getInt(); 
	         System.out.println(length); 
	         matchlength = buff.remaining();  
	         ctx.settype(type);
	         ctx.setLength(length);  
	     } else {  
	            matchlength += buff.remaining();  
	     }
		 ctx.setMatchLength(matchlength);
	     if(buff.hasRemaining()) {// 如果buff中还有数据  
	    	 buffer.put(buff);// 添加到保存数据的buffer中  
        	 if (matchlength >= length) {// 如果已经发送的数据的长度>=目标数据的长度,则进行解码  
        		 byte[] b = new byte[(int)length];  
        	     buffer.flip();  
        	     buffer.get(b);
        	     DataMessage msg=new DataMessage();
        	     msg.settype(ctx.gettype());
        	     msg.setlength(ctx.getLength());
        	     msg.setbyte(b);
        	     out.write(msg); 
        	     System.out.println(matchlength);  
        	     System.out.println("解码完成.......");  
        	     } else {  
        	    	 System.out.println(ctx.getMatchLength()); 
        	         ctx.setBuffer(buffer);  
        	         }  
        	 }
	     	return false;
	}
	public class Context {  
        public IoBuffer buffer;  
        public int length = 0;  
        public int matchLength = 0;  
        public String name = "";  
        public int type=0;
        public int state=0;
  
        public Context() {  
            this.buffer = IoBuffer.allocate(2048).setAutoExpand(true);  
        }  
  
        public int getMatchLength() {  
            return matchLength;  
        }  
  
        public void setMatchLength(int matchLength) {  
            this.matchLength = matchLength;  
        }  
  
        public IoBuffer getBuffer() {  
            return buffer;  
        }  
  
        public void setBuffer(IoBuffer buffer) {  
            this.buffer = buffer;  
        }  
  
        public int getLength() {  
            return length;  
        }  
  
        public void setLength(int length) {  
            this.length = length;  
        }  
  
        public String getname() {  
            return name;  
        }  
  
        public void setname(String name) {  
            this.name= name;  
        }  
        public void settype(int type)
        {
        	this.type=type;
        }
        public int gettype()
        {
        	return type;
        }
        public void setstate(int state)
        {
        	this.state=state;
        }
        public int getstate()
        {
        	return state;
        }
    }
  
    public Context getContext(IoSession session) {  
        Context ctx = (Context) session.getAttribute(CONTEXT);  
        if (ctx == null) {  
            ctx = new Context();  
            session.setAttribute(CONTEXT, ctx);  
        }  
        return ctx;  
    }  
} 