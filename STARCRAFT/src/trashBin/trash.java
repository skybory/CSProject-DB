package trashBin;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Starcraft.taeyoun.building.CommandCenter;
import Starcraft.taeyoun.building.Refinery;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.unit.Marine;
import Starcraft.taeyoun.unit.Medic;
import Starcraft.taeyoun.unit.Scv;
import Starcraft.taeyoun.unit.Unit;
import Starcraft.taeyoun.unit.Unit.State;

public class trash {//	@Override

//	if (commandCenterCount > 0) {
//	if (getProduceHelper().validCheck(player, Data.SCV_M, Data.SCV_G, Data.SCV_P)) {
//		// x+1 자리에 유닛이 없다면
//		int i;
//		int j;
//		for (i = 0; i < 5; i++) {
//			for (j = 0; j < 5; j++) {
//				if (!Map.getCell(this.x + j, this.y + i).isUnit()) {
//					break;
//				}
//			}
//			if (!Map.getCell(this.x + j, this.y + i).isUnit()) {
//				Unit Scv = new Scv(player, x + i, y + j);
//				player.addUnit(Scv);
//				break;
//			}
//			if (i == 4 && j == 4) {
//				System.out.println("입구가 막혔습니다. 유닛을 치워주세요");
//				break;
//			}
//		}
//	}
//} else
//	System.out.println("커멘드 센터를 지으세요");
//
//}//	public void attack(Unit unit2) {
//	
//	this.setState(state.fighting);
//	int x = unit2.getX() - this.getX();
//	int y = unit2.getY() - this.getY();
//	double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//	// 거리측정
//	// 거리가 멀면 공격하지 않는다.
//	boolean inRange = this.range >= distance;	
//	boolean myTeam = this.player == unit2.player; 
//	boolean unitNull = unit2 == null;
//	
//	
//		if (!inRange) {
//			System.out.println("사거리 밖입니다. 이동합니다.");
//			move(unit2.getX(), unit2.getY()); //1초마다 이동함
//			this.setState(state.fighting);
//		}
//		// 거리가 멀지 않으면 = 공격 사거리 내에 있으면
//		else if (myTeam) {
//			System.out.println("아군입니다. 공격을 금지합니다.");
//			this.stop();
//		} else if (unitNull || unit2.currentHp < 0) {
//			System.out.println("상대방이 죽었습니다.");
//			this.stop();
//		} else {
//			unit2.setCurrentHp(unit2.getCurrentHp() - (this.getAtk() - unit2.getDef()));
//			System.out.println(this.getPlayer().getPlayerName() + "의 유닛 " + this.getName() + "이 "
//					+ unit2.getPlayer().getPlayerName() + " 의 유닛" + unit2.getName() + "을 공격합니다.");
//			delay();
//		}
//		this.stop();
//	}
//
//	public void produceBarracks(int x, int y) {
//	if (produceHelper.validCheck(player, Data.BARRACKS_M, Data.BARRACKS_G, 0)) {
//    Building Barracks = new Barracks(player, x, y);
//   // player.addBuilding(Barracks);
//}
//}

//public void produceSupplyDepot(int x, int y) {
//if (produceHelper.validCheck(player, Data.SUPPLYDEPOT_M, Data.SUPPLYDEPOT_G, 0)) {
//	Building SupplyDepot = new SupplyDepot(player,x,y);
////	player.addBuilding(SupplyDepot);
//}
//}
//public void produceRefinery(int x, int y) {
//if (produceHelper.validCheck(player, Data.REFINERY_M, Data.REFINERY_G, 0)) {
//	Building Refinery = new Refinery(player,x,y);
////	player.addBuilding(Refinery);
//}
//}
//	@Override
//	public void stop() {	
//		this.executorService.shutdown();
//		setState(State.staying);
//		System.out.println("반복3번");
//    	System.out.println("유닛을 멈춥니다.");
//
//    	delay();
//	}
//	
//	@Override
//	public void move(int x, int y) {
//		stop();
//		executorService = Executors.newScheduledThreadPool(1);
//		delay();
//		setState(State.moving);
//		System.out.println("이동 명령을 시작합니다!!!");
//		
//		executorService.scheduleAtFixedRate(() -> {
//	
//			System.out.println("이 유닛의 x좌표는 : " + getX()); // 내 x좌표
//			System.out.println("이 유닛의 y좌표는 : " + getY()); // 내 y좌표
//			
//			int distanceX = Math.abs(x - getX()); // x축 거리
//			int distanceY = Math.abs(y - getY()); // y축 거리
//			
//			System.out.println("x거리는" + distanceX + "입니다");
//			System.out.println("y거리는" + distanceY + "입니다");
//			
//			if (distanceX == 0 && distanceY == 0) {
//				System.out.println("이동이 종료됩니다.");
//				System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//				System.out.println("반복1번");
//				stop();
//				System.out.println("반복1번");
//
//			} else if (Math.abs(distanceX) >= Math.abs(distanceY)) {
//				setX(getX() + Integer.compare(x, getX())); // 현재 위치에서 목표 지점 방향으로 1 칸 이동
//				System.out.println(getName() + "이 x축 이동했습니다");
//				System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//			}
//
//			else {
//				setY(getY() + Integer.compare(y, getY())); // 현재 위치에서 목표 지점 방향으로 1 칸 이동
//				System.out.println(getName() + "이 x축 이동했습니다");
//				System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//			}
//			
//	        if (getX() == x && getY() == y) {
//	            // 목표 지점에 도달했을 때 작업 종료
//	            System.out.println("이동이 종료됩니다.");
//	            System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//	        	System.out.println("반복2번");
//	            stop();
//	        	System.out.println("반복2번");
//	        }
//		}, 1, 1, TimeUnit.SECONDS);
//
//}
//	
	
//	@Override
//	public void move(int x, int y) {
//	    setState(State.moving);
//
//	    while (getState() == State.moving) {
//	        // 이동 중인 도중에 중단 명령을 받으면 중단
//	        if (getState() != State.moving) {
//	            System.out.println("이동이 중단되었습니다.");
//	            System.out.println("gvajiewgjaiwegjioawgjiaowjgioajgoijo");
//	            return;
//	        }
//
//	        // 경로 찾기 및 이동 로직 유지...
//	        
//			int distanceX = Math.abs(x - getX());			//x축 거리 확인
//			int distanceY = Math.abs(y - getY());			//y축 거리 확인
//			System.out.println("이 유닛의 x좌표는 : " + getX());
//			System.out.println("이 유닛의 y좌표는 : " + getY());
//			
//			System.out.println("x거리는" + distanceX + "입니다");
//			System.out.println("y거리는" + distanceY + "입니다");
//			System.out.println("while문 작동중");
//			if (distanceX == 0 && distanceY == 0) {
//			    System.out.println("이동이 끝났습니다.");
//			    System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//			    stop();
//			} else if (Math.abs(distanceX) >= Math.abs(distanceY)) {
//			    // x 거리의 절댓값이 y 거리의 절댓값보다 크거나 같으면 x 방향으로 이동
//			    delay();
//			    setX(getX() + Integer.compare(x, getX())); // 현재 위치에서 목표 지점 방향으로 1 칸 이동
//			    System.out.println(getName() + "이 x축 이동했습니다");
//			    System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//			} else {
//			    // y 거리의 절댓값이 x 거리의 절댓값보다 크면 y 방향으로 이동
//			    delay();
//			    setY(getY() + Integer.compare(y, getY())); // 현재 위치에서 목표 지점 방향으로 1 칸 이동
//			    System.out.println(getName() + "이 y축 이동했습니다");
//			    System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
//			}
//	    }
//			
//
//	
//	}
	
