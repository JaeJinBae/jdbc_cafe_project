package kr.or.dgit.jdbc_cafe_project.dto;

public class Goods {
	String goodscode;
	int supplycost;
	int tax;
	int salesprice;
	int margincost;
	
	
	
	public Goods() {
	}

	public Goods(String goodscode, int supplycost, int tax, int salesprice, int margincost) {
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

	public int getSupplycost() {
		return supplycost;
	}

	public void setSupplycost(int supplycost) {
		this.supplycost = supplycost;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getSalesprice() {
		return salesprice;
	}

	public void setSalesprice(int salesprice) {
		this.salesprice = salesprice;
	}

	public int getMargincost() {
		return margincost;
	}

	public void setMargincost(int margincost) {
		this.margincost = margincost;
	}

	@Override
	public String toString() {
		return String.format("Goods [goodscode=%s, supplycost=%s, tax=%s, salesprice=%s, margincost=%s]", goodscode,
				supplycost, tax, salesprice, margincost);
	}
	
	
	
}
