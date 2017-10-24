package kr.or.dgit.jdbc_cafe_project.dto;

public class Goods {
	String goodscode;
	String supplycost;
	String tax;
	String salesprice;
	String margincost;
	
	
	
	public Goods() {
	}

	public Goods(String goodscode, String supplycost, String tax, String salesprice, String margincost) {
		this.goodscode = goodscode;
		this.supplycost = supplycost;
		this.tax = tax;
		this.salesprice = salesprice;
		this.margincost = margincost;
	}

	public Goods(String goodscode) {
		this.goodscode = goodscode;
	}

	
	
	
	public String getGoodscode() {
		return goodscode;
	}

	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}

	public String getSupplycost() {
		return supplycost;
	}

	public void setSupplycost(String supplycost) {
		this.supplycost = supplycost;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getSalesprice() {
		return salesprice;
	}

	public void setSalesprice(String salesprice) {
		this.salesprice = salesprice;
	}

	public String getMargincost() {
		return margincost;
	}

	public void setMargincost(String margincost) {
		this.margincost = margincost;
	}

	@Override
	public String toString() {
		return String.format("Goods [goodscode=%s, supplycost=%s, tax=%s, salesprice=%s, margincost=%s]", goodscode,
				supplycost, tax, salesprice, margincost);
	}
	
	
	
}