	 /*	if (unitList.getClass() == Scv.class)
	{
		MultiCommandScv((List<Scv>) unitList,scanner);
	}
    System.out.println("유닛 전체를 선택했습니다.");
    MultiCommand((List<Unit>) unitList,scanner);
} 
*/
	/*	public static void	controlCommandCenter(Player human, Scanner scanner) {	//커맨드 센터 컨트롤
	String input;				
	int number;
 		          	List <CommandCenter> commandCenterList = human.getListOfType(CommandCenter.class);
	       		System.out.println(commandCenterList);
	        		System.out.println(" 사용할 건물 번호를 고르세요 "); 				// 2. 몇번 커맨드 센터를 사용할지 물어본다
		        	input = scanner.next(); 			        			//	값 입력하기(ex:2)
		        	System.out.println(input + "번을 선택하셨습니다.");				// 3. 입력값 확인해준다
		       	number = Integer.parseInt(input) - 1;					// 4. number 값을 입력값-1 로 해준다.(배열이기때문)
		       	System.out.println(" 메뉴를 선택하세요. s : SCV 생산, q : 종료");	//5. 메뉴 선택창을 출력한다.
		        	input = scanner.next();									// 입력값을 다시 오픈
 
		        	switch(input.toLowerCase()) {
		        		case "s" :
		        			commandCenterList.get(number).produceScv();
		        			break;
		        		case "q" :
		        			System.out.println("되돌아갑니다.");
		        			break;
		        			
		        		default :
		        			System.out.println("에러코드 72");
		        			break;
		        	}
}

*/
	/*	@Override
	public void move(int x, int y) { // x : 목표 x 좌표, y : 목표 y 좌표
		setState(State.moving);								//상태를 이동중으로 바꾼다.
		while (getState() == State.moving) {
			// 경로 찾기
			int distanceX = Math.abs(x - getX());			//x축 거리 확인
			int distanceY = Math.abs(y - getY());			//y축 거리 확인
			System.out.println("이 유닛의 x좌표는 : " + getX());
			System.out.println("이 유닛의 y좌표는 : " + getY());
			
			System.out.println("x거리는" + distanceX + "입니다");
			System.out.println("y거리는" + distanceY + "입니다");
			System.out.println("while문 작동중");
			if (distanceX == 0 && distanceY == 0) {			//만약 x축 거리 = y축 거리 = 0 일 경우 stop(); = 상태를 staying으로 바꿈
				System.out.println("이동이 끝났습니다.");
				System.out.println("현재 위치는 : (" + getX() + ", ("+ getY() + ")");
				stop();
			} else if (distanceX >= distanceY) {			// x 거리가 y 거리보다 멀면 1초 기다리고 x축으로 1 칸 이동
				delay();								
				setX(getX() + 1);
				System.out.println(getName() + "이 x축 이동했습니다");
				System.out.println("현재 위치는 : (" + getX() + ", "+ getY() + ")");
			} else if (distanceX < distanceY) {				// y 거리가 x 거리보다 멀면 1초 기다리고 y축으로 1 칸 이동
				delay();
				setY(getY() + 1);
				System.out.println(getName() + "이 y축 이동했습니다");
				System.out.println("현재 위치는 : (" + getX() + ", "+ getY() + ")");
			}
		}
	}
*/
	
