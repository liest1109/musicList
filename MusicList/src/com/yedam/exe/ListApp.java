package com.yedam.exe;

import java.util.Scanner;

import com.yedam.MusicList.MusicService;
import com.yedam.member.MemberService;

public class ListApp {
	Scanner sc = new Scanner(System.in);
	MusicService ms = new MusicService();
	
	public ListApp() {
		listappRun();
	}
	
	private void listappRun() {
		boolean list = true;
		while (list) {
			System.out.println(" ");
			menu();
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1" :
				ms.getMusicList();
				break;
			case "2" :
				ms.insertMusic();
				break;
			case "3" :
				ms.updateSinger();
				break;
			case "4" :
				ms.deleteMusic();
				break;
			case "5" :
				System.out.println(" ");
				list = false;
				break;
			}
		}
	}
	
	private void menu() {
		System.out.println(" 1. Music List 목록 | 2. Music List 추가 | 3. Music List 수정 | 4.  Music List 삭제 | 5. 뒤로가기 ");
	}
	
	
	
}
