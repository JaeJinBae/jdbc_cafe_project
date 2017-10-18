package kr.or.dgit.jdbc_cafe_project.dao;

import java.sql.SQLException;
import java.util.List;

public interface SqlDao<T> {
	void insertItem(T item)throws SQLException;
	T selectItemByCode(T item) throws SQLException;
	List<T> selectItemByAll() throws SQLException;
}
