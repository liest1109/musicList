package com.yedam.MusicList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.yedam.game.GameService;

public class MusicService {
	
	public static Music musicInfo = null;

	MusicDAO mu = new MusicDAO();
	
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	//노래 중복제거를 위한 정답 제목과 가수
	String name1 = "";
	String singer1 = "";
	
	
	//
	public static int score = 0;
	
	//노래 목록 추가
	public void insertMusic() {
		Music music = new Music();
		System.out.println("☆ ★ 노 래 등 록 ★ ☆");
		
		System.out.println(" 노래 제목 >");
		music.setMusicName(sc.nextLine());
		
		
		System.out.println(" 가수 이름 >");
		music.setMusicSinger(sc.nextLine());
		
		System.out.println(" 작곡가 >");
		music.setMusicComposer(sc.nextLine());
		
		System.out.println(" 작사가 >");
		music.setMusicLyricist(sc.nextLine());
		
		System.out.println(" 발매일 >");
		System.out.println(" (-- -- --)로 입력 ");
		music.setMusicDate(sc.nextLine());
		
		int result = MusicDAO.getInstance().insertMusic(music);
		
		if(result > 0) {
			System.out.println(" 노래 등록 성공 !! ");
		} else {
			System.out.println(" 노래 등록 실패 ");
		}
	}
	
	//노래 수정
	public void updateSinger() {
		System.out.println("☆ ★ 노 래 수 정 ★ ☆");
		
		Music music = new Music();
		
		System.out.println(" 수정할 노래 제목 > ");
		String name = sc.nextLine();
		String singer = "";
		
		while (true) {
			System.out.println("가수 이름 > ");
			singer = sc.nextLine();
			if(singer.length() > 100 ) {
				System.out.println("자리수 초과 !! 다시 입력해주세요");
			}else {
				break;
			}
		}
		
		
		music.setMusicName(name);
		music.setMusicSinger(singer);
		int result = MusicDAO.getInstance().updateSinger(music);
		
		if(result > 0 ) {
			System.out.println("노래 수정 완료!");
		}else {
			System.out.println("노래 수정 실패!");
		}
	}
	
	//노래 삭제
	public void deleteMusic() {
		System.out.println(" ☆ ★ Music List 삭제 ★ ☆ ");
		System.out.println(" 노래 제목을 입력해 주세요 ");
		String name = sc.nextLine();
		
		int result = MusicDAO.getInstance().deleteMusic(name);
		
		if(result > 0) {
			System.out.println(" ☆ ★ Music List 삭제 완료 ★ ☆");
		}else {
			System.out.println(" Music List 삭제 실패 !! ");
		}
	}
	
	//노래 검색
//	public void SearchingMusic() {
//		System.out.println("찾고싶은 노래 제목을 입력하세요");
//		String Search = sc.nextLine();
//		
//		
//	}
	
	//모든 Music List 출력
	public void getMusicList() {
		List<Music> list = MusicDAO.getInstance().getMusicList();
		System.out.println("☆ ★ 모든 Music List 출력 ★ ☆");
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(" " + (i+1) + " ");
			System.out.println("제목 : " + list.get(i).getMusicName());
			System.out.println("가수 : " + list.get(i).getMusicSinger());
			System.out.println("작사 : " + list.get(i).getMusicLyricist());
			System.out.println("작곡 : " + list.get(i).getMusicComposer());
			System.out.println("발매일 : " + list.get(i).getMusicDate());

		}
	}
	
	
	public void getGameMusic() {
		
		Music music = new Music();
		
		List<Music> list = MusicDAO.getInstance().getMusicList();

		

		score = 0;
		
		//10번 반복
		for(int a = 1; a<11; a++) {
			
			// 노래 제목, 가수 중 무엇을 출력할지 고르는 랜덤값
			int gameNo = random.nextInt(2);
			
			//목록의 번호를 출력하는 랜덤값
			int gameNo2 = random.nextInt(list.size());
			
			//정답 유무를 판별하는 변수
			int qa1 = 0;
			
		System.out.println("=======================================");	
		System.out.println( " " + a + " 번째 문제 !" );
		// 0이면 제목 출력
		if (gameNo == 0) {
			// 문제 : 제목 출력
			System.out.println("노래 제목 : " + list.get(gameNo2).getMusicName());
			// 유저 답변 입력 ( 가수 이름 )
			String singer = sc.nextLine();

			for(int i = 0; i<list.size(); i++) {
				if(list.get(gameNo2).getMusicName().equals( list.get(i).getMusicName())&& 
						 list.get(i).getMusicSinger().equals(singer)) {
					qa1 = 1;
					
					name1 = "";
					singer1 = "";
					
					name1 =  list.get(i).getMusicName();
					singer1 = list.get(i).getMusicSinger();
					
						
				 }else { 
				 }
			}
			//정답 판별 하기
			//정답
			if (qa1 == 1) {
				System.out.println("☆ ★ 정답 ★ ☆ ");
				System.out.println(" 1 0 점 획 득 ! ");
				
				//score 점수
				score = score + 10;
				
				//정답 유무 초기화
				qa1 = 0;

				
			//오답
			} else if (qa1 == 0 ) {
				System.out.println("오답!!");
				qa1 = 0;
			}
			
		// 1이면 가수 출력
		} else if (gameNo == 1) {

			//가수이름 출력
			System.out.println("가수 이름 : " + list.get(gameNo2).getMusicSinger());
			
			// 유저 답변 입력 ( 노래 제목 )
			String name = sc.nextLine();
			
			//
			for (int i = 0; i<list.size(); i++) {
				if(list.get(gameNo2).getMusicSinger().equals(list.get(i).getMusicSinger()) &&
					list.get(i).getMusicName().equals(name)) {
						qa1 = 1;
						
						name1 = "";
						singer1 = "";
						
					}else {
						
					}
			}
			//정답 판별하기
			if (qa1 == 1) {
				System.out.println(" ☆ ★ 정 답 ★ ☆");
				System.out.println(" 10 점 획 득 ! ");
				
				//score 점수
				score = score + 10;
				
				//정답 유무 초기화
				qa1 = 0;
				
				
			} else if (qa1 == 0) {
				System.out.println("오답!!");
				qa1 = 0;
			}
		
			
		}
		}
		System.out.println(" 최종 점수는 " + score + " 점! ");
		}
		

	//중복 제거하기
	public void chanGame() {
		Music music = new Music();
		

		music.setMusicName(name1);
		music.setMusicGame("N");
	
		int result = MusicDAO.getInstance().chanGame(music);
		
	}
	
	
	
	
	
}
