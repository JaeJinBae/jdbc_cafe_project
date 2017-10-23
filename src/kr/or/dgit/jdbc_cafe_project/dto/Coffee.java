package kr.or.dgit.jdbc_cafe_project.dto;

public class Coffee {
	String code;
	String name;
	int cost;
	int salesamount;
	int percentmargin;
	
	public Coffee() {
	}
	
	public Coffee(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Coffee(String code, String name, int cost, int salesamount, int percentmargin) {
		this.code = code;
		this.name = name;
		this.cost = cost;
		this.salesamount = salesamount;
		this.percentmargin = percentmargin;
	}

	public Coffee(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(int salesamount) {
		this.salesamount = salesamount;
	}

	public int getPercentmargin() {
		return percentmargin;
	}

	public void setPercentmargin(int percentmargin) {
		this.percentmargin = percentmargin;
	}

	

	@Override
	public String toString() {
		return String.format("%s (%s)", code, name);
	}
	
	
	
	
	
}
