package Starcraft.taeyoun.building;
import java.util.List;
import java.util.Scanner;

import Starcraft.taeyoun.building.Building.State;
import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;

public class Refinery extends Building {
	private static int refineryCount = 0;
	private int x;
	private int y;
	public Refinery(Player player, int x, int y) {
		super(player,
				Data.REFINERY_NAME,
				Data.REFINERY_M,
				Data.REFINERY_G,
				Data.REFINERY_HP,
				x,
				y,
				State.staying
				);
		player.getBuildingList().add(this);
		player.setRefineryCount(player.getRefineryCount()+1);
	}
	
	 public static void	controlRefinery(Player human, Scanner scanner) {
			String input;				
			int number;
		 		          	List <Refinery> refineryList = human.getListOfType(Refinery.class); // 1. 정제소 리스트를 보여준다.
			        		System.out.println(refineryList);					
			        		System.out.println(" 사용할 건물 번호를 고르세요 "); 			// 2. 몇번 정제소를 사용할지 물어본다
				        	input = scanner.next(); 			        			// 값 입력하기(ex:2)
				        	System.out.println(input + "번을 선택하셨습니다.");			// 3. 입력값을 확인한다.
				        	number = Integer.parseInt(input) - 1;					// 4. number 값을 입력값-1 로 해준다.(배열이기때문)
				        	System.out.println(" 메뉴가 없습니다. q : 종료");				// 5. 메뉴 선택창을 출력한다.
				        	input = scanner.next();									// 6. 명령에 대한 입력값을 받는다.
		 
				        	switch(input.toLowerCase()) {
				        	
				        		case "q" :
				        			System.out.println("되돌아갑니다.");
				        			break;
				        			
				        		default :
				        			System.out.println("에러코드 124");
				        			break;
				        	}
		}
	

	 
		@Override
		public int getX() {
			return x;
		}


		@Override
		public int getY() {
			return y;
		}


		@Override
		public void setX(int x) {
			this.x = x;
		}


		@Override
		public void setY(int y) {
			this.y = y;
		}
}
