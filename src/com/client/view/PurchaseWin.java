package com.client.view;

import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLayeredPane;

public class PurchaseWin extends JFrame {

	private JPanel contentPane;
	private JTextField userName1;
	private JTextField userName;
	private JTextField userNum;
	private JTextField userNum1;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField phone;
	private JTextField phone1;
	private JTextField zipCode;
	private JTextField zipCode1;
	private JTextField address;
	private JTextField address1;
	private JTextField carInfo;
	private JTextField carType;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JPanel title_panel;
	private JTextField factory1;
	private JTextField factory;
	private JTextField brandModel;
	private JTextField brandModel1;
	private JTextArea frameNum1;
	private JLabel title;
	private JTextField engineNum;
	private JTextArea engineNum1;
	private JTextField buyInfo;
	private JLabel invoiceNum;
	private JTextArea invoiceNum1;
	private JLabel invoicePrice;
	private JTextArea invoicePrice1;
	private JLabel price;
	private JTextField price1;
	private JTextField dutiable;
	private JTextField dutiable1;
	private JTextField tariff;
	private JTextField tariff1;
	private JTextField salesTax;
	private JTextField salesTax1;
	/**
	 * Create the frame.
	 */
	public PurchaseWin() {
		super("机动车置税纳税申报表");
		Toolkit toolkit = getToolkit();// 获得窗体工具包
		Dimension screenSize = toolkit.getScreenSize();// 获取屏幕大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//滚动条
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1333, 0, 17, 729);
		contentPane.add(scrollBar);
		
		userName = new JTextField();
		userName.setEditable(false);
		userName.setHorizontalAlignment(SwingConstants.CENTER );
		userName.setText("纳税人证件名称");
		userName.setBounds(270, 120, 115, 30);
		contentPane.add(userName);
		userName.setColumns(10);
		
		userName1 = new JTextField();
		userName1.setForeground(new Color(0, 0, 0));
		userName1.setBackground(Color.WHITE);
		userName1.setBounds(385, 120, 185, 30);
		contentPane.add(userName1);
		userName1.setColumns(10);
		
		userNum = new JTextField();
		userNum.setText("证件号码");
		userNum.setEditable(false);
		userNum.setHorizontalAlignment(SwingConstants.CENTER);
		userNum.setEditable(false);
		userNum.setColumns(10);
		userNum.setBounds(570, 120, 125, 30);
		contentPane.add(userNum);
		
		userNum1 = new JTextField();
		userNum1.setForeground(Color.BLACK);
		userNum1.setColumns(10);
		userNum1.setBackground(Color.WHITE);
		userNum1.setBounds(695, 120, 185, 30);
		contentPane.add(userNum1);
		
		
		
		phone = new JTextField();
		phone.setText("联系电话");
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setEditable(false);
		phone.setColumns(10);
		phone.setBounds(270, 150, 115, 30);
		contentPane.add(phone);
		
		phone1 = new JTextField();
		phone1.setForeground(Color.BLACK);
		phone1.setColumns(10);
		phone1.setBackground(Color.WHITE);
		phone1.setBounds(385, 150, 100, 30);
		contentPane.add(phone1);
		
		zipCode = new JTextField();
		zipCode.setText("邮政编码");
		zipCode.setHorizontalAlignment(SwingConstants.CENTER);
		zipCode.setEditable(false);
		zipCode.setColumns(10);
		zipCode.setBounds(485, 150, 70, 30);
		contentPane.add(zipCode);
		
		zipCode1 = new JTextField();
		zipCode1.setForeground(Color.BLACK);
		zipCode1.setBackground(Color.WHITE);
		zipCode1.setColumns(10);
		zipCode1.setBounds(555, 150, 70, 30);
		contentPane.add(zipCode1);
		
		address = new JTextField();
		address.setText("地址");
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setEditable(false);
		address.setColumns(10);
		address.setBounds(625, 150, 70, 30);
		contentPane.add(address);
		
		address1 = new JTextField();
		address1.setForeground(Color.BLACK);
		address1.setColumns(10);
		address1.setBackground(Color.WHITE);
		address1.setBounds(695, 150, 185, 30);
		contentPane.add(address1);
		