	 /*	private void mineralDelay() {
	    try {
	        Thread.sleep(5000); // 1초 딜레이
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        stop();
	    }
	}
	
	*/
	
	//쓰레기통
/*//			  System.out.println("유닛을 조작합니다");
//			  System.out.println(human.getUnitList());
//			  System.out.println("조작할 유닛 종류를 고르세요 ( s : SCV, m : Marine, c : Medic, q : 종료");
//			  input = scanner.next();
//		      //조작할 유닛 종류 고르시오!!!
//		      switch (input.toLowerCase()) {			//대소문자 상관없이 입력받으면 소문자로 변경
//		            case "s":
//		        																// 1. 커맨드 센터의 리스트를 출력한다.
//		          		List <Scv> scvList = human.getListOfType(Scv.class);
//		        		System.out.println(scvList);
//		        		System.out.println(" 사용할 유닛 번호를 고르세요 "); 				// 2. 몇번 커맨드 센터를 사용할지 물어본다
//			        	input = scanner.next(); 			        			//	값 입력하기(ex:2)
//			        	System.out.println(input + "번을 선택하셨습니다.");				// 3. 입력값 확인해준다
//			        	number = Integer.parseInt(input) - 1;					// 4. number 값을 입력값-1 로 해준다.(배열이기때문)
//			        	System.out.println(" 메뉴를 선택하세요. m : 미네랄 채굴, g : 가스 채굴, q : 종료");	//5. 메뉴 선택창을 출력한다.
//			        	input = scanner.next();									// 6. 메뉴를 입력받는다.
//			        	
//			        	switch(input.toLowerCase()) {							// 7. 기능을 선택한다.
//		        				case "m" :
//		        					scvList.get(number).gatherMineral();	// (number)번 커맨드에서 SCV 생산 (작동안함)
//		        					human.playerSource();
//			        			break;
//			        			
//		        				case "g" :
//				        			scvList.get(number).gatherGas();	// (number)번 커맨드에서 SCV 생산 (작동안함)
//				        			human.playerSource();
//		        					break;
//		        					
//			        			case "q" :
//			        			System.out.println( " 되돌아갑니다. " );
//			        			break;											// 7번의 switch문 종료
//			        			
//			        			default :
//			        				System.out.println("에러코드 129");
//			        				break;
//			        	}
//			        	break;
//		      }
//		      break;
//			        	
 * 
 * //			  System.out.println("건물을 조작합니다");
//			  System.out.println(human.getBuildingList());	
//			  System.out.println("조작할 건물을 고르세요 (c : Command Center, b : Barracks, q : 종료):");
//		      input = scanner.next();
//		      //조작할 건물 종류 고르시오!!!
//		      switch (input.toLowerCase()) {			//대소문자 상관없이 입력받으면 소문자로 변경
//		            case "c":
//		        		//controlCommandCenter(human,scanner)										// 1. 커맨드 센터의 리스트를 출력한다.
//		          		List <CommandCenter> commandCenterList = human.getListOfType(CommandCenter.class);
//		        		System.out.println(commandCenterList);
//		        		System.out.println(" 사용할 건물 번호를 고르세요 "); 				// 2. 몇번 커맨드 센터를 사용할지 물어본다
//			        	input = scanner.next(); 			        			//	값 입력하기(ex:2)
//			        	System.out.println(input + "번을 선택하셨습니다.");				// 3. 입력값 확인해준다
//			        	number = Integer.parseInt(input) - 1;					// 4. number 값을 입력값-1 로 해준다.(배열이기때문)
//			        	System.out.println(" 메뉴를 선택하세요. s : SCV 생산, q : 종료");	//5. 메뉴 선택창을 출력한다.
//			        	input = scanner.next();									// 6. 메뉴를 입력받는다.
//			        	
//			        	switch(input.toLowerCase()) {							// 7. 기능을 선택한다.
//		        				case "s" :
//		        					
//		        					commandCenterList.get(number).produceScv();		// (number)번 커맨드에서 SCV 생산 (작동안함)
//			        		//	System.out.println("SCV 생산을 완료?");
//		        					human.playerSource();
//
//		        					System.out.println("현재 미네랄은 :" + human.getMinerals());
//		        					human.playerSource();
//		        					break;
//			        			
//		        				case "b" :
//		        					break;
//		        					
//			        			case "q" :
//			        			System.out.println( " 되돌아갑니다. " );
//			        			break;											// 7번의 switch문 종료
//			        			
//			        			default :
//			        				System.out.println("에러코드 58");
//			        				break;
//			        	}
//			        	break;
//		      }
//		      break;
//			        	
//		
 * 
 */
	
