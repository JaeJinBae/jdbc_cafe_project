package kr.or.dgit.jdbc_cafe_project;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dao.CoffeeDao;
import kr.or.dgit.jdbc_cafe_project.dao.ShowViewDao;
import kr.or.dgit.jdbc_cafe_project.dto.Coffee;
import kr.or.dgit.jdbc_cafe_project.dto.ShowView;

public class TestMain {

	public static void main(String[] args) {
		testInsert();
		
		testShowList();
		
	}

	private static void testInsert() {
		Coffee coffee=new Coffee("B001", "딸기쉐이크", 5200, 250, 12);
		CoffeeDao dao=CoffeeDao.getInstance();
		try {
			dao.insertItem(coffee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		testShowList();
	}

	private static void testShowList() {
		ShowViewDao dao=ShowViewDao.getInstance();
		
		List<ShowView> lists;
		try {
			lists = dao.selectItemByAll();
			for (ShowView showview : lists) {
				System.out.println(showview);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
