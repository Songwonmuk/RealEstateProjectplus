package net.scit.estate.system;

import java.util.List;

import net.scit.estate.vo.RealEstate;

public interface EsService {

	public int regist (RealEstate re);
	
	public RealEstate selectOne(String address);
	
	public List<RealEstate> selectAll();
	
	public void update (RealEstate re);
	
	public void delete (String address);
	
}
