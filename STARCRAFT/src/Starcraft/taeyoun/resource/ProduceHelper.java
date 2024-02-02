package Starcraft.taeyoun.resource;
public class ProduceHelper {

	// 싱글톤

	private static ProduceHelper produceHelper;
	public static ProduceHelper getInstance() { 
		if (produceHelper == null) { 
			produceHelper = new ProduceHelper(); 
		}
		return produceHelper;
	}

	public static void freeInstance() {
		produceHelper = null;
	}

	// 싱글톤 생성 끝

	
	
	public boolean isMineral(Player p, int CostM) {
		if (p.getMinerals() < CostM)
			return false;
		else
			return true;
	}

	public boolean isGas(Player p, int CostG) {
		if (p.getGas() < CostG)
			return false;
		else
			return true;
	}

	public boolean isPopulation(Player p, int CostP) {
		if (p.getPopulation() < CostP)						//인구수는 거꾸로 계산!
			return false;
		else
			return true;
	}

	public boolean validCheck(Player player, int CostM, int CostG, int CostP) {
		if (!isPopulation(player, CostP)) {
			System.out.println("서플라이 디팟을 더 지으세요");
			return false;
		}
		if (!isMineral(player, CostM)) {
			System.out.println("미네랄이 부족합니다");
			return false;
		}
		if (!isGas(player, CostG)) {
			System.out.println("가스가 부족합니다");
			return false;
		} else {
			// System.out.println("valid check 성공"); //이 메서드가 호출되는지 확인용
			player.setMinerals(player.getMinerals() - CostM);
			player.setGas(player.getGas() - CostG);
			player.setPopulation(player.getPopulation() - CostP);
			return true;
		}
	}
}
