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
				showview=getShow(rs);
			}
		}
	}
		return showview;
	}

	@Override
	public List<ShowAllByMargincost> selectItemByAll() throws SQLException {
		List<ShowAllByMargincost> lists=new ArrayList<>();
		String sql="select * from showAllByMargincost union select '합계', '', '', '', '', '',sum(supplycost), sum(tax), sum(salesprice), sum(margincost) from  showAllByMargincost";
		try (PreparedStatement pstmt=DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getShow(rs));
			}
		}
		return lists;
	}

	private ShowAllByMargincost getShow(ResultSet rs) throws SQLException {
		String showrank=rs.getString("crank");
		String showCode=rs.getString("code");
		String showName=rs.getString("name");
		String showCost=String.format("%,d", rs.getInt("cost"));
		String showSalesamount=String.format("%,d", rs.getInt("salesamount"));
		String showPercentmargin=rs.getString("percentmargin");
		String showSupplycost=String.format("%,d", rs.getInt("supplycost"));
		String showTax=String.format("%,d",rs.getInt("tax"));
		String showSalesprice=String.format("%,d", rs.getInt("salesprice"));
		String showMargincost=String.format("%,d",rs.getInt("margincost"));
		return new ShowAllByMargincost(showrank, showCode, showName, showCost, showSalesamount, showPercentmargin, showSupplycost, showTax, showSalesprice, showMargincost);
	}

	

}
