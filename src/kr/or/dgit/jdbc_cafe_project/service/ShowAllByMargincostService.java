package kr.or.dgit.jdbc_cafe_project.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dao.SqlDao;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllByMargincost;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;

public class ShowAllByMargincostService {
	private SqlDao<ShowAllByMargincost> showAllByMargincostDao;

	public List<ShowAllByMargincost> selectShowByAll() {
		try {
			return showAllByMargincostDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
