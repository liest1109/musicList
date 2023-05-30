package com.yedam.game;

import java.util.List;
import java.util.Scanner;

import com.yedam.MusicList.MusicDAO;
import com.yedam.MusicList.MusicService;
import com.yedam.member.Member;

public class GameService {

	MusicService mu = new MusicService();
	
	public static Game gameInfo = null;
	Scanner sc = new Scanner(System.in);
	
	
	//게임 스코어 입력
	public void insertScore() {
		Game game = new Game();
		Member member = new Member();

		
		System.out.println("랭킹에 등록할 닉네임을 입력해 주세요");
		game.setMemberName(sc.nextLine());
		
		game.setGameScore(mu.score);
		
		int result = GameDAO.getInstance().insertScore(game);
	}
	
	
	//게임 
	public void getScoreList() {
		List<Game> list = GameDAO.getInstance().getScoreList();
		System.out.println(" ");
		System.out.println("명예의 전당");
		System.out.println(" ");
		
		if (list.size()<9) {
			for(int i = 0; i<list.size(); i++) {
				System.out.println((i+1) + " 위 " + list.get(i).getMemberName() + " " + list.get(i).getGameScore());

			}
		}else if (list.size()>=9) {
			for (int i = 0; i<10; i++) {
				System.out.println((i+1) + " 위 " + list.get(i).getMemberName() + " " + list.get(i).getGameScore());
			}
		}

	}
	
}
