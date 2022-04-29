package net.scit.estate.vo;

public class RealEstate {

	private String address;
	private String houseType;
	private int size;
	
	//c
	public RealEstate() {
		super();
	}

	//o
	public RealEstate(String address, String houseType, int size) {
		super();
		this.address = address;
		this.houseType = houseType;
		this.size = size;
	}

	//r
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	//s
	@Override
	public String toString() {
		return "林家 : " + address + ", 林芭屈怕 : " + houseType + ", 农扁 : " + size;
	}
	
	//
	public String getInfo() {
		return null;
	}
	
	
	
}
