package kr.or.dgit.jdbc_cafe_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "입력 완료!");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "입력실패 중복 되는지 확인하세요");
		}
	}
	
	public void updateItem(Coffee item) throws SQLException {
		String sql = "update coffee set cost=?, salesamount=?, percentmargin=? where code=?";
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getCost());
			pstmt.setInt(2, item.getSalesamount());
			pstmt.setInt(3, item.getPercentmargin());
			pstmt.setString(4, item.getCode());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "수정완료");
		}catch (SQLException e) {
			System.err.printf("%s", e.getMessage());
		}
	}
	
	public void addItem(Coffee item) throws SQLException{
		String sql="insert into coffee (code, name) values (?, ?)";
		try(PreparedStatement pstmt =DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "추가 완료!");
		}catch(SQLException e){
			System.err.printf("%s", e.getErrorCode());
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
		String coffeeCode=rs.getString("code");
		String coffeeName=rs.getString("name");
		int coffeeCost=rs.getInt("cost");
		int cofeeSalesamount=rs.getInt("salesamount");
		int coffeePercentmargin=rs.getInt("percentmargin");
		return new Coffee(coffeeCode, coffeeName, coffeeCost, cofeeSalesamount, coffeePercentmargin);
	}
}
