package com.client.mina;

import java.net.InetSocketAddress;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.theme.SubstanceBottleGreenTheme;
import org.jvnet.substance.theme.SubstanceOliveTheme;
import org.jvnet.substance.title.MatteHeaderPainter;
import org.jvnet.substance.watermark.SubstanceStripeWatermark;

import com.client.model.Infortest;
import com.client.setting.Command;
import com.client.view.LogWin;
import com.client.view.MainWin;

public class Client {
	public static Client client;
	
	public static MainWin home;      //主页面
	public static LogWin logWin;     //登录页面
	private IoSession session;
	public Infortest userInfo;
	
	@SuppressWarnings("deprecation")
	public void Init() {  
        // TODO Auto-generated method stub  
            // 创建Socket 
             IoConnector connector = new NioSocketConnector();  
             //设置传输方式  
             DefaultIoFilterChainBuilder chain = connector.getFilterChain();  
             ProtocolCodecFilter filter = new ProtocolCodecFilter(new ObjectSerializationCodecFactory());  
             chain.addLast("objectFilter", filter);  
             chain.addLast("data",new ProtocolCodecFilter(new DataCodecFactory()));
             //设置消息处理  
             connector.setHandler(new MinaClientHandler());  
             //超时设置  
             connector.setConnectTimeout(30);  
             //连接  
             ConnectFuture connectF = connector.connect(new InetSocketAddress("192.168.2.113", 8000));  
             //等待了解建立
             connectF.awaitUninterruptibly(); 
             //获取本次连接
             session = connectF.getSession();
             //等待本次连接结束，不可中断式的阻塞等待
             connectF.getSession().getCloseFuture().awaitUninterruptibly();  
             connector.dispose();  
    } 
	/**
	//获取用户信息并发送
	public void sendUserInfo( ){
		userInfo = new Infortest();
		userInfo.setindentify(Client.logWin.getUserName().getText());
		userInfo.setregister_id(Client.logWin.getPassword().getText());
		userInfo.setvehicle("3.17");
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setDataType(BeanUtil.UPLOAD_OBJECT);
		baseMessage.setData(userInfo);
		send(baseMessage);
	}
	//发送数据
	public void send(BaseMessage message){
		System.out.println("send"+((Infortest) message.getData()).getregister());
		session.write(message);
	}
	**/
	//出里用户数据类
	public Infortest getUserInfo(){
		return userInfo;
	}
	public void setUserInfo(Infortest userInfo){
		this.userInfo = userInfo;
	}
	//处理主界面
	public MainWin getMainWin( ){
		return home;
	}
	public void setMainWin(MainWin home){
		this.home = home;
	}
	//启动服务，构造函数
	public static void main(String[] args){
       
		  try {
              //设置外观  
               UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());  
               JFrame.setDefaultLookAndFeelDecorated(true); 
               JDialog.setDefaultLookAndFeelDecorated(true); //加上此语句会使弹出的对话框也改变  
               //设置主题   
               SubstanceLookAndFeel.setCurrentTheme(new SubstanceOliveTheme());  
               //设置按钮外观  
               SubstanceLookAndFeel.setCurrentButtonShaper(new StandardButtonShaper()); //设置水印  
               SubstanceLookAndFeel.setCurrentWatermark(new SubstanceStripeWatermark());  
               //设置边框  
               SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
               //设置渐变渲染  
               SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
               //设置标题  
               SubstanceLookAndFeel.setCurrentTitlePainter(new MatteHeaderPainter()); 
		} catch (UnsupportedLookAndFeelException ex) {
		    ex.printStackTrace();
		}
		//初始化构建各种类
		client = new Client();
		//不添加界面
		home = new MainWin();
		home.getWinMain();
		client.Init();
	}
}
