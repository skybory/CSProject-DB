package Starcraft.taeyoun.application;

import Starcraft.taeyoun.building.CommandCenter;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.resource.map.Map;
import Starcraft.taeyoun.unit.Marine;
import Starcraft.taeyoun.unit.Scv;
import Starcraft.taeyoun.unit.Unit;

import java.util.Scanner;

public class StartGame {

	private Map map;
    private Player human;
    private Player computer;

    public StartGame() {											// 게임을 스타트하는 메서드.
        this.map = new Map();										// 나와 컴퓨터 두 명의 플레이어를 만들어준다.
        this.human = new Player("김태연");
        this.computer = new Player("Computer");
        
        CommandCenter commandCenter1 = new CommandCenter(human,0,0);		// 각각 플레이어는 커맨드센터를 하나씩 가지고, 4개의 SCV를 가진다.
		Unit scv1 = new Scv(human, 1, 0);
		Unit scv2 = new Scv(human, 2, 3);
		Unit scv3 = new Scv(human, 3, 0);
		Unit scv4 = new Scv(human, 4, 0);
		human.addUnit(scv1);
		human.addUnit(scv2);
		human.addUnit(scv3);
		human.addUnit(scv4);

		Unit marine1 = new Marine(human, 10, 10);
		Unit marine2 = new Marine(human, 10, 10);
		human.addUnit(marine1);
		human.addUnit(marine2);
		CommandCenter commandCenter2 = new CommandCenter(computer,10,10);
		Unit cscv1 = new Scv(computer, 11, 10);
		Unit cscv2 = new Scv(computer, 12, 10);
		Unit cscv3 = new Scv(computer, 13, 10);
		Unit cscv4 = new Scv(computer, 14, 10);
		computer.addUnit(cscv1);
		computer.addUnit(cscv2);
		computer.addUnit(cscv3);
		computer.addUnit(cscv4);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		human.showGameStatus();						// human이 가지고있는 자원(미네랄,가스,인구수,유닛&건물리스트) 를 보여주는데, 각각을 보여주는 메서드들이 프린트문이라
		try {										// 시간이 조금 걸리기도 하기때문에, Thread.sleep을 넣어줘서 아래에 있는 ***GameStrat*** 프린트문과 간섭이 일어나지 않게 만들었다. 
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		        System.out.println("**************************************************************************************************************");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                 Game Start                                                 *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("*                                                                                                            *");
		        System.out.println("**************************************************************************************************************");
		        Scanner scanner = new Scanner(System.in);
				MainMenu mainMenu = MainMenu.getInstance();
		        mainMenu.showMenu(human, computer, scanner);	//메인메뉴 실행
    
    }

	public void showGameStatus() {
	    human.showGameStatus();
	}
    

	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Player getHuman() {
		return human;
	}

	public void setHuman(Player human) {
		this.human = human;
	}

	public Player getComputer() {
		return computer;
	}

	public void setComputer(Player computer) {
		this.computer = computer;
	}

    
}
