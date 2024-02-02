package Starcraft.taeyoun.application;

import java.util.Scanner;

import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.unit.Marine;
import Starcraft.taeyoun.unit.Medic;
import Starcraft.taeyoun.unit.Scv;
import Starcraft.taeyoun.unit.Unit;

public class UnitMenu {
	    private static UnitMenu instance;			// 마찬가지로 메모리를 아끼기 위해 SingleTon을 사용했다.

	    private UnitMenu() {
	    }

	    public static UnitMenu getInstance() {
	        if (instance == null) {
	            instance = new UnitMenu();
	        }
	        return instance;
	    }
	
	public void showMenu(Player human, Scanner scanner) {		// StartGame -> press'u' 를 했을때 나오닌 메뉴창이다. 유닛 메뉴를 보여준다.
		System.out.println("유닛 창을 보여줍니다");
		human.showUnitList();									// Player 클래스의 메서드를 호출한다 : Unit을 상속받는 리스트를 보여준다.
		System.out.println("조작할 유닛을 고르세요 (s : SCV, m : Marine, c : Medic, q : 종료):");
		String input = scanner.next().toLowerCase(); // 메뉴판 인쇄랑 input은 세트

		switch (input) {
		case "s":
			UnitController.controlUnit(human, scanner, Scv.class);
			break;

		case "m":
			UnitController.controlUnit(human, scanner, Marine.class);
			break;

		case "c":
			UnitController.controlUnit(human, scanner, Medic.class);
			break;

		case "q":
			System.out.println("유닛 조작을 종료합니다.");
			break;

		default:
			System.out.println("잘못된 입력입니다");
			break;
		}
	}
	
}
