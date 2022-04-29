package net.scit.estate.vo;

public class Charter extends RealEstate{

	private int depositMoney;

	public Charter() {
		super();
	}

	public Charter(int depositMoney) {
		super();
		this.depositMoney = depositMoney;
	}
	
	public Charter(String address, String houseType, int size, int depositMoney) {
		super(address, houseType, size);
		this.depositMoney = depositMoney;
	}

	public int getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(int depositMoney) {
		this.depositMoney = depositMoney;
	}

	
	@Override
	public String getInfo() {
		return "Charter";
	}

	@Override
	public String toString() {
		return super.toString() + ", 임대 보증금 : " + depositMoney;
	}
	
	
	
}
