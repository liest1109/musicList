package com.yedam.exe;

import java.util.Scanner;

import com.yedam.MusicList.MusicService;
import com.yedam.game.GameService;

public class GameApp {
	
	Scanner sc = new Scanner(System.in);
	
	MusicService mu = new MusicService();
	GameService gs = new GameService();
	
	public GameApp() {
		run();
	}
	
	
	private void run() {
		boolean gameApp = true;
		while(gameApp) {
			gameInfo();
			String menuNo = sc.nextLine();
			switch (menuNo) {
			case "1" : 
				//게임 실행 + 스코어 저장
				mu.getGameMusic();
				gs.insertScore();
				break;
				
			case "2" : 
				//랭킹
				gs.getScoreList();
				break;
				
			case "3" : 
				//뒤로가기
				gameApp = false;
				break;
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void gameInfo(){
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println(" ");
		System.out.println("1. Game play | 2. 랭킹 | 3. 뒤로가기");
		System.out.println(" ");
	}
	
	
	
	
}
