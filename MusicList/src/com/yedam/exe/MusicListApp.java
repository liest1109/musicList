package com.yedam.exe;

import java.util.Scanner;

import com.yedam.MusicList.MusicService;
import com.yedam.member.MemberService;
import com.yedam.game.GameService;

public class MusicListApp {
	
	Scanner sc =new Scanner(System.in);
	boolean run = true;
	MemberService ms = new MemberService();
	MusicService mu = new MusicService();
	GameService gs = new GameService();

	
	public MusicListApp() {
		start();
	}
	
	private void start() {
		while (run) {
			if(MemberService.memberInfo != null) {
				loginMenu();
			}else if (MemberService.memberInfo == null) {
				logoutMenu();
			}
		}
	}
	
	//로그아웃 메뉴
	private void logoutMenu() {
		System.out.println(" 1. 로그인 | 2. 회원가입 | 3. 사용 종료 ");
		System.out.println("번호를 입력해주세요");
		String menuNum = sc.nextLine();
		if (menuNum.equals("1")) {
			ms.login();
		} else if (menuNum.equals("2")) {
			ms.insertMember();
		} else if (menuNum.equals("3")) {
			run = false;
			System.out.println("사용을 종료합니다");
		}else if (menuNum.equals("4")) {
			
			mu.getGameMusic();
			gs.insertScore();
			
		} else {
			System.out.println(" 정확한 번호를 입력해 주세요 ");
		}
	}
	
	//로그인 메뉴
	private void loginMenu() {
		System.out.println(" 1. Music List | 2. 회원 정보 | 3. Game | 4. 로그아웃 ");
		System.out.println("번호를 입력해주세요 > ");
		String menu = sc.nextLine();
		if (menu.equals("1")) {
			new ListApp();
			
		} else if (menu.equals("2")) {
			new MyApp();
			
		} else if (menu.equals("3")) {
			new GameApp();
			
		} else if (menu.equals("4")) {

			MemberService.memberInfo = null;

		} else {
			System.out.println("정확한 번호를 입력해 주세요");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
