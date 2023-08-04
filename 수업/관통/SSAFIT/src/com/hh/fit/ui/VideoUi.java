package com.hh.fit.ui;

import java.util.Scanner;

import com.hh.fit.model.Video;
import com.hh.fit.model.VideoDaoImpl;

public class VideoUi {
	private VideoDaoImpl vm = VideoDaoImpl.getInstance();
	private ReviewUi ru = new ReviewUi();
	private static VideoUi instance = new VideoUi();

	private VideoUi() {
	}

	public static VideoUi getInstance() {
		return instance;
	}

	public void videoInfo(Scanner sc) {
		while (true) {
			System.out.println("--------------------------------------------------");
			System.out.println("1. 영 상 목 록");
			System.out.println("0. 종 료");
			System.out.println("--------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 0) {
				return;
			} else if (input == 1) {
				this.listVideo(sc);
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}
	}

	public void listVideo(Scanner sc) {
		while (true) {
			System.out.println("--------------------------------------------------");
			System.out.println("전체 " + vm.selectVideo().size() + "개");
			System.out.println("--------------------------------------------------");
			for (int i = 0; i < vm.selectVideo().size(); i++) {
				System.out.println(i + 1 + "   " + vm.selectVideo().get(i).getTitle());
			}
			System.out.println("--------------------------------------------------");
			System.out.println("1. 영 상 상 세");
			System.out.println("0. 종 료");
			System.out.println("--------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 0) {
				return;
			} else if (input == 1) {
				System.out.println("영상번호를 입력하세요 : ");
				int input_2 = sc.nextInt();
				detailVideo(input_2, sc);

			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}
	}

	public void detailVideo(int no, Scanner sc) {
		Video v = vm.selectVideoByNo(no);
		if (v == null) {
			System.out.println("해당 번호의 영상이 존재하지 않습니다!");
			return;
		}
		while (true) {
			System.out.println("--------------------------------------------------");
			System.out.println("번호 : " + v.getNo());
			System.out.println("제목 : " + v.getTitle());
			System.out.println("운동 : " + v.getPart());
			System.out.println("영상 URL : " + v.getUrl());
			System.out.println("--------------------------------------------------");
			ru.listReview(no);
			System.out.println("--------------------------------------------------");
			System.out.println("1. 리 뷰 등 록");
			System.out.println("0. 종 료");
			System.out.println("--------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 0) {
				return;
			
			} else if (input == 1) {
				System.out.print("닉네임을 입력하세요 : ");
				String nickName = sc.nextLine();
				System.out.print("내용을 입력하세요 : ");
				String content = sc.nextLine();
				ru.registerReview(no, nickName, content);
//				sc.nextLine();
			}
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}

	}

}
