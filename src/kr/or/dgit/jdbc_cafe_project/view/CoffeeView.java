package kr.or.dgit.jdbc_cafe_project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.jdbc_cafe_project.content.CoffeeContent;

public class CoffeeView extends JFrame {

	private JPanel contentPane;


	public CoffeeView() {
		setTitle("메뉴 추가");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		CoffeeContent panel = new CoffeeContent();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
