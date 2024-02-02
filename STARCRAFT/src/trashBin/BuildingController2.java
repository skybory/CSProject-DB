/*Wpackage com.taeyoun.application;

import java.util.List;
import java.util.Scanner;

import com.taeyoun.building.Building;
import com.taeyoun.resource.Player;

public class BuildingController2 {
	
	public static void controlBuilding(Player human, Scanner scanner, Class<? extends Building> BuildingType) {
        List<? extends Building> BuildingList = human.getListOfType(BuildingType);
        while (true) {
            if (BuildingList.size() == 0) {
                System.out.println("유닛이 없습니다.");
                break;
            }
            System.out.println(BuildingList);
            System.out.println(" 사용할 유닛 번호를 고르세요 , 0 : 전체 선택, q : 종료 ");

            int BuildingNumber = getBuildingNumber(scanner, BuildingList.size());

            if (BuildingNumber == -1) {
                // 유닛 전체 선택 시
                System.out.println("유닛 전체를 선택했습니다.");

                for (Building Building : BuildingList) {
                    handleBuildingMenu(Building, scanner);
                }
            } else {
                // 개별 유닛 선택 시
                System.out.println(BuildingList.get(BuildingNumber).getName() + "을(를) 선택했습니다.");
                handleBuildingMenu(BuildingList.get(BuildingNumber), scanner);
            }
        }
    }
        
    private static int getBuildingNumber(Scanner scanner, int maxNumber) {
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.next(); // 잘못된 입력 무시
            }

            int input = scanner.nextInt();
            if (input == 0 || (input >= 1 && input <= maxNumber)) {
                return input - 1;
            } else {
                System.out.println("잘못된 유닛 번호입니다. 다시 선택하세요.");
            }
        }
    }

    private static void handleBuildingMenu(Building Building, Scanner scanner) {
        System.out.println("유닛 메뉴입니다. 추가 메뉴를 구현하세요.");
        // 빌딩 메뉴 처리 로직 추가
    }

    

	public static void controlScv(Player human, Scanner scanner) {

		List<Scv> scvList = human.getListOfType(Scv.class);

		while (true) {
			if(scvList.size()==0)
			{System.out.println("유닛이 없습니다.");
			break;
			}
			System.out.println(scvList);
			System.out.println(" 사용할 유닛 번호를 고르세요 , 0 : 전체 선택, q : 종료 "); // 2. 몇번 커맨드 센터를 사용할지 물어본다

			int BuildingNumber = getBuildingNumber(scanner, scvList.size());

			if (BuildingNumber == -1) {
				// 유닛 전체 선택 시
				System.out.println("유닛 전체를 선택했습니다.");

				for (Scv scv : scvList) {
					handleScvMenu(scv, scanner);
				}
			} else {
				// 개별 유닛 선택 시
				System.out.println(scvList.get(BuildingNumber).getName() + "을(를) 선택했습니다.");
				handleScvMenu(scvList.get(BuildingNumber), scanner);
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

}*/
package trashBin;

