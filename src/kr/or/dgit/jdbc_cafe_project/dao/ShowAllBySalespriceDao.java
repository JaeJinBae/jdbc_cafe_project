package kr.or.dgit.jdbc_cafe_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.stream.buffer.stax.StreamReaderBufferCreator;

import kr.or.dgit.jdbc_cafe_project.dto.ShowAllBySalesprice;
import kr.or.dgit.jdbc_cafe_project.jdbc.DBCon;

public class ShowAllBySalespriceDao implements SqlDao<ShowAllBySalesprice> {
	private static final ShowAllBySalespriceDao Instance=new ShowAllBySalespriceDao();
	
	
	public static ShowAllBySalespriceDao getInstance() {
		return Instance;
	}

	@Override
	public void insertItem(ShowAllBySalesprice item) throws SQLException {
		
	}

	@Override
	public ShowAllBySalesprice selectItemByCode(ShowAllBySalesprice item) throws SQLException {
		String sql="select * from showAllBySalesprice where code=?";
		ShowAllBySalesprice showview=null;
		
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
	public List<ShowAllBySalesprice> selectItemByAll() throws SQLException {
		String sql="select * from showAllBySalesprice union select '합계', '', '', '', '', '',sum(supplycost), sum(tax), sum(salesprice), sum(margincost) from showAllBySalesprice";
		List<ShowAllBySalesprice> sabs=new ArrayList<>();
		
		try (PreparedStatement pstmt=DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();){
			while(rs.next()){
				sabs.add(getShow(rs));
			}
		}
		return sabs;
	}

	private ShowAllBySalesprice getShow(ResultSet rs) throws SQLException {
		String showrank=rs.getString("crank");
		String showCode=rs.getString("code");
		String showName=rs.getString("name");
//		System.out.println(String.format("%,d",rs.getInt("cost")));
		String showCost=rs.getString("cost");
		String showSalesamount=rs.getString("salesamount");
		String showPercentmargin=rs.getString("percentmargin");
		String showSupplycost=rs.getString("supplycost");
		String showTax=rs.getString("tax");
		String showSalesprice=rs.getString("salesprice");
		String showMargincost=rs.getString("margincost");
		return new ShowAllBySalesprice(showrank, showCode, showName, showCost, showSalesamount, showPercentmargin, showSupplycost, showTax, showSalesprice, showMargincost);
	}

	

}
