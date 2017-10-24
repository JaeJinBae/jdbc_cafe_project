package kr.or.dgit.jdbc_cafe_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_cafe_project.list.ShowAllByMargincostList;
import kr.or.dgit.jdbc_cafe_project.service.ShowAllByMargincostService;
import kr.or.dgit.jdbc_cafe_project.service.ShowAllBySalespriceService;

public class ShowAllByMargincostView extends JFrame {

	private JPanel contentPane;
	private ShowAllByMargincostService service;
	private ShowAllByMargincostList pList;
	

	public ShowAllByMargincostView() {
		service=new ShowAllByMargincostService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pList=new ShowAllByMargincostList();
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);
	}

}
