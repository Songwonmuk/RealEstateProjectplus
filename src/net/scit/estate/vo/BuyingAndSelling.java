package net.scit.estate.vo;

public class BuyingAndSelling extends RealEstate {

	private int price;

	
	public BuyingAndSelling() {
		super();
	}

	public BuyingAndSelling(int price) {
		super();
		this.price = price;
	}
	
	
	public BuyingAndSelling(String address, String houseType, int size, int price) {
		super(address, houseType, size);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//v
	@Override
	public String getInfo() {
		return "BuyingAndSelling";
		//���߳�̸���
	}

	@Override
	//����
//	public String toString() {
//		return "BuyingAndSelling [price=" + price + "]";
//	}
	
	//���� ��ģ ��
	public String toString() {
		return super.toString() + ", �ŸŰ��� : " + price;
		
	}
	
}
