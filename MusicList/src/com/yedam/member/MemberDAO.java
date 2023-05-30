package com.yedam.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO {
	
	private static MemberDAO memberDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}
	
	//로그인 기능
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberDate(rs.getString("member_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	//회원가입 기능
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO member VALUES(?,?,?,sysdate,null)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2,  member.getMemberPw());
			pstmt.setString(3,  member.getMemberName());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	
	//회원 탈퇴
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//비밀번호 수정
	public int updatePw(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_pw = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//닉네임 수정
	public int updateName(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_name = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//내 정보 조회
//	public List<Member> getMemberList(){
//		List<Member> list = new ArrayList<>();
//		Member member = null;
//		try {
//			conn();
//			String sql = "SELECT * FROM member";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				member = new Member();
//				member.setMemberId(rs.getString("member_id"));
//				member.setMemberPw(rs.getString("member_pw"));
//				member.setMemberName(rs.getString("member_name"));
//				member.setMemberDate(rs.getString("member_date"));
//				list.add(member);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return list;
//	}
	
	//game
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
