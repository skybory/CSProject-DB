package Starcraft.taeyoun.building;

import java.util.Timer;
import java.util.TimerTask;

import Starcraft.taeyoun.building.Building.State;
import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.resource.map.Locatable;
import Starcraft.taeyoun.resource.map.Map;
import Starcraft.taeyoun.unit.Marine;
import Starcraft.taeyoun.unit.Scv;
import Starcraft.taeyoun.unit.Unit;

public class CommandCenter extends Building implements Locatable {

	private Player player;
	private static int commandCenterCount = 0;
	private int x;
	private int y;

	public CommandCenter(Player player, int x, int y) {				// 커맨드센터를 만들때 입력해야 하는 값은 플레이어와 좌표값이다.
		super(player,												// 나머지 정보값은 CommandCenter에서 부모클래스인 Building으로 보낸다.
				Data.COMMANDCENTER_NAME,
				Data.COMMANDCENTER_M,
				Data.COMMANDCENTER_G,
				Data.COMMANDCENTER_HP,
				x,
				y,
				State.staying);
		this.player = player;
		this.x = x;
		this.y = y;
		player.setPopulation(player.getPopulation() + 10);
		player.getBuildingList().add(this);
		incrementCountCommandCenter();
	}

	public void produceScv() {										// scv를 만드는 메서드다.
		if (commandCenterCount > 0) {
			if (getProduceHelper().validCheck(player, Data.SCV_M, Data.SCV_G, Data.SCV_P)) {
				// x+1 자리에 유닛이 없다면
				System.out.println("SCV 생산 중...");
				 final int[] produceX = {0};
		            int i = 1;
		            while (Map.getCell(x + i, y).isUnit()) {		// 유닛을 생산가능한 자리를 찾고, 유닛을 생산가능한 자리(=빈 자리)에 유닛을 생산한다.
		                produceX[0] = x + i + 1;
		                i++;										// 잘 작동하지 않아서 수정이 필요해보인다.
		            }
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						Unit scv = new Scv(player, produceX[0], y);
						player.addUnit(scv);
						timer.cancel();
					}
				}, Data.SCV_TIME * 100);
				return; // 빈 구역을 찾았으므로 바로 종료
			} else {
				System.out.println("빈 공간이 없습니다.");
			}
		} else
			System.out.println("커멘드 센터를 지으세요");
	}
	private static void incrementCountCommandCenter() {
		commandCenterCount++;
	}

	public static int getCommandCenterCount() {
		return commandCenterCount;
	}

	public void increaseMinerals() {
		player.setMinerals(player.getMinerals() + 8);
	}

	public void increaseGas() {
		player.setGas(player.getGas() + 8);
	}

}
