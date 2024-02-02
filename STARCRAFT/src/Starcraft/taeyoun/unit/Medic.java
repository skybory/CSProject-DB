package Starcraft.taeyoun.unit;

import Starcraft.taeyoun.data.Data;
import Starcraft.taeyoun.resource.Player;

public class Medic extends Unit{
	private int x;
	private int y;
	
	public Medic(Player player, int x, int y) {
		super(player,
				Data.MEDIC_NAME,
				Data.MEDIC_HPMAX,
				Data.MEDIC_HPMAX,
				Data.MEDIC_ATK,
				Data.MEDIC_DEF,
				Data.MEDIC_ATKRANGE,
				x,
				y,
				Unit.State.staying,
				Data.MEDIC_STATEMENT1,
				Data.MEDIC_STATEMENT2,
				Data.MEDIC_STATEMENT1,
				Data.MEDIC_STATEMENT2);
		System.out.println(Data.MEDIC_STATEMENT1);
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
