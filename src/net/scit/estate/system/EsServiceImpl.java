package net.scit.estate.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.scit.estate.vo.RealEstate;

public class EsServiceImpl implements EsService {
	Scanner sc = new Scanner(System.in);
	// ArrayList 생성 : List<데이터 타입> 변수명 = new ArrayList<데이터 타입>();
	List<RealEstate> esList = new ArrayList<RealEstate>();
	RealEstate estate = new RealEstate();

	@Override
	public int regist(RealEstate re) {
		boolean result = esList.add(re);
		if (result)
			return 1;
		return 0; // public의 void 타입 설정과 연관
	}

	@Override
	public RealEstate selectOne(String address) {
		RealEstate re = null;

		for (RealEstate temp : esList) {
			if (temp.getAddress().equals(address)) {
				re = temp;
				break;
			}
		}
		return re;
	}

	// 전체 선택
	public List<RealEstate> selectAll() {
		return esList;
	}

	// set(int index, E element)
	public void update(RealEstate re) {
		int no = searchAdd(re.getAddress());

		if (no == -1)
			return;
		esList.set(no, re);

		System.out.println("수정이 완료되었습니다");
		return;
	}

	public void delete(String address) {
		int no = searchAdd(address);
		if (no == -1)
			return;
		esList.remove(no);
		System.out.println("정상 삭제 되었습니다");
		return;
	}

	// 전달받은 address 이용해 esList에서 데이터를 찾아 위치값 리턴
	public int searchAdd(String address) {
		for (int i = 0; i < esList.size(); ++i) {
			RealEstate rs = esList.get(i);
			if (rs.getAddress().equals(address)) {
				return i; // 인덱스 값
			}
		}
		return -1; // 못찾았을 때
	}
}
