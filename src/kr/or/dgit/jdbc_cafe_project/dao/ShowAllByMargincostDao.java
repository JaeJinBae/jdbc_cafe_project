package kr.or.dgit.jdbc_cafe_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dto.ShowAllByMargincost;
import kr.or.dgit.jdbc_cafe_project.jdbc.DBCon;

public class ShowAllByMargincostDao implements SqlDao<ShowAllByMargincost> {
	private static final ShowAllByMargincostDao Instance=new ShowAllByMargincostDao();
	
	
	public static ShowAllByMargincostDao getInstance() {
		return Instance;
	}

	@Override
	public void insertItem(ShowAllByMargincost item) throws SQLException {
		
	}

	@Override
	public ShowAllByMargincost selectItemByCode(ShowAllByMargincost item) throws SQLException {
		String sql="select * from showAllBySalesprice where code=?";
		ShowAllByMargincost showview=null;
		
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
	public List<ShowAllByMargincost> selectItemByAll() throws SQLException {
		List<ShowAllByMargincost> lists=new ArrayList<>();
		String sql="select * from showAllByMargincost";
		try (PreparedStatement pstmt=DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getShowView(rs));
			}
		}
		return lists;
	}

	private ShowAllByMargincost getShowView(ResultSet rs) throws SQLException {
		String showrank=rs.getString(1);
		String showCode=rs.getString(2);
		String showName=rs.getString(3);
		String showCost=rs.getString(4);
		String showSalesamount=rs.getString(5);
		String showPercentmargin=rs.getString(6);
		String showSupplycost=rs.getString(7);
		String showTax=rs.getString(8);
		String showSalesprice=rs.getString(9);
		String showMargincost=rs.getString(10);
		return new ShowAllByMargincost(showrank, showCode, showName, showCost, showSalesamount, showPercentmargin, showSupplycost, showTax, showSalesprice, showMargincost);
	}

	

}
