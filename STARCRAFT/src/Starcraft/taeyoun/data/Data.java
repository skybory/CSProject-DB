package Starcraft.taeyoun.data;
public abstract class Data {
	
	// 게임의 데이터값이다. STATEMENT 2,3,4는 구현하지 못했다. 상황에 따라 다른 대사를 만들려고 기획했다.
	
	//SCV
		public static final String SCV_NAME = "TERRAN SCV";
		public static final String SCV_STATEMENT1 = "SCV GOOD TO GO SIR";
		public static final String SCV_STATEMENT2 = "SCV입니다2.";
		public static final int SCV_HP = 60;
		public static final int SCV_M = 50;
		public static final int SCV_G = 0;
		public static final int SCV_P = 1;
		public static final int SCV_TIME = 10;
		public static final int SCV_HPMAX = 60;
		public static final int SCV_ATK = 5;
		public static final int SCV_DEF = 1;
		public static final int SCV_ATKRANGE = 1;
		
		
	//MARINE
		public static final String MARINE_NAME = "TERRAN Marine";
		public static final String MARINE_STATEMENT1 = "한 판 붙어볼까, 애송이?";
		public static final String MARINE_STATEMENT2 = "전투준비완료. 명령만 내리십쇼(마린)";
		public static final String MARINE_STATEMENT3 = "전투중.(마린)";
		public static final String MARINE_STATEMENT4 = "사망했습니다.(마린)";
		public static final int MARINE_M = 50;
		public static final int MARINE_G = 0;
		public static final int MARINE_P = 1;
		public static final int MARINE_TIME = 24;
		public static final int MARINE_HPMAX = 40;
		public static final int MARINE_ATK = 6;
		public static final int MARINE_DEF = 1;
		public static final int MARINE_ATKRANGE = 5;
		
		
	//MEDIC
		public static final String MEDIC_NAME = "TERRAN Medic";
		public static final String MEDIC_STATEMENT1 = "Prepped and ready.";
		public static final String MEDIC_STATEMENT2 = "메딕대사2번.";
		public static final int MEDIC_M = 75;
		public static final int MEDIC_G = 25;
		public static final int MEDIC_P = 1;
		public static final int MEDIC_TIME = 25;
		public static final int MEDIC_HPMAX = 60;
		public static final int MEDIC_ATK = 0;
		public static final int MEDIC_DEF = 3;
		public static final int MEDIC_ATKRANGE = 0;
		
		
	//COMMANDCENTER
		
		public static final String COMMANDCENTER_NAME = "TERRAN Command Center";
		public static final String COMMANDCENTER_STATEMENT = "COMMANDCENTER입니다.";
		public static final int COMMANDCENTER_HP = 2500;
		public static final int COMMANDCENTER_M = 400;
		public static final int COMMANDCENTER_G = 0;
		public static final int COMMANDCENTER_TIME = 75;
	//BARRACKS
		public static final String BARRACKS_NAME = "TERRAN Barracks";
		public static final String BARRACKS_STATEMENT = "BARRACKS입니다.";
		public static final int BARRACKS_HP = 1500;
		public static final int BARRACKS_M = 150;
		public static final int BARRACKS_G = 0;
		public static final int BARRACKS_TIME = 50;
	//SUPPLYDEPOT
		
		public static final String SUPPLYDEPOT_NAME = "TERRAN Supply Depot";
		public static final String SUPPLYDEPOT_STATEMENT = "Supply Depot입니다.";
		public static final int SUPPLYDEPOT_HP = 500;
		public static final int SUPPLYDEPOT_M = 100;
		public static final int SUPPLYDEPOT_G = 0;
		public static final int SUPPLYDEPOT_TIME = 40;

		public static final String REFINERY_NAME = "TERRAN Refinery";
		public static final String REFINERY_STATEMENT = "Refinery입니다.";
		public static final int REFINERY_HP = 750;
		public static final int REFINERY_M = 100;
		public static final int REFINERY_G = 0;
		public static final int REFINERY_TIME = 40;
		
	}

