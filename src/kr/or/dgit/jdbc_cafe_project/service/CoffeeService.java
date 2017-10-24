package kr.or.dgit.jdbc_cafe_project.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_cafe_project.dao.CoffeeDao;
import kr.or.dgit.jdbc_cafe_project.dto.Coffee;

public class CoffeeService {
	private CoffeeDao coffeeDao;
	
	public CoffeeService() {
		this.coffeeDao=CoffeeDao.getInstance();
	}

	public void updateCoffee(Coffee coffee){
		try {
			coffeeDao.updateItem(coffee);
			JOptionPane.showMessageDialog(null, "수정완료");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public List<Coffee> selectCoffeeByAll() {
		try {
			return coffeeDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Coffee selectItemByCode(Object object){
		try {
			return coffeeDao.selectItemByCode((Coffee) object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
