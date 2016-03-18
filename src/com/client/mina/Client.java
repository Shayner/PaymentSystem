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
	
	public static MainWin home;      //��ҳ��
	public static LogWin logWin;     //��¼ҳ��
	private IoSession session;
	public Infortest userInfo;
	
	@SuppressWarnings("deprecation")
	public void Init() {  
        // TODO Auto-generated method stub  
            // ����Socket 
             IoConnector connector = new NioSocketConnector();  
             //���ô��䷽ʽ  
             DefaultIoFilterChainBuilder chain = connector.getFilterChain();  
             ProtocolCodecFilter filter = new ProtocolCodecFilter(new ObjectSerializationCodecFactory());  
             chain.addLast("objectFilter", filter);  
             chain.addLast("data",new ProtocolCodecFilter(new DataCodecFactory()));
             //������Ϣ����  
             connector.setHandler(new MinaClientHandler());  
             //��ʱ����  
             connector.setConnectTimeout(30);  
             //����  
             ConnectFuture connectF = connector.connect(new InetSocketAddress("192.168.2.113", 8000));  
             //�ȴ��˽⽨��
             connectF.awaitUninterruptibly(); 
             //��ȡ��������
             session = connectF.getSession();
             //�ȴ��������ӽ����������ж�ʽ�������ȴ�
             connectF.getSession().getCloseFuture().awaitUninterruptibly();  
             connector.dispose();  
    } 
	/**
	//��ȡ�û���Ϣ������
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
	//��������
	public void send(BaseMessage message){
		System.out.println("send"+((Infortest) message.getData()).getregister());
		session.write(message);
	}
	**/
	//�����û�������
	public Infortest getUserInfo(){
		return userInfo;
	}
	public void setUserInfo(Infortest userInfo){
		this.userInfo = userInfo;
	}
	//����������
	public MainWin getMainWin( ){
		return home;
	}
	public void setMainWin(MainWin home){
		this.home = home;
	}
	//�������񣬹��캯��
	public static void main(String[] args){
       
		  try {
              //�������  
               UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());  
               JFrame.setDefaultLookAndFeelDecorated(true); 
               JDialog.setDefaultLookAndFeelDecorated(true); //���ϴ�����ʹ�����ĶԻ���Ҳ�ı�  
               //��������   
               SubstanceLookAndFeel.setCurrentTheme(new SubstanceOliveTheme());  
               //���ð�ť���  
               SubstanceLookAndFeel.setCurrentButtonShaper(new StandardButtonShaper()); //����ˮӡ  
               SubstanceLookAndFeel.setCurrentWatermark(new SubstanceStripeWatermark());  
               //���ñ߿�  
               SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
               //���ý�����Ⱦ  
               SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
               //���ñ���  
               SubstanceLookAndFeel.setCurrentTitlePainter(new MatteHeaderPainter()); 
		} catch (UnsupportedLookAndFeelException ex) {
		    ex.printStackTrace();
		}
		//��ʼ������������
		client = new Client();
		//����ӽ���
		home = new MainWin();
		home.getWinMain();
		client.Init();
	}
}
