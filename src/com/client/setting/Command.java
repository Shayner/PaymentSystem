package com.client.setting;

public class Command {
	/**
	 * 服务器端口
	 */
	public final static int server_port = 8888;

	/**
	 * 服务器IP
	 */
	public final static String server_ipaddress = "";

	/**
	 * 服务端用户登录信令
	 */
	public final static String login = "登录";

	/**
	 * 用户登录成功信令
	 */
	public final static String loginsuccess = "登录成功";

	/**
	 * 用户登录重复信令
	 */
	public final static String loginreapt = "重复登录";

	/**
	 * 用户登录失败信令
	 */
	public final static String loginfail = "登录失败";

	/**
	 * 服务端注册信令
	 */
	public final static String register = "注册";

	/**
	 * 客户端用户注册成功信令
	 */
	public final static String registersuccess = "注册成功";

	/**
	 * 注册失败信令
	 */
	public final static String registerfail = "注册失败";

	/**
	 * 修改用户信息信令
	 */
	public final static String modifyusrinfo = "更改信息";

	/**
	 * 修改成功信令
	 */
	public final static String modifyusrinfosuccess = "更改成功";
	
	/**
	 * 文件传输
	 */
    public final static int fileTransmit = 0x01;
    //对象传输
    public final static int objectTransmit = 0x00;

}

