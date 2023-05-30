package com.yedam.MusicList;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.game.Game;

public class MusicDAO extends DAO {
		
	private static MusicDAO musicDao = null;
	
	
	public static MusicDAO getInstance() {
		if (musicDao == null) {
			musicDao = new MusicDAO();
		}
		return musicDao;
	}
	
	//노래 목록 추가
	public int insertMusic(Music music) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO musiclist2 VALUES (?,?,?,?,?,'Y')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, music.getMusicName());
			pstmt.setString(2, music.getMusicSinger());
			pstmt.setString(3, music.getMusicComposer());
			pstmt.setString(4, music.getMusicLyricist());
			pstmt.setString(5, music.getMusicDate());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		} 
		return result;
	}
	
	//노래 리스트 수정
	public int updateSinger(Music music) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE musiclist2 SET music_singer = ? WHERE music_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, music.getMusicSinger());
			pstmt.setString(2, music.getMusicName());
	
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	//노래 삭제
	public int deleteMusic(String name) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM musiclist2 WHERE music_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//노래 검색
	
	
	
	
	
	//노래 전체 조회
	public List<Music> getMusicList(){
		List<Music> list = new ArrayList<>();
		Music music = null;
		try {
			conn();
			String sql = "SELECT * FROM musiclist2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				music = new Music();
				music.setMusicName(rs.getString("music_name"));
				music.setMusicSinger(rs.getString("music_singer"));
				music.setMusicComposer(rs.getString("music_composer"));
				music.setMusicLyricist(rs.getString("music_lyricist"));
				music.setMusicDate(rs.getString("music_date"));
				list.add(music);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//게임에 쓸 노래/가수 출력
	public List<Music> getGameMusic(){
		List<Music> list = new ArrayList<>();
		Music music = null;
		try {
			conn();
			String sql = "SELECT music_name, music_singer FROM musiclist2 WHERE music_game = 'Y' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				music = new Music();
				music.setMusicName(rs.getString("music_name"));
				music.setMusicSinger(rs.getString("music_singer"));
				list.add(music);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//game 출력 중복행 제외하기
	public int chanGame(Music music) {
		
	int result = 0;
	try {
		conn();
		String sql = "UPDATE musiclist2 SET music_game = ? WHERE music_name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, music.getMusicGame());
		pstmt.setString(2, music.getMusicName());

		result = pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		disconn();
	}
	return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
