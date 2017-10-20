package kr.or.dgit.jdbc_cafe_project.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dao.SqlDao;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;

public class ShowAllBySalespriceService {
	private SqlDao<ShowAllBySalesprice> showAllBySalespriceDao;
	public List<ShowAllBySalesprice> selectShowByAll(){
		try {
			return showAllBySalespriceDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
