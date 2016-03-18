package com.client.mina;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

import com.client.model.DataMessage;
import com.client.model.Filetest;
import com.client.model.Infortest;

public class DataEncoder extends ProtocolEncoderAdapter{
	
		@Override
		public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
			// TODO 自动生成的方法存根
			System.out.println("encode freeMemory::"+Runtime.getRuntime().freeMemory()/(1024*1024));
			DataMessage data=(DataMessage)message;
			IoBuffer buffer=IoBuffer.allocate(2048).setAutoExpand(true);
			buffer.putInt(data.gettype());
		//	System.out.println(data.gettype());
			buffer.putInt(data.getlength());
		//	System.out.println(data.getlength());
			System.out.println("编码开始。。。。。。。。。");
			buffer.put(data.getbyte());
			buffer.flip();
			out.write(buffer);
			buffer.free();
			System.out.println("编码完成。。。。。。。");
		}
	
}

