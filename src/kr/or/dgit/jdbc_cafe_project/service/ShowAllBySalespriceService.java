package kr.or.dgit.jdbc_cafe_project.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dao.ShowAllBySalespriceDao;
import kr.or.dgit.jdbc_cafe_project.dao.SqlDao;
import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;

public class ShowAllBySalespriceService {
	private SqlDao<ShowAllBySalesprice> showAllBySalesprice;

	public List<ShowAllBySalesprice> selectShowByAll() {
		ShowAllBySalespriceDao dao = ShowAllBySalespriceDao.getInstance();

		try {
			List<ShowAllBySalesprice> lists = dao.selectItemByAll();

			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
