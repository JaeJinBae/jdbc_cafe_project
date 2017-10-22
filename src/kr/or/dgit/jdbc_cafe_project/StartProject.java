package kr.or.dgit.jdbc_cafe_project;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_cafe_project.dao.CoffeeDao;
import kr.or.dgit.jdbc_cafe_project.dto.Coffee;
import kr.or.dgit.jdbc_cafe_project.view.ShowAllByMargincostView;
import kr.or.dgit.jdbc_cafe_project.view.ShowAllBySalespriceView;

public class StartProject extends JFrame {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfName;
	private JTextField tfCost;
	private JTextField tfSalesPrice;
	private JTextField tfPercentMargin;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartProject frame = new StartProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StartProject() {
		setTitle("Cafe Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblCode = new JLabel("제품코드");
		panel.add(lblCode);
		
		tfCode = new JTextField();
		panel.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblName = new JLabel("제품명");
		panel_1.add(lblName);
		
		tfName = new JTextField();
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblCost = new JLabel("제품단가");
		panel_2.add(lblCost);
		
		tfCost = new JTextField();
		panel_2.add(tfCost);
		tfCost.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JLabel lblSalesPrice = new JLabel("판매수량");
		panel_3.add(lblSalesPrice);
		
		tfSalesPrice = new JTextField();
		panel_3.add(tfSalesPrice);
		tfSalesPrice.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JLabel lblPercentMargin = new JLabel("마진율");
		panel_4.add(lblPercentMargin);
		
		tfPercentMargin = new JTextField();
		panel_4.add(tfPercentMargin);
		tfPercentMargin.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContent();
				CoffeeDao coffeeDao=new CoffeeDao();
				try {
					coffeeDao.insertItem(getContent());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_5.add(btnInsert);
		
		JButton btnShow1 = new JButton("판매액 순위로 보기");
		btnShow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllBySalespriceView sabspv=new ShowAllBySalespriceView();
				sabspv.setVisible(true);
			}
		});
		panel_5.add(btnShow1);
		
		JButton btnShow2 = new JButton("마진액 순위로 보기");
		btnShow2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllByMargincostView sabmcv=new ShowAllByMargincostView();
				sabmcv.setVisible(true);
			}
		});
		panel_5.add(btnShow2);
	}
	private Coffee getContent() {
		String coffeeCode=tfCode.getText().trim();
		String coffeeName=tfName.getText().trim();
		int coffeeCost=Integer.parseInt(tfCost.getText().trim());
		int coffeeSalesprice=Integer.parseInt(tfSalesPrice.getText().trim());
		int coffeePercentmargin=Integer.parseInt(tfPercentMargin.getText().trim());
		return new Coffee(coffeeCode, coffeeName, coffeeCost, coffeeSalesprice, coffeePercentmargin);	
	}
	
}
