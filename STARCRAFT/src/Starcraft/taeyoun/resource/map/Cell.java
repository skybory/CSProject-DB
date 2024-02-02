package Starcraft.taeyoun.resource.map;

import Starcraft.taeyoun.unit.Unit;

public class Cell {
	//좌표칸 만들기 ( 맵의 기본 구성요소 ) 
	private int x;
	private int y;
	private Unit unit;
	
	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.unit = null; // 초기값은 유닛이 없다고 가정
	}

	public boolean isUnit() {
		if (this.unit == null) {
			return false;
		} else {
			return true;
		}
	}
	
	//건물이 있을 수도 있음. 그거 생각못햇넹..

	public Unit getUnit() {
		return this.unit;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
}