		carInfo = new JTextField();
		carInfo.setText("车  辆  基  本  信  息");
		carInfo.setHorizontalAlignment(SwingConstants.CENTER);
		carInfo.setEditable(false);
		carInfo.setColumns(10);
		carInfo.setBounds(270, 180, 610, 30);
		contentPane.add(carInfo);
		
		carType = new JTextField();
		carType.setText("车辆类别");
		carType.setHorizontalAlignment(SwingConstants.CENTER);
		carType.setEditable(false);
		carType.setColumns(10);
		carType.setBounds(270, 210, 115, 30);
		contentPane.add(carType);
		
		JPanel carType_panel = new JPanel();
		FlowLayout fl_carType_panel = (FlowLayout) carType_panel.getLayout();
		carType_panel.setForeground(Color.BLACK);
		carType_panel.setBackground(Color.WHITE);
		carType_panel.setBounds(385, 210, 495, 30);
		contentPane.add(carType_panel);
		
		ButtonGroup butType = new ButtonGroup();
		JCheckBox checkBox_4 = new JCheckBox("汽车");
		carType_panel.add(checkBox_4);
		butType.add(checkBox_4);
		
		JCheckBox checkBox_3 = new JCheckBox("摩托车");
		carType_panel.add(checkBox_3);
		butType.add(checkBox_3);
		
		checkBox = new JCheckBox("电车");
		carType_panel.add(checkBox);
		butType.add(checkBox);
		
		checkBox_1 = new JCheckBox("挂车");
		carType_panel.add(checkBox_1);
		butType.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("农用运输车");
		carType_panel.add(checkBox_2);
		butType.add(checkBox_2);
		
		title_panel = new JPanel();
		title_panel.setBounds(270, 10, 610, 112);
		contentPane.add(title_panel);
		
		title = new JLabel("车辆购置税纳税申报表");
		title.setFont(new Font("宋体",Font.PLAIN,20));
		title_panel.add(title);
		
		factory1 = new JTextField();
		factory1.setForeground(Color.BLACK);
		factory1.setColumns(10);
		factory1.setBackground(Color.WHITE);
		factory1.setBounds(385, 240, 240, 30);
		contentPane.add(factory1);
		
		factory = new JTextField();
		factory.setText("生产企业名称");
		factory.setHorizontalAlignment(SwingConstants.CENTER);
		factory.setEditable(false);
		factory.setColumns(10);
		factory.setBounds(270, 240, 115, 30);
		contentPane.add(factory);
		
		brandModel = new JTextField();
		brandModel.setText("厂牌型号");
		brandModel.setHorizontalAlignment(SwingConstants.CENTER);
		brandModel.setEditable(false);
		brandModel.setColumns(10);
		brandModel.setBounds(625, 240, 100, 30);
		contentPane.add(brandModel);
		
		brandModel1 = new JTextField();
		brandModel1.setForeground(Color.BLACK);
		brandModel1.setColumns(10);
		brandModel1.setBackground(Color.WHITE);
		brandModel1.setBounds(725, 240, 155, 30);
		contentPane.add(brandModel1);
		
		frameNum1 = new JTextArea(2,1);
		frameNum1.setForeground(Color.BLACK);
		frameNum1.setColumns(10);
		frameNum1.setLineWrap(true);
		//frameNum1.setOpaque(false);     //设置为透明
		frameNum1.setBackground(Color.WHITE);
		frameNum1.setBounds(385, 270, 240, 60);
		contentPane.add(frameNum1);
		
		JLabel frameNum = new JLabel("<html>车辆识别代码<br>（车架号码）</html>");
		frameNum.setBackground(Color.WHITE);
		frameNum.setForeground(Color.black);
		frameNum.setHorizontalAlignment(SwingConstants.CENTER);
		frameNum.setBounds(270, 270, 115, 60);
		contentPane.add(frameNum);
		
		engineNum = new JTextField();
		engineNum.setText("发动机型号");
		engineNum.setHorizontalAlignment(SwingConstants.CENTER);
		engineNum.setEditable(false);
		engineNum.setColumns(10);
		engineNum.setBounds(625, 270, 100, 60);
		contentPane.add(engineNum);
		
