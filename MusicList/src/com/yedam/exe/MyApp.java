package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class MyApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	public MyApp() {
		run();
	}
	
	private void run() {
		boolean myIn = true;
		while(myIn) {
			myinfo();
			String menuNo = sc.nextLine();
			
			switch (menuNo) {
			case "1" :
				ms.myInfo();
				break;
			case "2" :
				updateInfo();
				String menuNu = sc.nextLine();
				boolean myin2 = true;
				while(myin2) {
					
					switch (menuNu) {
					case "1" :
						ms.updatePw();
						myin2 = false;
						break;
					case "2" :
						ms.updateName();
						myin2 = false;
						break;
					case "3" :
						myin2 = false;
						break;
					}
				}
				
				break;
			case "3" :
				ms.deleteMember();
				break;
			case "4" :
				myIn = false;
				break;			

			}
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	private void myinfo() {
		System.out.println(" ");
		System.out.println("1. 내 정보 조회 | 2. 내 정보 수정 | 3. 회원탈퇴 | 4. 뒤로 가기");
	}
	
	private void updateInfo() {
		System.out.println(" ");
		System.out.println("1. 비밀번호 변경 | 2. 닉네임 변경 | 3.뒤로가기 ");
	}
}
