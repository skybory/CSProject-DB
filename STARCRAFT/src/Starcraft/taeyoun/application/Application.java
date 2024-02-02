package Starcraft.taeyoun.application;


public class Application {
	public static void main(String[] args) {
		StartGame game = new StartGame();	//StartGame 객체를 생성해서 게임을 실행함.
		game.showGameStatus();				//게임 끝나면 실행. 나의 자원을 보여줌.
	}	
}
