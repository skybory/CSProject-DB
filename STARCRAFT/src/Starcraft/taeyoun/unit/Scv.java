package Starcraft.taeyoun.unit;

import Starcraft.taeyoun.building.Barracks;
import Starcraft.taeyoun.building.Building;
import Starcraft.taeyoun.building.CommandCenter;
import Starcraft.taeyoun.building.Refinery;
import Starcraft.taeyoun.building.SupplyDepot;
import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.resource.ProduceHelper;
import Starcraft.taeyoun.resource.map.Locatable;
import Starcraft.taeyoun.resource.map.Map;
import Starcraft.taeyoun.unit.Unit.State;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scv extends Unit implements Attack, Locatable{

	private ProduceHelper produceHelper = ProduceHelper.getInstance();			//SCV는 생산유닛이기 때문에 싱글톤 ProduceHelper 의 인스턴스를 받아와서, 생산 기능에 도움을 받는다.
	private final Player player;
    private ScheduledExecutorService executorService;
	private int x;
	private int y;
	
	public Scv(Player player, int x, int y) {
		super(
				player,
				Data.SCV_NAME,
				Data.SCV_HPMAX,
				Data.SCV_HPMAX,
				Data.SCV_ATK,
				Data.SCV_DEF,
				Data.SCV_ATKRANGE,
				x,
				y,
				Unit.State.staying,
				Data.SCV_STATEMENT1,
				Data.SCV_STATEMENT2,
				Data.SCV_STATEMENT1,
				Data.SCV_STATEMENT2
				);
		this.x = x;
		this.y = y;
		System.out.println(Data.SCV_STATEMENT1);
		System.out.println("내 x좌표는 : (" + getX() + "," + getY() + ")");
		this.player = player;
		this.executorService = Executors.newSingleThreadScheduledExecutor();
		Map.getCell(x,y).setUnit(this);										// SCV가 생산시에 커멘드센터로부터(또는 자기 자신을 생산하는 건물로부터)입력받은 x,y 값의 Cell에 유닛을 놓는다.
	}
	@Override
	public void stop() {													// 건물 생산중이면 멈추지 않고, 그렇지 않을 경우에 유닛의 행동을 멈춘다.
		if(this.getState()!=State.building) {								// 건물 생산중을 취소하는 방법은 구현되지 않았다.
		this.executorService.shutdown();
		setState(State.staying);
    	System.out.println("유닛을 멈춥니다.");
    	delay();
		}
	}
	@Override
	public void move(int x, int y) {										// 이동메서드이다. 매초마다 유닛의 좌표를 1칸씩 옮기면서 최적의 경로를 판단하고
		stop();																// 만약 유닛이 목적지에 도착했다면 "이동이 종료됩니다" 문구를 프린트한다.
		executorService = Executors.newScheduledThreadPool(1);				// 해당 인터페이스에 대한 설명은
																			// https://mangkyu.tistory.com/259 이 링크를 보고 공부했는데, 굉장히 친절히 설명되어있으니 꼭 보길 바란다.
		delay();
		setState(State.moving);
		System.out.println("이동 명령을 시작합니다!!!");
		
		executorService.scheduleAtFixedRate(() -> {
	
			System.out.println("이 유닛의 x좌표는 : " + getX()); // 내 x좌표
			System.out.println("이 유닛의 y좌표는 : " + getY()); // 내 y좌표
			
			int distanceX = Math.abs(x - getX()); // x축 거리
			int distanceY = Math.abs(y - getY()); // y축 거리
			
			System.out.println("x거리는" + distanceX + "입니다");
			System.out.println("y거리는" + distanceY + "입니다");
			
			if (distanceX == 0 && distanceY == 0) {
				System.out.println("이동이 종료됩니다.");
				System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
				stop();

			} else if (Math.abs(distanceX) >= Math.abs(distanceY)) {
				setX(getX() + Integer.compare(x, getX())); // 현재 위치에서 목표 지점 방향으로 1 칸 이동
				Map.getCell(getX(),getY()).setUnit(null);
				Map.getCell(getX() + Integer.compare(x, getX()),getY()).setUnit(this);
				System.out.println(getName() + "이 x축 이동했습니다");
				System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
			}

			else {
				setY(getY() + Integer.compare(y, getY())); // 현재 위치에서 목표 지점 방향으로 1 칸 이동
				Map.getCell(getX(),getY()).setUnit(null);
				Map.getCell(getX(),getY() + Integer.compare(y, getY())).setUnit(this);
				System.out.println(getName() + "이 y축 이동했습니다");
				System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
			}
			
	        if (getX() == x && getY() == y) {
	            // 목표 지점에 도달했을 때 작업 종료
	            System.out.println("이동이 종료됩니다.");
	            System.out.println("현재 위치는 : (" + getX() + ", " + getY() + ")");
	            stop();
	        }
		}, 1, 1, TimeUnit.SECONDS);
}
	
	//이건 gatherMineral 이 SCV에만 있는 특수 기능이라서 SCV에 stop을 오버라이딩 시켜놔야 되는것같다.
	
	public void gatherMineral() {
		if (getState() == State.staying) {
			executorService = Executors.newScheduledThreadPool(1);
			
			setState(State.gathering);
			System.out.println("미네랄을 캐러갑니다!!!");
			executorService.scheduleAtFixedRate(() -> 
				{
					player.setMinerals(player.getMinerals() + 8);
//	/*보여주기용*/		System.out.println(player.getMinerals());			// 미네랄이 올라가는것을 보고싶으면 이 메서드의 주석을 제거하면 된다.
				}
				, 0, 5, TimeUnit.SECONDS);
		} else
			System.out.println("바빠서 명령을 수행할 수 없습니다.");
	}
	


	public void gatherGas() {
		if (player.isRefinery()) {
			executorService = Executors.newScheduledThreadPool(1);
		
		if (getState() == State.staying) {
			setState(State.gathering);
			System.out.println("가스를 캐러갑니다!!!");
			executorService.scheduleAtFixedRate(() -> 
			{
				player.setGas(player.getGas() + 8);
//				System.out.println(player.getGas());
			}
			, 0, 5, TimeUnit.SECONDS);
		} else
			System.out.println("바빠서 명령을 수행할 수 없습니다.");
	}
		else
			System.out.println("정제소를 설치해주세요.");
	}

	public void produceCommandCenter(int x, int y) {				//커멘드 센터를 생산하는 메서드이다. 
		if (getState() != State.staying) {							// Scv가 Staying 상태가 아니라면 일을 시키지 않고
			System.out.println("다른 일을 하는 중입니다.");
		} else if (produceHelper.validCheck(player, Data.COMMANDCENTER_M, Data.COMMANDCENTER_G, 0))
																	// Staying 상태이면서 자원이 있으면 건설을 시작한다.
			{
			setState(State.building);
		System.out.println("건설을 시작합니다.");
		executorService = Executors.newScheduledThreadPool(1);
		executorService.schedule(() -> {
			Building CommandCenter = new CommandCenter(player, x, y);
			setState(State.staying);
			stop();
			System.out.println(CommandCenter.getName() + " 이 완성되었습니다.");
		}, Data.COMMANDCENTER_TIME, TimeUnit.SECONDS);
	
			}
	}

	public void produceBarracks(int x, int y) {						// 커멘드센터와 개념은 똑같다.
		if (getState() != State.staying) {
			System.out.println("다른 일을 하는 중입니다.");
		} else if (produceHelper.validCheck(player, Data.BARRACKS_M, Data.BARRACKS_G, 0))
		{
			setState(State.building);
		System.out.println("건설을 시작합니다.");
		executorService = Executors.newScheduledThreadPool(1);
		executorService.schedule(() -> {
			Building Barracks = new Barracks(player, x, y);
			setState(State.staying);
			stop();
			System.out.println(Barracks.getName() + " 이 완성되었습니다.");
		}, Data.BARRACKS_TIME, TimeUnit.SECONDS);
	}
	}
	public void produceSupplyDepot(int x, int y) {
		if (getState() != State.staying) {
			System.out.println("다른 일을 하는 중입니다.");
		} else if (produceHelper.validCheck(player, Data.SUPPLYDEPOT_M, Data.SUPPLYDEPOT_G, 0))
		{
			setState(State.building);
		System.out.println("건설을 시작합니다.");
		executorService = Executors.newScheduledThreadPool(1);
		executorService.schedule(() -> {
			Building SupplyDepot = new SupplyDepot(player, x, y);
			setState(State.staying);
			stop();
			System.out.println(SupplyDepot.getName() + " 이 완성되었습니다.");
		}, Data.SUPPLYDEPOT_TIME, TimeUnit.SECONDS);
	}
	}
	public void produceRefinery(int x, int y) {
		if (getState() != State.staying) {
			System.out.println("다른 일을 하는 중입니다.");
		} else if (produceHelper.validCheck(player, Data.REFINERY_M, Data.REFINERY_G, 0))
		{
			setState(State.building);
		System.out.println("건설을 시작합니다.");
		executorService = Executors.newScheduledThreadPool(1);
		executorService.schedule(() -> {
			Building Refinery = new Refinery(player, x, y);
			setState(State.staying);
			stop();
			System.out.println(Refinery.getName() + " 이 완성되었습니다.");
		}, Data.REFINERY_TIME, TimeUnit.SECONDS);
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