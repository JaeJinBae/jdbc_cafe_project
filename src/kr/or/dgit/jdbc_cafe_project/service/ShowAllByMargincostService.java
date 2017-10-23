package kr.or.dgit.jdbc_cafe_project.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dao.ShowAllByMargincostDao;
import kr.or.dgit.jdbc_cafe_project.dao.SqlDao;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllByMargincost;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;

public class ShowAllByMargincostService {
	private SqlDao<ShowAllByMargincost> showAllByMargincost;

	public List<ShowAllByMargincost> selectShowByAll() {
		ShowAllByMargincostDao dao=ShowAllByMargincostDao.getInstance();
		try {
			List<ShowAllByMargincost> lists=dao.selectItemByAll();
			return dao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
