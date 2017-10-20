package kr.or.dgit.jdbc_cafe_project.dto;

public class ShowAllByMargincost {
	int crank;
	String code;
	String name;
	int cost;
	int salesamount;
	int percentmargin;
	int supplycost;
	int tax;
	int salesprice;
	int margincost;
	
	public ShowAllByMargincost() {
	}
	
	public ShowAllByMargincost(int crank, String code, String name, int cost, int salesamount, int percentmargin, int supplycost,
			int tax, int salesprice, int margincost) {
		this.crank = crank;
		this.code = code;
		this.name = name;
		this.cost = cost;
		this.salesamount = salesamount;
		this.percentmargin = percentmargin;
		this.supplycost = supplycost;
		this.tax = tax;
		this.salesprice = salesprice;
		this.margincost = margincost;
	}
	
	public ShowAllByMargincost(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	@Override
	public String toString() {
		return String.format(
				"순위: %s, 제품코드: %s, 제품명: %s, 단가: %s, 판매수량: %s, 공급가액: %s, 부가세액: %s, 판매금액: %s, 마진율: %s, 마진액: %s]",
				crank, code, name, cost, salesamount, supplycost, tax, salesprice, percentmargin, margincost);
	}

	

	
	
	
}