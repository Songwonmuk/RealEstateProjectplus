package net.scit.estate.ui;

import java.util.List;
import java.util.Scanner;

import net.scit.estate.system.EsServiceImpl;
import net.scit.estate.vo.BuyingAndSelling;
import net.scit.estate.vo.Charter;
import net.scit.estate.vo.MonthlyRent;
import net.scit.estate.vo.RealEstate;

public class EsServiceUI {
	Scanner sc = new Scanner(System.in);
	EsServiceImpl es = new EsServiceImpl();

	public EsServiceUI() {
		String choice;

		while (true) {
			menu();
			choice = sc.next();

			switch (choice) {
			case "1":
				input();
				break;
			case "2":
				select();
				break;
			case "3":
				update();
				break;
			case "4":
				delete();
				break;
			case "5":
				output();
				break;
			case "9":
				System.out.println("����");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	public void menu() {
		System.out.println("========================");
		System.out.println("�ε��� �߰� ���� �ý���");
		System.out.println("========================");
		System.out.println("1. ���");
		System.out.println("2. �˻�");
		System.out.println("3. ����");
		System.out.println("4. ����(�ŷ��Ϸ�)");
		System.out.println("5. ��ü���");
		System.out.println("9. ����");
		System.out.println("========================");
		System.out.print("�޴� ��ȣ�� �����ϼ��� => ");
	}

	public void submenu() {
		System.out.println("========================");
		System.out.println("�ε��� �Ź� ���� ���");
		System.out.println("========================");
		System.out.println("1. �Ÿ�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. �����޴�");
		System.out.println("========================");
		System.out.print("�޴� ��ȣ�� �����ϼ��� => ");
	}

	public void input() {
		String choice;
		while (true) {
			submenu();
			choice = sc.next();
			switch (choice) {
			// BuyingAndSelling �Ÿ� �Ź� ���
			case "1":
				es.regist(registBuygAndSelling());
				break;
			case "2":
				es.regist(registCharter());
				break;
			case "3":
				es.regist(registMonthlyRent());
				break;
			case "4":
				return;

			default:
				System.out.println("�߸� �����ϼ̽��ϴ�.");
			}
		}
	}

	public void searchingMenu() {
		System.out.println("========================");
		System.out.println("�ε��� �߰� ���� �ý���");
		System.out.println("========================");
		System.out.println("0.�ּҷ� �˻�");
		System.out.println("1.�Ÿ� ���� �˻�");
		System.out.println("2.���� ���� �˻�");
		System.out.println("3.���� ���� �˻�");
		System.out.println("4.�����޴�");
		System.out.println("========================");
		System.out.print("�޴� ��ȣ�� �����ϼ���=>");
	}

	public void select() {
		String choice;
		String address;
		List<RealEstate> esList = es.selectAll();
		
		while (true) {
			searchingMenu();
			choice = sc.next();
			switch (choice) {
			case "0":
				System.out.println("�˻��Ͻ� �ּҸ� �Է��ϼ���");
				address = sc.next();
				System.out.println(es.selectOne(address));
				break;
			case "1":
				System.out.println("�Ÿ� ���� ��ü ���");
				for (RealEstate printByInfo : esList) {
					if(printByInfo instanceof BuyingAndSelling)
					System.out.println(printByInfo);
				}				
				break;
			case "2":
				System.out.println("���� ���� ��ü ���");
				for (RealEstate printByInfo : esList) {
					if(printByInfo instanceof Charter)
					System.out.println(printByInfo);
				}			
				break;
			case "3":
				System.out.println("���� ���� ��ü ���");
				for (RealEstate printByInfo : esList) {
					if(printByInfo instanceof MonthlyRent)
					System.out.println(printByInfo);
				}			
				break;
			case "4":
				return;
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");

			}
		}
	}

	public void update() {
		int price, monthlyRent, depositMoney;

		System.out.println("|���� ������ �ּ�|");
		String address = sc.next();

		RealEstate estate = es.selectOne(address);
		if (estate instanceof BuyingAndSelling) {
			System.out.println("�ŸŰ��� : ");
			price = sc.nextInt();
			((BuyingAndSelling) estate).setPrice(price);
		} else if (estate instanceof Charter) {
			System.out.println("�Ӵ� ������ : ");
			depositMoney = sc.nextInt();
			((Charter) estate).setDepositMoney(depositMoney);
		} else if (estate instanceof MonthlyRent) {
			System.out.println("�� �Ӵ�� : ");
			monthlyRent = sc.nextInt();
			((MonthlyRent) estate).setMonthlyRent(monthlyRent);
		}

	}

	private void delete() {
		String del, answer;
		System.out.print("|���� ������ �ּ�|");
		del = sc.next();

		RealEstate real = es.selectOne(del);
		if (real == null) {
			System.out.println("�ش� �׸��� �����ϴ�");
			return;
		} else {
			System.out.println("���� �����Ͻðڽ��ϱ�?");
			answer = sc.next();

			if (answer.equals("y")) {
				es.delete(del);
				return;
			}
		}
		System.out.println("�۾��� ��ҵǾ����ϴ�");
	}

	// ��ü ���
	private void output() {
		System.out.println("***��ü ���***");
		List<RealEstate> esList = es.selectAll();

		for (RealEstate estatePrint : esList) {
			System.out.println(estatePrint);
		}
	}

	private BuyingAndSelling registBuygAndSelling() {
		System.out.println("�ּҸ� �Է��ϼ���");
		String address = sc.next();
		System.out.println("�ְ����¸� �Է��ϼ���");
		String houseType = sc.next();
		System.out.println("ũ�⸦ �Է��ϼ���");
		int size = sc.nextInt();
		System.out.println("�Ÿ� ������ �Է��ϼ���");
		int price = sc.nextInt();

		return new BuyingAndSelling(address, houseType, size, price);
	}

	private Charter registCharter() {
		System.out.println("�ּҸ� �Է��ϼ���");
		String address = sc.next();
		System.out.println("�ְ����¸� �Է��ϼ���");
		String houseType = sc.next();
		System.out.println("ũ�⸦ �Է��ϼ���");
		int size = sc.nextInt();
		System.out.println("�Ÿ� ������ �Է��ϼ���");
		int depositMoney = sc.nextInt();

		return new Charter(address, houseType, size, depositMoney);
	}

	private MonthlyRent registMonthlyRent() {
		System.out.println("�ּҸ� �Է��ϼ���");
		String address = sc.next();
		System.out.println("�ְ����¸� �Է��ϼ���");
		String houseType = sc.next();
		System.out.println("ũ�⸦ �Է��ϼ���");
		int size = sc.nextInt();
		System.out.println("�Ÿ� ������ �Է��ϼ���");
		int monthlyRent = sc.nextInt();

		return new MonthlyRent(address, houseType, size, monthlyRent);

	}

}