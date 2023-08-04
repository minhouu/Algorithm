package com.hh.fit.ui;

import java.util.Scanner;

public class MainUi {
	public static void service() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("--------------------------------------------------");
			System.out.println("자바로 구현하는 SSAFIT");
			System.out.println("--------------------------------------------------");
			System.out.println("1. 영 상 정 보");
			System.out.println("0. 종 료");
			System.out.println("--------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 0) {
				System.out.println("--------------------------------------------------");
				System.out.println("프로그램이 종료됩니다");
				break;
			} else if (input == 1) {
				VideoUi videoUi = VideoUi.getInstance();
				videoUi.videoInfo(sc);
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}

		}
		sc.close();
	}
}
