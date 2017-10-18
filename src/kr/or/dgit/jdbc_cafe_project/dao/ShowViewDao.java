package kr.or.dgit.jdbc_cafe_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dto.ShowView;
import kr.or.dgit.jdbc_cafe_project.jdbc.DBCon;

public class ShowViewDao implements SqlDao<ShowView> {
	private static final ShowViewDao Instance=new ShowViewDao();
	
	
	public static ShowViewDao getInstance() {
		return Instance;
	}

	@Override
	public void insertItem(ShowView item) throws SQLException {
		
	}

	@Override
	public ShowView selectItemByCode(ShowView item) throws SQLException {
		String sql="select * from showList where code=?";
		ShowView showview=null;
		
		try(PreparedStatement pstmt= DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getCode());
		
		try(ResultSet rs=pstmt.executeQuery();){
			if(rs.next()){
				showview=getShowView(rs);
			}
		}
	}
		return showview;
	}

	@Override
	public List<ShowView> selectItemByAll() throws SQLException {
		List<ShowView> lists=new ArrayList<>();
		String sql="select * from showList";
		try (PreparedStatement pstmt=DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getShowView(rs));
			}
		}
		return lists;
	}

	private ShowView getShowView(ResultSet rs) throws SQLException {
		int showrank=rs.getInt(1);
		String showCode=rs.getString(2);
		String showName=rs.getString(3);
		int showCost=rs.getInt(4);
		int showSalesamount=rs.getInt(5);
		int showPercentmargin=rs.getInt(6);
		int showSupplycost=rs.getInt(7);
		int showTax=rs.getInt(8);
		int showSalesprice=rs.getInt(9);
		int showMargincost=rs.getInt(10);
		return new ShowView(showrank, showCode, showName, showCost, showSalesamount, showPercentmargin, showSupplycost, showTax, showSalesprice, showMargincost);
	}

	

}
