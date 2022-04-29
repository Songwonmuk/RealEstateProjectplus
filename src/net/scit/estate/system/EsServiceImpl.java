package net.scit.estate.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.scit.estate.vo.RealEstate;

public class EsServiceImpl implements EsService {
	Scanner sc = new Scanner(System.in);
	// ArrayList ���� : List<������ Ÿ��> ������ = new ArrayList<������ Ÿ��>();
	List<RealEstate> esList = new ArrayList<RealEstate>();
	RealEstate estate = new RealEstate();

	@Override
	public int regist(RealEstate re) {
		boolean result = esList.add(re);
		if (result)
			return 1;
		return 0; // public�� void Ÿ�� ������ ����
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

	// ��ü ����
	public List<RealEstate> selectAll() {
		return esList;
	}

	// set(int index, E element)
	public void update(RealEstate re) {
		int no = searchAdd(re.getAddress());

		if (no == -1)
			return;
		esList.set(no, re);

		System.out.println("������ �Ϸ�Ǿ����ϴ�");
		return;
	}

	public void delete(String address) {
		int no = searchAdd(address);
		if (no == -1)
			return;
		esList.remove(no);
		System.out.println("���� ���� �Ǿ����ϴ�");
		return;
	}

	// ���޹��� address �̿��� esList���� �����͸� ã�� ��ġ�� ����
	public int searchAdd(String address) {
		for (int i = 0; i < esList.size(); ++i) {
			RealEstate rs = esList.get(i);
			if (rs.getAddress().equals(address)) {
				return i; // �ε��� ��
			}
		}
		return -1; // ��ã���� ��
	}
}
