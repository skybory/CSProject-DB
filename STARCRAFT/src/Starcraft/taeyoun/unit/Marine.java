package Starcraft.taeyoun.unit;

import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;


public class Marine extends Unit{					// 마린 유닛에 대한 정보를 담고있다. Building과 같은 로직이라, 잘 이해가 가지 않는다면
	private int x;									// CommadCenter 클래스에 적혀있는 주석을 참고하면 좋을것같다.
	private int y;
	private Player player;

	public Marine(Player player, int x, int y) {
		super(player,
				Data.MARINE_NAME,
				Data.MARINE_HPMAX,
				Data.MARINE_HPMAX,
				Data.MARINE_ATK,
				Data.MARINE_DEF,
				Data.MARINE_ATKRANGE,
				x,
				y,
				Unit.State.staying,
				Data.MARINE_STATEMENT1,
				Data.MARINE_STATEMENT2,
				Data.MARINE_STATEMENT1,
				Data.MARINE_STATEMENT2
				);
		this.player = player;
		this.x = x;
		this.y = y;
		System.out.println(Data.MARINE_STATEMENT1);
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
