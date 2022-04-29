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
				System.out.println("종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void menu() {
		System.out.println("========================");
		System.out.println("부동산 중계 관리 시스템");
		System.out.println("========================");
		System.out.println("1. 등록");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 삭제(거래완료)");
		System.out.println("5. 전체출력");
		System.out.println("9. 종료");
		System.out.println("========================");
		System.out.print("메뉴 번호를 선택하세요 => ");
	}

	public void submenu() {
		System.out.println("========================");
		System.out.println("부동산 매물 정보 등록");
		System.out.println("========================");
		System.out.println("1. 매매");
		System.out.println("2. 전세");
		System.out.println("3. 월세");
		System.out.println("4. 상위메뉴");
		System.out.println("========================");
		System.out.print("메뉴 번호를 선택하세요 => ");
	}

	public void input() {
		String choice;
		while (true) {
			submenu();
			choice = sc.next();
			switch (choice) {
			// BuyingAndSelling 매매 매물 등록
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
				System.out.println("잘못 선택하셨습니다.");
			}
		}
	}

	public void searchingMenu() {
		System.out.println("========================");
		System.out.println("부동산 중계 관리 시스템");
		System.out.println("========================");
		System.out.println("0.주소로 검색");
		System.out.println("1.매매 물건 검색");
		System.out.println("2.전세 물건 검색");
		System.out.println("3.월세 물건 검색");
		System.out.println("4.상위메뉴");
		System.out.println("========================");
		System.out.print("메뉴 번호를 선택하세요=>");
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
				System.out.println("검색하실 주소를 입력하세요");
				address = sc.next();
				System.out.println(es.selectOne(address));
				break;
			case "1":
				System.out.println("매매 물건 전체 출력");
				for (RealEstate printByInfo : esList) {
					if(printByInfo instanceof BuyingAndSelling)
					System.out.println(printByInfo);
				}				
				break;
			case "2":
				System.out.println("전세 물건 전체 출력");
				for (RealEstate printByInfo : esList) {
					if(printByInfo instanceof Charter)
					System.out.println(printByInfo);
				}			
				break;
			case "3":
				System.out.println("월세 물건 전체 출력");
				for (RealEstate printByInfo : esList) {
					if(printByInfo instanceof MonthlyRent)
					System.out.println(printByInfo);
				}			
				break;
			case "4":
				return;
			default:
				System.out.println("잘못 입력 하셨습니다.");

			}
		}
	}

	public void update() {
		int price, monthlyRent, depositMoney;

		System.out.println("|수정 물건의 주소|");
		String address = sc.next();

		RealEstate estate = es.selectOne(address);
		if (estate instanceof BuyingAndSelling) {
			System.out.println("매매가격 : ");
			price = sc.nextInt();
			((BuyingAndSelling) estate).setPrice(price);
		} else if (estate instanceof Charter) {
			System.out.println("임대 보증금 : ");
			depositMoney = sc.nextInt();
			((Charter) estate).setDepositMoney(depositMoney);
		} else if (estate instanceof MonthlyRent) {
			System.out.println("월 임대료 : ");
			monthlyRent = sc.nextInt();
			((MonthlyRent) estate).setMonthlyRent(monthlyRent);
		}

	}

	private void delete() {
		String del, answer;
		System.out.print("|삭제 물건의 주소|");
		del = sc.next();

		RealEstate real = es.selectOne(del);
		if (real == null) {
			System.out.println("해당 항목이 없습니다");
			return;
		} else {
			System.out.println("정말 삭제하시겠습니까?");
			answer = sc.next();

			if (answer.equals("y")) {
				es.delete(del);
				return;
			}
		}
		System.out.println("작업이 취소되었습니다");
	}

	// 전체 출력
	private void output() {
		System.out.println("***전체 출력***");
		List<RealEstate> esList = es.selectAll();

		for (RealEstate estatePrint : esList) {
			System.out.println(estatePrint);
		}
	}

	private BuyingAndSelling registBuygAndSelling() {
		System.out.println("주소를 입력하세요");
		String address = sc.next();
		System.out.println("주거형태를 입력하세요");
		String houseType = sc.next();
		System.out.println("크기를 입력하세요");
		int size = sc.nextInt();
		System.out.println("매매 가격을 입력하세요");
		int price = sc.nextInt();

		return new BuyingAndSelling(address, houseType, size, price);
	}

	private Charter registCharter() {
		System.out.println("주소를 입력하세요");
		String address = sc.next();
		System.out.println("주거형태를 입력하세요");
		String houseType = sc.next();
		System.out.println("크기를 입력하세요");
		int size = sc.nextInt();
		System.out.println("매매 가격을 입력하세요");
		int depositMoney = sc.nextInt();

		return new Charter(address, houseType, size, depositMoney);
	}

	private MonthlyRent registMonthlyRent() {
		System.out.println("주소를 입력하세요");
		String address = sc.next();
		System.out.println("주거형태를 입력하세요");
		String houseType = sc.next();
		System.out.println("크기를 입력하세요");
		int size = sc.nextInt();
		System.out.println("매매 가격을 입력하세요");
		int monthlyRent = sc.nextInt();

		return new MonthlyRent(address, houseType, size, monthlyRent);

	}

}