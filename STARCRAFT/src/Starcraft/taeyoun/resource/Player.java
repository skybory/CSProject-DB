package Starcraft.taeyoun.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Starcraft.taeyoun.building.Building;
import Starcraft.taeyoun.building.CommandCenter;
import Starcraft.taeyoun.unit.Scv;
import Starcraft.taeyoun.unit.Unit;

public class Player {				// 플레이어에 대한 정보를 담는 클래스다.
	private String playerName;		// 게임의 전반적인 흐름에 있어 가장 많이 사용되고 있는 클래스이기 때문에, Player 클래스에 대한 이해도는 반드시 높아야한다. 
	private int minerals;
	private int gas;
	private int population;
	
	ProduceHelper produceHelper;		// 생산을 도와주는 싱글톤 객체를 만들어준다.
	private List<Unit> unitList;		// 플레이어가 유닛을 보관할 수 있는 유닛리스트를 만들어준다.
	private List<Building> buildingList;	// 이하동문.
	private int refineryCount=0;
	public Player(String playerName) {
		super();
		this.minerals = 50;
		this.gas = 0;
		this.population = 0;
		this.produceHelper = ProduceHelper.getInstance();
		this.unitList = new ArrayList<>();
		this.buildingList = new ArrayList<>();
		this.playerName = playerName;
		this.refineryCount = 0;
	}
	

	public void addUnit(Unit unit) {
		getUnitList().add(unit);
		System.out.println("unitList에 " + unit.getName() + " 를(을) 추가 했습니다");
	}

	public void addBuilding(Building building) {
		getBuildingList().add(building);
		System.out.println("buildingList에 " + building.getName() + " 를(을) 추가 했습니다");
	}
	

	public void showGameStatus() {
		// 게임 상태를 보여주는 창 만들기
		System.out.println("============================================ Current Game Status =============================================");
		System.out.println("Player: " + playerName);
		System.out.println("Minerals: " + minerals);
		System.out.println("Gas: " + gas);
		System.out.println("Population: " + population);
		showUnitList();
		showBuildingList();
		System.out.println();
		System.out.println("=============================================================================================================");
	}
	
	
	
	
	public void showBuildingList() {				// Building 클래스에 속해있는 모든 객체들을 출력하는 반복문을 실행한다.
		System.out.println("Buildings:");			// 각 객체의 toString()메서드를 Override하여 보여주는데
		for (Building building : buildingList) {	// 건물의 toString()값에 상태값이 빠져있어서 (상태에 대한 정의를 프로젝트 후반부에 하면서 누락되었다) 
			System.out.printf("   " + building);	// 상태에 대한 표시를 여기서 했다. (좋지 않은 수정이다. 건물의 toString()을 고치는건 매우 쉬운 일이므로 그걸 고치는게 낫다)
			System.out.printf("\t" +  "상태 : " + building.getState() + "\n");
		}
	}
	public void showUnitList() {					// 유닛 클래스도 마찬가지로 향상된 for문을 실행해준다.
		System.out.println("Units:");				
		for (Unit unit : unitList) {				// unitList 에 있는 각각의 Unit 객체에 대한 반복문을 실행해준다.
			System.out.printf("   " + unit + "\n");
		}
	}

	
	 public <T> List<T> getListOfType(Class<T> type) {		// <T> List<T> 의 형태를 반환하는 getListOfType(클래스 이름)은 원하는 클래스 타입에 해당하는 객체를 가져오는 메서드이다.
		 													// T 는 클래스를 의미하는 알파벳이고, <T> 는 제너릭 매개변수를 나타낸다.
	        List<T> resultList = new ArrayList<>();			// 예를 들어 SCV에 대해서 메서드를 시행한다면
	        												// getListofType(SCV) 가 실행되고, SCV라는 클래스 타입에 맞는
	        												// List<SCV> resultList = new ArrayList<>(); 가 실행된다.
	        												
	        for (Building building : buildingList) {
	            if (type.isInstance(building)) {
	                resultList.add(type.cast(building));
	            }
	        }
	        for (Unit unit : unitList) {					// 그러면 여기서 (SCV는 Unit에 속하기 때문에) 모든 유닛에 대해
	            if (type.isInstance(unit)) {				// 해당 유닛이 SCV 타입에 속하는지 판단하고(isInstance 를 통해 판단)
	                resultList.add(type.cast(unit));		// Unit 클래스의 scv를 SCV 클래스의 scv로 형변환시킨다.
	            }											// 이는 SCV의 전용 기능을 사용하는것을 가능케 한다.
	        }
	        return resultList;
	    }

	 
	 
	
	 public boolean isRefinery() {
		 if (refineryCount>0) {
			 return true;
		 }
		 else
			 return false;
	 }

	 
	 
	public int getRefineryCount() {
		return refineryCount;
	}



	public void setRefineryCount(int refineryCount) {
		this.refineryCount = refineryCount;
	}



	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getMinerals() {
		return minerals;
	}
	public void setMinerals(int minerals) {
		this.minerals = minerals;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}

	public List<Unit> getUnitList() {
		return unitList;
	}
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}
	public List<Building> getBuildingList() {
		return buildingList;
	}
	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}
	
	public void increaseMinerals() {
		this.setMinerals(this.getMinerals()+8);
	}
	 
	public void increaseGas() {
		this.setGas(this.getGas()+8);
	}

}
	
	