	/*
	 * 	public void gatherMineral() {
		// 커맨드 센터가 존재해야함.
		if (CommandCenter.getCommandCenterCount() <= 0) {
			System.out.println("커맨드 센터가 없습니다.");
		}
		if (CommandCenter.getCommandCenterCount() >= 1) {
			CommandCenter mineralCenter = (CommandCenter) player.getBuildingList().get(0);		//명시적 형변환
			System.out.println("미네랄을 채굴합니다");
			
			Timer timer = new Timer();		//타이머 생성
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					mineralCenter.increaseMinerals();
				}
			} , 5000 , 5000);
				//만약 SCV가 사망한다면, timer cancle;
		
		}
		else System.out.println(" 미네랄 채굴 오류입니다 ");
	}
			public void gatherGas() {
		// 커맨드 센터가 존재해야함.
		if (CommandCenter.getCommandCenterCount() <= 0) {
			System.out.println("커맨드 센터가 없습니다.");
		}
		else if (Refinery.getRefineryCount() <= 0) {
			System.out.println("정제소를 설치하세요");
		}
		else if (CommandCenter.getCommandCenterCount() >= 1) {
			CommandCenter gasCenter = (CommandCenter) player.getBuildingList().get(0);		//명시적 형변환
			System.out.println("가스를 채굴합니다");
			
			Timer timer = new Timer();		//타이머 생성
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					gasCenter.increaseGas();
				}
			} , 5000 , 5000);
				//만약 SCV가 사망한다면, timer cancle
		
		}
		else System.out.println(" 미네랄 채굴 오류입니다 ");
	}
	
	 * 
	 * 
	 * 			
		/*
		 *     if (player.getBuildingList().get(0) instanceof CommandCenter) {
            CommandCenter commandCenter = (CommandCenter) player.getBuildingList().get(0);
            commandCenter.increaseMinerals(Data.SCV_M);

            // 5초에 1번씩 8미네랄 캐기
            mineralGatheringTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    commandCenter.increaseMinerals(Data.SCV_M);
                }
            }, 5000, 5000);  // 5초 후에 시작하고, 그 이후 5초마다 반복
        } else {
            System.out.println("자원을 캘 수 있는 건물이 없습니다.");
        }
    }
    
    		// 게임 시작 로직 실행
		//	ProduceHelper produceHelper = ProduceHelper.getInstance();	//싱글톤 객체 생성
		//게임 시작 버튼
/*		//플레이어 생성
		Player human = new Player("김태연");
		Player computer = new Player("computer");

		CommandCenter commandCenter = new CommandCenter(human);
		commandCenter.produceScv();
		commandCenter.produceScv();
		commandCenter.produceScv();
		commandCenter.produceScv();

		CommandCenter commandCenter2 = new CommandCenter(computer);
		commandCenter2.produceScv();
		commandCenter2.produceScv();
		commandCenter2.produceScv();
		commandCenter2.produceScv();
		
			/*	System.out.println("----------------------- 게임 시작합니다 -------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(human.getBuildingList());
		System.out.println(human.getUnitList());
		*/
		
	
	//여기서부터 MainMenu
//	Scanner scanner = new Scanner(System.in); 이것도 메인메뉴 실행칸으로 옮김
/*	System.out.println("유닛 창을 보여줍니다");
	System.out.println(game.getHuman().getListOfType(Unit.class));

	String input;

	while (true) {
		System.out.println("------------------------------------- 패널 화면 -------------------------------------");
		System.out.println("패널 화면입니다. 기능을 선택하세요 ( b : 건물 선택하기, u : 유닛 선택하기, q : 종료");
		// human.scheduleShowResources();

		input = scanner.next();
	
	try {
		switch (input.toLowerCase()) {
		case "b":
			BuildingController.controlBuilding(game.getHuman(), scanner);
			//자바 예외처리
			break;
		case "u":
			UnitController.controlUnit(game.getHuman(), scanner);
			break;
		case "q":
			System.out.println("패널 화면을 종료합니다");
			scanner.close();
			return;

		default:
			System.out.println("잘못된 입력입니다");
			break;

		} // switch 문 종료
	} catch (Exception e) {
		  System.out.println("오류가 발생했습니다: " + e.getMessage());
     //   e.printStackTrace();  // 실제 프로덕션 코드에서는 로그로 기록하는 것이 좋습니다.

	}
}


*/
	
	
	/*	public synchronized void ShowResources() {
	System.out.println("현재 자원을 표시합니다");
	System.out.printf(this.playerName + "의 미네랄 : " + this.minerals);
	System.out.printf("\t");
	System.out.printf(this.playerName + "의 가스 : " + this.gas);
	System.out.printf("\t");
	System.out.println(this.playerName + "의 인구수 : " + this.population);
	return;
}

public synchronized void scheduleShowResources() {
Runnable showResources = this::ShowResources;
scheduler.scheduleAtFixedRate(showResources, 0, 10, TimeUnit.SECONDS);
}

*/
	
	
	/*
	 * 	public void stop() {		//파라미터 변수를 받을지 고민중
		stopFighting();
		stopMoving();
		setState(State.staying);
	}
	
	private void delay() {
	    try {
	        Thread.sleep(1000); // 1초 딜레이
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        stop();
	    }
	}
	
	public void stopMoving() {
		Thread.currentThread().interrupt(); // InterruptedException 발생
		setState(State.staying);
	}
	
	public void stopFighting() {
		Thread.currentThread().interrupt(); // InterruptedException 발생
	    setState(State.staying);
	}
	@Override
	public void move(int x, int y) {		//x : 목표 x 좌표, y : 목표 y 좌표
		setState(State.moving);			// 이동중 상태로 변경
    	int distanceX = Math.abs(x - getX());
    	int distanceY = Math.abs(y - getY());

		if (distanceX >= distanceY) {
			//x축 이동
			for ( int i = 0; i < distanceX; i++) {
			delay();
			setX(getX()+1);
			System.out.println("x축 이동중입니다");
			}
			System.out.println("x축 이동 끝");
		}
		else if ( distanceX < distanceY) {
			//y축 이동
			for (int i = 0; i< distanceY; i++) {
				delay();
			setY(getY()+1);
			System.out.println("y축 이동중입니다");
			}
			System.out.println("y축 이동 끝");
		}
		
		setState(state.staying);	// 대기 상태로 변경
	}


	@Override
	public void attack(Unit unit1, Unit unit2) {
		// uni2 의 현재 체력이 0 이상일 때
		// 유닛2의 위치가 유닛1의 사거리 안에 있을 때
		// 유닛 1의 체력 현재체력 - (유닛1공격력 - 유닛2의방어력) 으로 설정.

		while (unit2.currentHp > 0) {
			if (unit1.range > (Math.abs(unit1.x - unit2.x) + Math.abs(unit1.y - unit2.y))) {
				unit1.setCurrentHp(unit1.getCurrentHp() - (unit1.getAtk() - unit2.getDef()));
				System.out.println(unit1.getName() + "이 " + unit2.getName() + "을 공격합니다.");
				setState(State.fighting);
				delay();
			}
		}
	}
	 * 
	 */
	
	
	/*		if (distanceX == 0 && distanceY == 0) {			//만약 x축 거리 = y축 거리 = 0 일 경우 stop(); = 상태를 staying으로 바꿈
	System.out.println("이동이 끝났습니다.");
	System.out.println("현재 위치는 : (" + getX() + ", "+ getY() + ")");
	stop();
} else if (distanceX >= distanceY) {			// x 거리가 y 거리보다 멀면 1초 기다리고 x축으로 1 칸 이동
	delay();								
	setX(getX() + 1);
	System.out.println(getName() + "이 x축 이동했습니다");
	System.out.println("현재 위치는 : (" + getX() + ", "+ getY() + ")");
} else if (distanceX < distanceY) {				// y 거리가 x 거리보다 멀면 1초 기다리고 y축으로 1 칸 이동
	delay();
	setY(getY() + 1);
	System.out.println(getName() + "이 y축 이동했습니다");
	System.out.println("현재 위치는 : (" + getX() + ", "+ getY() + ")");
}

}
	

		
		// 만약 제어할수있는 유닛 리스트가 0개이면 제어할수 없다는 오류 띄우기
		input = scanner.next(); // 값 입력하기(ex:2)
		// try,catch 구문으로 잘못된 입력값 잡아주기
	
		System.out.println(input + "번을 선택하셨습니다."); // 3. 입력값 확인해준다
	

		 * if (input.equals("0")) { human.getControlUnitList().addAll(scvList); // 모든
		 * SCV를 ControlUnitList 로 옮긴다. }
		
		number = Integer.parseInt(input) - 1; // 4. number 값을 입력값-1 로 해준다.(배열이기때문)
		System.out.println(" SCV 메뉴입니다. m : 미네랄 캐기, g : 가스 캐기, q : 종료"); // 5. 메뉴 선택창을 출력한다.
		input = scanner.next(); // 입력값을 다시 오픈
	
	
 */
	
