package Starcraft.taeyoun.building;
import java.util.List;
import java.util.Scanner;

import Starcraft.taeyoun.building.Building.State;
import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;

public class SupplyDepot extends Building {

	private int x;
	private int y;
	public SupplyDepot(Player player, int x, int y) {
		super(player,
				Data.SUPPLYDEPOT_NAME,
				Data.SUPPLYDEPOT_M,
				Data.SUPPLYDEPOT_G,
				Data.SUPPLYDEPOT_HP,
				x,
				y,
				State.staying
				);
		player.setPopulation(player.getPopulation() + 8);
		player.getBuildingList().add(this);
	}
	
	   public static void	controlSupplyDepot(Player human, Scanner scanner) {	//Refinery와 같다.
		String input;				
		int number;
	 		          	List <SupplyDepot> supplyDepotList = human.getListOfType(SupplyDepot.class);
		        		System.out.println(supplyDepotList);
		        		System.out.println(" 사용할 건물 번호를 고르세요 "); 				
			        	input = scanner.next(); 			        			
			        	System.out.println(input + "번을 선택하셨습니다.");			
			        	number = Integer.parseInt(input) - 1;					
			        	System.out.println(" 메뉴가 없습니다. q : 종료");	
			        	input = scanner.next();									
	 
			        	switch(input.toLowerCase()) {
			        	
			        		case "q" :
			        			System.out.println("되돌아갑니다.");
			        			break;
			        			
			        		default :
			        			System.out.println("에러코드 149");
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
