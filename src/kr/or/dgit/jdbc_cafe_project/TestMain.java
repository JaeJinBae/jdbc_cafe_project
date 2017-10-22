package kr.or.dgit.jdbc_cafe_project;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dao.CoffeeDao;
import kr.or.dgit.jdbc_cafe_project.dao.ShowAllByMargincostDao;
import kr.or.dgit.jdbc_cafe_project.dao.ShowAllBySalespriceDao;
import kr.or.dgit.jdbc_cafe_project.dto.Coffee;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllByMargincost;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;

public class TestMain {

	public static void main(String[] args) {
//		testInsert();
		
		testShowAllBySalesprice();
//		testShowAllByMargincost();
	}

	private static void testShowAllByMargincost() {
		ShowAllByMargincostDao dao=ShowAllByMargincostDao.getInstance();
		
		List<ShowAllByMargincost> lists;
		try {
			lists = dao.selectItemByAll();
			for (ShowAllByMargincost showview : lists) {
				System.out.println(showview);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testInsert() {
		Coffee coffee=new Coffee("B001", "딸기쉐이크", 5200, 250, 12);
		CoffeeDao dao=CoffeeDao.getInstance();
		try {
			dao.insertItem(coffee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		testShowAllBySalesprice();
	}

	private static void testShowAllBySalesprice() {
		ShowAllBySalespriceDao dao=ShowAllBySalespriceDao.getInstance();
		
		List<ShowAllBySalesprice> lists;
		try {
			lists = dao.selectItemByAll();
			for (ShowAllBySalesprice showview : lists) {
				System.out.println(showview);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