	/*
	 * /*
	public static void controlScv(Player human, Scanner scanner) {

		List<Scv> scvList = human.getListOfType(Scv.class);

		while (true) {
			if(scvList.size()==0)
			{System.out.println("유닛이 없습니다.");
			break;
			}
			System.out.println(scvList);
			System.out.println(" 사용할 유닛 번호를 고르세요 , 0 : 전체 선택, q : 종료 "); // 

			int unitNumber = getUnitNumber(scanner, scvList.size());

			if (unitNumber == -1) {
				// 유닛 전체 선택 시
				System.out.println("유닛 전체를 선택했습니다.");

				for (Scv scv : scvList) {
					handleScvMenu(scv, scanner);
				}
			} else {
				// 개별 유닛 선택 시
				System.out.println(scvList.get(unitNumber).getName() + "을(를) 선택했습니다.");
				handleScvMenu(scvList.get(unitNumber), scanner);
			}
		}
	}


	private static void handleScvMenu(Scv scv, Scanner scanner) {
	        System.out.println("SCV 메뉴입니다. m: 미네랄 캐기, g: 가스 캐기, q: 종료");
	        String input = scanner.next().toLowerCase();
	
	        switch (input) {
	            case "m":
	                scv.gatherMineral();
	                break;
	
	            case "g":
	                scv.gatherGas();
	                break;
	
	            case "q":
	                System.out.println("되돌아갑니다.");
	                break;
	
	            default:
	                System.out.println("에러코드 72");
	                break;
	        }
	    }

	public static void controlMarine(Player human, Scanner scanner) {
		String input;
		int number;
		List<Marine> marineList = human.getListOfType(Marine.class);
		System.out.println(marineList);
		System.out.println(" 사용할 유닛 번호를 고르세요 "); // 2. 몇번 커맨드 센터를 사용할지 물어본다
		input = scanner.next(); // 값 입력하기(ex:2)
		System.out.println(input + "번을 선택하셨습니다."); // 3. 입력값 확인해준다
		number = Integer.parseInt(input) - 1; // 4. number 값을 입력값-1 로 해준다.(배열이기때문)
		System.out.println(" 메뉴를 선택하세요. a : 유닛 공격, m : 유닛 이동, q : 종료"); // 5. 메뉴 선택창을 출력한다.
		input = scanner.next(); // 입력값을 다시 오픈

		switch (input.toLowerCase()) {
		case "a":
			System.out.println("아직 구현하지 못했습니다. 마린 공격");
			break;

		case "m":
			System.out.println("아직 구현하지 못했습니다. 마린 이동");
			break;

		case "q":
			System.out.println("되돌아갑니다.");
			break;

		default:
			System.out.println("에러코드 101");
			break;
		}
	}

	public static void controlMedic(Player human, Scanner scanner) {
		String input;
		int number;
		List<Medic> medicList = human.getListOfType(Medic.class);
		System.out.println(medicList);
		System.out.println(" 사용할 유닛 번호를 고르세요 "); // 2. 몇번 커맨드 센터를 사용할지 물어본다
		input = scanner.next(); // 값 입력하기(ex:2)
		System.out.println(input + "번을 선택하셨습니다."); // 3. 입력값 확인해준다
		number = Integer.parseInt(input) - 1; // 4. number 값을 입력값-1 로 해준다.(배열이기때문)
		System.out.println(" 메뉴를 선택하세요. a : 유닛 공격, m : 유닛 이동, q : 종료"); // 5. 메뉴 선택창을 출력한다.
		input = scanner.next(); // 입력값을 다시 오픈

		switch (input.toLowerCase()) {
		case "a":
			System.out.println("아직 구현하지 못했습니다. 메딕 공격");
			break;

		case "m":
			System.out.println("아직 구현하지 못했습니다. 메딕 이동");
			break;

		case "q":
			System.out.println("되돌아갑니다.");
			break;

		default:
			System.out.println("에러코드 133");
			break;
		}
	}

	 */

}
