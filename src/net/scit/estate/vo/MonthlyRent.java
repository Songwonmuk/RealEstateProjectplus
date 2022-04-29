package net.scit.estate.vo;

public class MonthlyRent extends RealEstate{

	private int monthlyRent;

	public MonthlyRent() {
		super();
	}

	public MonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	
	public MonthlyRent(String address, String houseType, int size, int monthlyRent) {
		super(address, houseType, size);
		this.monthlyRent = monthlyRent;
	}

	public int getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	
	@Override
	public String getInfo() {
		return "MonthlyRent";
	}

	@Override
	public String toString() {
		return super.toString() + ", 월임대료 : " + monthlyRent;
	}
	
	
}
