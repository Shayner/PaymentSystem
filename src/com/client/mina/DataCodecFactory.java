package com.client.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class DataCodecFactory implements ProtocolCodecFactory{
	private DataEncoder encoder;
	private DataDecoder decoder;
	public  DataCodecFactory()
	{
		encoder=new DataEncoder();
		decoder=new DataDecoder();
	}
	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		// TODO 自动生成的方法存根
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		// TODO 自动生成的方法存根
		return encoder;
	}
	
}
