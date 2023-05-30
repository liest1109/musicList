package com.yedam.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {
	
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인 기능
	public void login() {
		System.out.println("☆★ 로 그 인 ★☆");
		System.out.println("ID 를 입력하세요 >");
		String id = sc.nextLine();
		
		System.out.println("비밀번호를 입력하세요 >");
		String pw = sc.nextLine();
		
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println("로그인 성공!");
				System.out.println(member.getMemberName() + " 님 환영합니다 ! ");
				memberInfo = member;
			}else {
				System.out.println("비밀번호 불일치");
			}
		}else {
			System.out.println("아이디 불일치");
		}
	}
	
	//회원가입 기능
	public void insertMember() {
		System.out.println("☆★ 회 원 가 입 ★☆");
		String id = "";
		
		while(true) {
			System.out.println("ID를 입력해 주세요 > ");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member != null) {
				System.out.println("중복된 ID입니다.");
			}else if(member == null) {
				System.out.println("사용가능한 ID 입니다");
				break;
			}
		}
		System.out.println("비밀번호를 입력해주세요");
		String pw = sc.nextLine();
		
		System.out.println("닉네임을 입력해주세요");
		String name = sc.nextLine();
		
		Member mem = new Member();
		mem.setMemberId(id);
		mem.setMemberPw(pw);
		mem.setMemberName(name);
		
		int result = MemberDAO.getInstance().insertMember(mem);
		
		if(result > 0) {
			System.out.println(" ☆★ 회원가입 성공 ! ★☆");
		} else {
			System.out.println(" 회원 가입 실패 ! ! ");
		}
	}
	
	//로그아웃
	public void logout() {
		memberInfo = null;
		System.out.println(" ☆ ★ 로그아웃 완료 ★ ☆ ");
	}
	
	//회원 삭제
	public void deleteMember() {
		System.out.println(" 회원 탈퇴 ");
		System.out.println(" ID를 입력해 주세요 > ");
		String id = sc.nextLine();

		int result = MemberDAO.getInstance().deleteMember(id);
		
		if(result > 0) {
			System.out.println("회원 탈퇴 완료");
		} else {
			System.out.println("회원 탈퇴 실패");
		}
		
	}
	
	//비밀번호 수정
	public void updatePw() {
		Member member = new Member();
		
		System.out.println(" 비밀번호 수정 ");
		
		String pw = "";

		System.out.println(" 변경할 비밀번호 입력 >");
		pw = sc.nextLine();
		member.setMemberPw(pw);
		
		member.setMemberId(memberInfo.getMemberId());
		MemberDAO.getInstance().updatePw(member);
		memberInfo.setMemberPw(pw);
		
		int result = MemberDAO.getInstance().updatePw(member);
		
		if(result > 0) {
			System.out.println("☆ ★ 비밀번호 수정 완료 ★ ☆");
		}else {
			System.out.println("연락처 수정 실패 !");
		}
		
	}
	
	//닉네임 수정
	public void updateName() {
		System.out.println(" 닉네임 수정 ");
		Member member = new Member();
		
		String name = "";
		
		//로그인중인 아이디 가져오기
		member.setMemberId(memberInfo.getMemberId());
		//
		MemberDAO.getInstance().updateName(member);
		memberInfo.setMemberPw(name);
		
		System.out.println(" 변경할 닉네임 입력 >");
		name = sc.nextLine();
		
		member.setMemberName(name);
		int result = MemberDAO.getInstance().updateName(member);
		
		if(result > 0) {
			System.out.println("☆ ★ 닉네임 수정 완료 ★ ☆");
		}else {
			System.out.println("닉네임 수정 실패 !");
		}
	}
	
	
	//내 정보 조회
	public void myInfo() {
		System.out.println("내 정보 조회");
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("아이디 : " + member.getMemberId());
		System.out.println("비밀번호 : " + member.getMemberPw());
		System.out.println("닉네임 : " + member.getMemberName());
		System.out.println("가입날짜 : " + member.getMemberDate());
	}


	
	
	//Game 
	
	
	
	
	
	
	
	
	
	
	
}
