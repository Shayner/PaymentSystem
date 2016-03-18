package com.client.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.client.mina.Client;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainWin implements ActionListener {
	private JFrame winMain = null;
	private JPanel contentPane;
	private JButton but_register;
	/**
	 * Create the frame.
	 */
	public JFrame getWinMain() {
		if(winMain == null){
		winMain = new JFrame();
		winMain.setTitle("�����ɷ�ϵͳ");
		Toolkit toolkit = winMain.getToolkit();// ��ô��幤�߰�
		Dimension screenSize = toolkit.getScreenSize();// ��ȡ��Ļ��С
		winMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winMain.setBounds(0, 0, screenSize.width, screenSize.height);
		System.out.println("width:"+screenSize.width+"height:"+screenSize.height);
		winMain.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		winMain.setContentPane(contentPane);
		
		but_register = new JButton("׼��������ע������");
		but_register.addActionListener(this);   //���ʱ�����
		//��ӹ���˰�¼���Ӧ
		JButton but_purchase = new JButton("�����³�����˰");
		but_purchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PurchaseWin purTax = new PurchaseWin();
				purTax.setVisible(true);
			}
		});
		
		JButton but_insurance = new JButton("�����³�����");
		
		JButton but_submit = new JButton("������ע�������ύ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(275)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(but_register, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(but_insurance, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(but_purchase, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(but_submit, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(but_register, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addComponent(but_insurance, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(but_purchase, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addComponent(but_submit, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		winMain.setVisible(true);
		}
		return winMain;
	}
	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		//�û���һ���뵵����
		if (e.getSource() == but_register) {
			winMain.setVisible(false);
			Client.logWin = new LogWin();
			Client.logWin.getWinFrame();	
		}
	}
}