		engineNum1 = new JTextArea(2, 10);
		engineNum1.setLineWrap(true);
		engineNum1.setForeground(Color.BLACK);
		engineNum1.setBackground(Color.WHITE);
		engineNum1.setBounds(725, 270, 155, 60);
		contentPane.add(engineNum1);
		
		buyInfo = new JTextField();
		buyInfo.setText("车  辆  购  置  信  息");
		buyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		buyInfo.setEditable(false);
		buyInfo.setColumns(10);
		buyInfo.setBounds(270, 330, 610, 30);
		contentPane.add(buyInfo);
		
		invoiceNum = new JLabel("<html>机动车销售统一发票<br>(或有效凭证)号码</html>");
		invoiceNum.setHorizontalAlignment(SwingConstants.CENTER);
		invoiceNum.setBounds(270, 360, 115, 60);
		contentPane.add(invoiceNum);
		
		invoiceNum1 = new JTextArea(2, 10);
		invoiceNum1.setLineWrap(true);
		invoiceNum1.setForeground(Color.BLACK);
		invoiceNum1.setBackground(Color.WHITE);
		invoiceNum1.setBounds(385, 360, 100, 60);
		contentPane.add(invoiceNum1);
		
		invoicePrice = new JLabel();
		invoicePrice.setText("<html>机动车销售统一发票<br>（或有效凭证）价格");
		invoicePrice.setHorizontalAlignment(SwingConstants.CENTER);
		invoicePrice.setBounds(485, 360, 115, 60);
		contentPane.add(invoicePrice);
		
		invoicePrice1 = new JTextArea(2, 10);
		invoicePrice1.setLineWrap(true);
		invoicePrice1.setForeground(Color.BLACK);
		invoicePrice1.setBackground(Color.WHITE);
		invoicePrice1.setBounds(600, 360, 75, 60);
		contentPane.add(invoicePrice1);
		
		price = new JLabel();
		price.setText("价外费用");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(675, 360, 85, 60);
		contentPane.add(price);
		
		price1 = new JTextField();
		price1.setForeground(Color.BLACK);
		price1.setColumns(10);
		price1.setBackground(Color.WHITE);
		price1.setBounds(760, 360, 120, 60);
		contentPane.add(price1);
		
		dutiable = new JTextField();
		dutiable.setText("关税完税价格");
		dutiable.setHorizontalAlignment(SwingConstants.CENTER);
		dutiable.setEditable(false);
		dutiable.setColumns(10);
		dutiable.setBounds(270, 420, 115, 30);
		contentPane.add(dutiable);
		
		dutiable1 = new JTextField();
		dutiable1.setForeground(Color.BLACK);
		dutiable1.setColumns(10);
		dutiable1.setBackground(Color.WHITE);
		dutiable1.setBounds(385, 420, 100, 30);
		contentPane.add(dutiable1);
		
		tariff = new JTextField();
		tariff.setText("关税");
		tariff.setHorizontalAlignment(SwingConstants.CENTER);
		tariff.setEditable(false);
		tariff.setColumns(10);
		tariff.setBounds(485, 420, 115, 30);
		contentPane.add(tariff);
		
		tariff1 = new JTextField();
		tariff1.setForeground(Color.BLACK);
		tariff1.setColumns(10);
		tariff1.setBackground(Color.WHITE);
		tariff1.setBounds(600, 420, 75, 30);
		contentPane.add(tariff1);
		
		salesTax = new JTextField();
		salesTax.setText("消费税");
		salesTax.setHorizontalAlignment(SwingConstants.CENTER);
		salesTax.setEditable(false);
		salesTax.setColumns(10);
		salesTax.setBounds(675, 420, 115, 30);
		contentPane.add(salesTax);
		
		salesTax1 = new JTextField();
		salesTax1.setForeground(Color.BLACK);
		salesTax1.setColumns(10);
		salesTax1.setBackground(Color.WHITE);
		salesTax1.setBounds(790, 420, 90, 30);
		contentPane.add(salesTax1);
	}
}
