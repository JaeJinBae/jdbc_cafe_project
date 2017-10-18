package kr.or.dgit.jdbc_cafe_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_cafe_project.dto.Coffee;
import kr.or.dgit.jdbc_cafe_project.jdbc.DBCon;

public class CoffeeDao implements SqlDao<Coffee> {
	private static final CoffeeDao Instance=new CoffeeDao();
	
	public static CoffeeDao getInstance() {
		return Instance;
	}

	@Override
	public void insertItem(Coffee item) throws SQLException {
		String sql="insert into coffee values(?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt=DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.setInt(3, item.getCost());
			pstmt.setInt(4, item.getSalesamount());
			pstmt.setInt(5, item.getPercentmargin());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Coffee selectItemByCode(Coffee item) throws SQLException {
		String sql="select * from coffee where code=?";
		Coffee coffee=null;
		
		try(PreparedStatement pstmt= DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getCode());
		
		try(ResultSet rs=pstmt.executeQuery();){
			if(rs.next()){
				coffee=getCoffee(rs);
			}
		}
	}
		return coffee;
	}

	

	@Override
	public List<Coffee> selectItemByAll() throws SQLException {
		List<Coffee> lists=new ArrayList<>();
		String sql="select * from coffee";
		try (PreparedStatement pstmt=DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getCoffee(rs));
			}
		}
		return lists;
	}
	
	private Coffee getCoffee(ResultSet rs) throws SQLException {
		String coffeeCode=rs.getString(2);
		String coffeeName=rs.getString(3);
		int coffeeCost=rs.getInt(4);
		int cofeeSalesamount=rs.getInt(5);
		int coffeePercentmargin=rs.getInt(6);
		return new Coffee(coffeeCode, coffeeName, coffeeCost, cofeeSalesamount, coffeePercentmargin);
	}
}
