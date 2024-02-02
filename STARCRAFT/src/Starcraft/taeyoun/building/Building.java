package Starcraft.taeyoun.building;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.resource.ProduceHelper;
import Starcraft.taeyoun.resource.map.Locatable;
import Starcraft.taeyoun.resource.map.Map;

public class Building implements Locatable{
	
	private Player player;
	private String name;
	private int mineralCost;
	private int gasCost;
	private int maxHp;
	private int x;
	private int y;
	private ProduceHelper produceHelper;
	private State state;
	public enum State {
		    staying, producing
		    }

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
					//빌딩은 플레이어,	건물이름,		 미네랄가격,			  가스가격,	  최대체력,	건물의x좌표, 건물의y좌표, 상태 에 대한 정보를 반드시 가진다.
	public Building( Player player, String name, int mineralCost, int gasCost, int maxHp, int x, int y, State state) {
		super();
		this.player = player;
		this.name = name;
		this.mineralCost = mineralCost;
		this.gasCost = gasCost;
		this.maxHp = maxHp;
		this.produceHelper = ProduceHelper.getInstance();
		this.x = x;
		this.y = y;
		this.state = state;
	}
	
	public boolean isAreaEmpty(int x, int y) {					// 유닛을 생산할 때 유닛이 생산될 자리가 있는지 판단하는 메서드이다.
	    for (int i = 0; i < 5; i++) {							// 건물을 기준으로, 5*5 위치에 빈자리가 하나라도 있으면 true값을 반환하고, 그 자리값에 유닛을 생성한다.
	        for (int j = 0; j < 5; j++) {
	            if (Map.getCell(x + i, y + j).isUnit()) {
	            												// 여기에 그 자리값을 반환해서, 건물에 보내주는 코드를 추가해야한다.
	                return true;								// 하나라도 빈자리가 있으면 true 반환.
	                											// 보완이 필요한 코드다.!!!
	            }
	        }
	    }
	    return false;
	}

	public ProduceHelper getProduceHelper() {
	        return produceHelper;
	 }
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMineralCost() {
		return mineralCost;
	}

	public void setMineralCost(int mineralCost) {
		this.mineralCost = mineralCost;
	}

	public int getGasCost() {
		return gasCost;
	}

	public void setGasCost(int gasCost) {
		this.gasCost = gasCost;
	}

	
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	@Override
	public String toString() {
		 return "Building<" + (player.getBuildingList().indexOf(this) + 1) + "> : " + name;
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
