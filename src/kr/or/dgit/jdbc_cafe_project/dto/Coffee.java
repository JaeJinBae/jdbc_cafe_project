package kr.or.dgit.jdbc_cafe_project.dto;

public class Coffee {
	String code;
	String name;
	String cost;
	String salesamount;
	String percentmargin;
	
	public Coffee() {
	}
	
	public Coffee(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Coffee(String code, String name, String cost, String salesamount, String percentmargin) {
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(String salesamount) {
		this.salesamount = salesamount;
	}

	public String getPercentmargin() {
		return percentmargin;
	}

	public void setPercentmargin(String percentmargin) {
		this.percentmargin = percentmargin;
	}

	

	@Override
	public String toString() {
		return String.format("%s (%s)", code, name);
	}
	
	
	
	
	
}
