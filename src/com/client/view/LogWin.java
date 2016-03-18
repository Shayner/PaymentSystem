package com.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.client.mina.Client;
import com.client.model.Infortest;

import javax.swing.JButton;
import javax.swing.JTextField;

public class LogWin implements ActionListener {

	private JPanel contentPane;
	private JFrame winFrame = null;
	private JButton cancelBut;
	private JButton logBut;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField userName;
	private JTextField password;

	/**
	 * Create the frame.
	 */
	public JFrame getWinFrame() {
		if(winFrame == null){
			winFrame = new JFrame();
			winFrame.setTitle("�û��뵵");
			winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			winFrame.setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			winFrame.setContentPane(contentPane);
			
			logBut = new JButton("ȷ��");
			logBut.setBounds(59, 148, 93, 23);
			contentPane.add(logBut);
			logBut.addActionListener(this);
			
			cancelBut = new JButton("ȡ��");
			cancelBut.setBounds(183, 148, 93, 23);
			cancelBut.addActionListener(this);
			contentPane.add(cancelBut);
			
			textField = new JTextField();
			textField.setText("�û�����");
			textField.setBounds(59, 73, 66, 25);
			textField.setEditable(false);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setText("���룺");
			textField_1.setBounds(59, 116, 66, 25);
			textField_1.setEditable(false);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			userName = new JTextField();
			userName.setBounds(183, 73, 93, 23);
			contentPane.add(userName);
			userName.setColumns(10);
			
			password = new JTextField();
			password.setColumns(10);
			password.setBounds(183, 116, 93, 22);
			contentPane.add(password);
			winFrame.setVisible(true);
		}
		return winFrame;
	}
	//ע������¼�
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		//�û���һ���뵵����
		if (e.getSource() == cancelBut) {
			this.winFrame.setVisible(false);
			Client.home.getWinMain().setVisible(true);
		}
		//�����û�����
		if(e.getSource() == logBut){
			this.winFrame.setVisible(false);
			//Client.client.sendUserInfo();
			Client.home.getWinMain().setVisible(true);
		}
	}
	public JTextField getUserName(){
		return userName;
	}
	public JTextField getPassword(){
		return password;
	}
}
