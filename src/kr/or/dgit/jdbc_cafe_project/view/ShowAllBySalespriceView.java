package kr.or.dgit.jdbc_cafe_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_cafe_project.list.ShowAllBySalespriceList;
import kr.or.dgit.jdbc_cafe_project.service.ShowAllBySalespriceService;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowAllBySalespriceView extends JFrame {

	private JPanel contentPane;
	private ShowAllBySalespriceService service;
	private ShowAllBySalespriceList pList;
	private JTable table;
	
	
	public ShowAllBySalespriceView() {
		setTitle("판매금액 순위로 보기");
		service=new ShowAllBySalespriceService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pList=new ShowAllBySalespriceList();
		pList.loadData();
	
		contentPane.add(pList, BorderLayout.CENTER);
	}

}
