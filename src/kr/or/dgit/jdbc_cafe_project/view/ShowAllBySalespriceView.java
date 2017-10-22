package kr.or.dgit.jdbc_cafe_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_cafe_project.list.ShowAllBySalespriceList;
import kr.or.dgit.jdbc_cafe_project.service.ShowAllBySalespriceService;

public class ShowAllBySalespriceView extends JFrame {

	private JPanel contentPane;
	private ShowAllBySalespriceService service;
	private ShowAllBySalespriceList pList;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllBySalespriceView frame = new ShowAllBySalespriceView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ShowAllBySalespriceView() {
		service=new ShowAllBySalespriceService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pList=new ShowAllBySalespriceList(service);
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);
	}

}
