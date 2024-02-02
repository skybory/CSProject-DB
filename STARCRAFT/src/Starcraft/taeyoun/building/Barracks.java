package Starcraft.taeyoun.building;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.unit.Marine;
import Starcraft.taeyoun.unit.Medic;
import Starcraft.taeyoun.unit.Unit;
public class Barracks extends Building {
	
	private final Player player;
	private int x;
	private int y;
	
	private static int barracksCount = 0;				// 배럭의 카운터를 만들어서, 배럭을 만들때마다 1씩 늘려준다. 배럭이 하나도 없을 때 마린을 뽑는 것을 방지하기 위함이다.
														// 건물이 파괴되는 것을 만들지 못했기 때문에, 줄어들지는 않는다. (한계점)
	public Barracks(Player player, int x,int y) {
		super(player,
				Data.BARRACKS_NAME,
				Data.BARRACKS_M,
				Data.BARRACKS_G,
				Data.BARRACKS_HP,
				x,
				y,
				State.staying
				);
		this.player = player;
		this.x = x;
		this.y = y;
		incrementCountBarracks();
		player.getBuildingList().add(this);
	}
	

	public void produceMarine() {						// 마린을 생성하는 메서드. 
		if ( barracksCount > 0 ) {						// 최소한 배럭이 1개는 있어야 실행이 가능하며
			if (getProduceHelper().validCheck(player, Data.MARINE_M, Data.MARINE_G, Data.MARINE_P)) {	// 마린에 대한 자원이 충분한지 판단하고, 그렇다면 그만큼의 자원을 차감한다.
			System.out.println("Marine 생산 중...");		// 마린이 생산중이라는 메세지를 보여주고
				Timer timer = new Timer();				// 시간을 측정한다. Data에 기재된 MARINE_TIME 시간만큼 기다린 뒤에 아래의 실행문을 실행한다.
				timer.schedule(new TimerTask() {		// 타이머의 스케쥴 메서드로,일을 예약한다. schedule(해야할 일,시간) 으로 구성되어 있다.
					@Override							// 해야할 일을 TimerTask()로 생성했고, 모든 TimerTask 는 기본적으로 실행이라는 run() 메서드를 가지고 있기 때문에
					public void run() {					// 그 부분을 오버라이드해서 실행문을 내가 원하는 맛으로 바꿔준다.
						Unit marine = new Marine(player,x,y);	
						player.addUnit(marine);
					timer.cancel();
					}
				}, Data.MARINE_TIME * 1000);
			}
		}
	}

	public void produceMedic() {						// 메딕을 생성하는 메서드다.
		if ( barracksCount > 0 ) {
			 if (getProduceHelper().validCheck(player, Data.MEDIC_M, Data.MEDIC_G, Data.MEDIC_P)) {
				System.out.println("Medic 생산 중...");
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						Unit medic = new Medic(player,x,y);	
						player.addUnit(medic);
						timer.cancel();
					}
				}, Data.MEDIC_TIME * 1000);
			}
		}
	}
	
	   public static void	controlBarracks(Player human, Scanner scanner) {		// 배럭을 컨트롤하는 메서드다.
		String input;				
		int number;
	 		          	List <Barracks> barracksList = human.getListOfType(Barracks.class);	// 1. 배럭의 리스트를 보여준다.
		        		System.out.println(barracksList);
		        		System.out.println(" 사용할 건물 번호를 고르세요 "); 			// 2. 몇번 배럭을 사용할지 고른다.
			        	input = scanner.next(); 			        			// 3-1. 값을 입력한다. ex)2
			        	System.out.println(input + "번을 선택하셨습니다.");				// 3-2. 입력값을 확인한다.
			        	number = Integer.parseInt(input) - 1;					// 4. number 값을 입력값-1 로 해준다.(배열이기때문 -> 배열은 0번부터 시작하기때문에, 우리가 입력하는 숫자보다 1이 낮다.)
			        	System.out.println(" 메뉴를 선택하세요. m : 마린 생산, c : 메딕생산, q : 종료");	//5. 메뉴 선택창을 출력한다.
			        	input = scanner.next();									// 6. 어떤 명령을 선택할지에 대한 입력값을 받는다.
	 
			        	switch(input.toLowerCase()) {
			        		case "s" :
			        			barracksList.get(number).produceMarine();
			        			break;
			        			
			        		case "c" :
			        			barracksList.get(number).produceMedic();
			        			
			        		case "q" :
			        			System.out.println("되돌아갑니다.");
			        			break;
			        			
			        		default :
			        			System.out.println("에러코드 100");
			        			break;
			        	}
	}
	
	 private static void incrementCountBarracks() {
	        barracksCount++;
	    }
	 
	 public static int getBarracksCount() {
	        return barracksCount;
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