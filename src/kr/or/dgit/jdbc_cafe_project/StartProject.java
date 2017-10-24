package kr.or.dgit.jdbc_cafe_project;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_cafe_project.dao.CoffeeDao;
import kr.or.dgit.jdbc_cafe_project.dto.Coffee;
import kr.or.dgit.jdbc_cafe_project.service.CoffeeService;
import kr.or.dgit.jdbc_cafe_project.view.CoffeeView;
import kr.or.dgit.jdbc_cafe_project.view.ShowAllByMargincostView;
import kr.or.dgit.jdbc_cafe_project.view.ShowAllBySalespriceView;

public class StartProject extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfCost;
	private JTextField tfSalesPrice;
	private JTextField tfPercentMargin;
	private JButton btnAdd;
	private JComboBox comboBox;
	private CoffeeService service;

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
		setBounds(100, 100, 571, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		service=new CoffeeService();
				
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblCode = new JLabel("제품코드");
		panel.add(lblCode);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		setCoffeeCode();
		panel.add(comboBox);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblName = new JLabel("제품명");
		panel_1.add(lblName);
		
		tfName = new JTextField();
		setName();
		
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblCost = new JLabel("제품단가");
		panel_2.add(lblCost);
		
		tfCost = new JTextField();
		panel_2.add(tfCost);
		tfCost.setColumns(10);
		setCost();
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JLabel lblSalesAmount = new JLabel("판매수량");
		panel_3.add(lblSalesAmount);
		
		tfSalesPrice = new JTextField();
		panel_3.add(tfSalesPrice);
		tfSalesPrice.setColumns(10);
		setSalesAmount();
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JLabel lblPercentMargin = new JLabel("마진율");
		panel_4.add(lblPercentMargin);
		
		tfPercentMargin = new JTextField();
		panel_4.add(tfPercentMargin);
		tfPercentMargin.setColumns(10);
		setPercentMargin();
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CoffeeDao coffeeDao=new CoffeeDao();
				try {
					coffeeDao.updateItem(getContent());
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
		
		
		btnAdd = new JButton("메뉴추가");
		btnAdd.addActionListener(this);
		panel_5.add(btnAdd);
		
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
	
	
	public String getPercentMargin(Coffee item){
		return service.selectItemByCode(item).getPercentmargin();
	}
	
	public void setPercentMargin(){
		tfPercentMargin.setText(getPercentMargin((Coffee) comboBox.getSelectedItem()));
	}
	
	public String getSalesAmount(Coffee item){
		return service.selectItemByCode(item).getCost();
	}
	
	public void setSalesAmount(){
		tfSalesPrice.setText(getSalesAmount((Coffee) comboBox.getSelectedItem()));
	}
	
	public String getCost(Coffee item){
		return service.selectItemByCode(item).getCost();
	}
	
	public void setCost(){
		tfCost.setText(getCost((Coffee) comboBox.getSelectedItem()));
	}
	
	public String getName(Coffee item){
		return service.selectItemByCode(item).getName();
	}
	
	public void setName(){
		tfName.setText(getName((Coffee) comboBox.getSelectedItem()));
	}
	
	public Coffee getContent() {
		Coffee coffeeCode=(Coffee) comboBox.getSelectedItem();
		String coffeeName=tfName.getText().trim();
		String coffeeCost=tfCost.getText().trim();
		String coffeeSalesprice=tfSalesPrice.getText().trim();
		String coffeePercentmargin=tfPercentMargin.getText().trim();
		return new Coffee(coffeeCode.getCode(), coffeeName, coffeeCost, coffeeSalesprice, coffeePercentmargin);	
	}
	
	public void setCoffeeCode(){
		List<Coffee> lists = service.selectCoffeeByAll();
		Vector<Coffee> coffees = new Vector<>(lists);
		ComboBoxModel<Coffee> model = new DefaultComboBoxModel<>(coffees);
		comboBox.setModel(model);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			do_comboBox_actionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			do_btnAdd_actionPerformed(e);
		}
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		CoffeeView coffeeview=new CoffeeView();
		coffeeview.setVisible(true);
	}
	
	
	protected void do_comboBox_actionPerformed(ActionEvent e) {
		setName();
		setCost();
		setSalesAmount();
		setPercentMargin();
	}
}
