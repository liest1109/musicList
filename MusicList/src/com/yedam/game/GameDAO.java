package com.yedam.game;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class GameDAO extends DAO {
	private static GameDAO gameDao = null;
	
	private GameDAO() {
		
	}
	
	public static GameDAO getInstance() {
		if(gameDao == null) {
			gameDao = new GameDAO();
		}
		return gameDao;
	}
	
	
	
	//게임 내역 입력
	public int insertScore(Game game) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO gamescore VALUES (null,?,?)";
			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, game.getMemberName());
 			pstmt.setInt(2, game.getGameScore());

			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		} 
		return result;
	}
	
	
	//랭킹 출력
	public List<Game> getScoreList(){
		List<Game> list = new ArrayList<>();
		Game game = null;
		try {
			conn();
			String sql = "SELECT member_name, game_score FROM gamescore order by game_score desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				game = new Game();
				game.setMemberName(rs.getString("member_name"));
				game.setGameScore(rs.getInt("game_score"));
				list.add(game);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//랭킹 출력

	
}
