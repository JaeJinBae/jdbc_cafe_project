package kr.or.dgit.jdbc_cafe_project.content;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_cafe_project.dao.CoffeeDao;
import kr.or.dgit.jdbc_cafe_project.dto.Coffee;
import kr.or.dgit.jdbc_cafe_project.service.CoffeeService;

public class CoffeeContent extends JPanel implements ActionListener {
	private JTextField tfCode;
	private JTextField tfName;
	private JButton btnAdd;
	private JButton btnCancel;
	

	public CoffeeContent() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("제품코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCode);
		
		tfCode = new JTextField();
		add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblName = new JLabel("제품 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);
		
		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		add(btnCancel);

	}
	
	public Coffee getContent() {
		String coffeeCode=tfCode.getText().trim();
		String coffeeName=tfName.getText().trim();
		
		return new Coffee(coffeeCode, coffeeName);	
	}
	
	public void clear(){
		tfCode.setText("");
		tfName.setText("");
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			do_btnAdd_actionPerformed(e);
		}
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		getContent();
		CoffeeDao coffeedao=new CoffeeDao();
		try {
			coffeedao.addItem(getContent());
			clear();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		clear();
	}
}
