package Starcraft.taeyoun.application;

import java.util.List;
import java.util.Scanner;

import Starcraft.taeyoun.building.Barracks;
import Starcraft.taeyoun.building.Building;
import Starcraft.taeyoun.building.CommandCenter;
import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.unit.Unit;

public class BuildingController {	// 건물들에게 명령을 내리기 위한 클래스. 건물의 종류와 번호를 입력받고, 그에 해당하는 메뉴를 보여줌.
	
	static int buildingIndex;		// 건물 번호를 저장할 int 변수
	public static void controlBuilding(Player human, Scanner scanner, Class<? extends Building> BuildingType) {	
													// Player, Scanner, 그리고 '건물의 타입'을 클래스 변수로 받음.
													// 예를 들어서 human 플레이어의 Barracks 건물을 컨트롤하고 싶다면, 파라미터로 (human, scanner, Barracks) 를 받음.
													// 그렇다면 어떻게 세 번째 파라미터가 Barracks가 되기도 하고, CommandCenter가 되기도 하고, SupplyDepot 도 될 수 있느냐? 에 대한 대답은
													// Class<? extends Building>에 있다.
													// <? extends Building> 은 Building 클래스를 상속하는 객체면 무엇이든 올 수 있다는 표시다.
													// 따라서 저기에 barracks(객체형)도 올수있고, commandCenter(객체형) 도 올 수 있는데, 앞에 Class를 붙여놔서 결과적으로
													// Class<barracks> 또는 Class<commandCenter>가 되는것이다. 그러면 Class<barracks>는 배럭 클래스를 의미하게 되고, 
													// Class<commandCenter>는 커맨드센터 클래스를 의미하게 된다.
													// 첫글자의 대소문자를 통해 클래스와 오브젝트를 구별해두었으니, 헷갈리지만 눈 크게 뜨고 읽어보자. ( 특히 C 와 c 가 굉장히 헷갈린다 ).
        List<? extends Building> buildingList = human.getListOfType(BuildingType);
        
											        // 위의 설명을 통해 만들어진 세 번째 파라미터를 Class<barracks> BuildingType 이라고 하면 이는 즉
											        // Barracks(클래스) 가 된다. 따라서 List<? extends Building> buildingList 는
											        // Barracks buildingList 가 되고, 대입연산자 '=' 을 통해 buildingList 라는 배열에 human.getListOfType(BuildingType)을 넣게된다. 
											        // 이 경우에 human.getListOfType(BuildinType)은 human.getListOfType(Barracks) 가 되고, 이는
											        // human 플레이어에게서 Barracks 타입을 리스트로 가져오라는 메서드가 된다. 이는 Player 클래스에 와일드카드<T>를 사용해서 정의되어있다.
        while (true) {								// while의 조건문에 true 값을 넣는것은 무한루프를 의미한다. 내가 원하는 결과가 생길때까지 반복되는 문으로, 대표적인 예로 값을 입력받는 콘솔창이 있다.
            if (buildingList.size() == 0) {			// buildingList는 전체 건물 리스트가 아니라, 위에서 지정한 특정 건물(주석의 예로는 Barracks 를 사용하고 있다)에 대한 리스트다.
            										// 따라서 buildingList.size==0 인 경우는 , 해당 건물의 객체가 하나도 없는 상황이다. 따라서
                System.out.println("건물이 없습니다.");	// 건물이 없다는 알림을 돌려준다.
                break;								// 건물이 없으면 더 이상 명령을 이어갈 수 없기 때문에, 이전의 창으로 되돌아간다. 이는 조건문이 true 인 무한루프를 탈출한다는 뜻이기에
                									// break; 라는 명령어를 넣어준다.
            }
										            
										            // else문으로 시작하고 대괄호가 없이 바로 buildingIndex = 1; 로 시작된다.
										            // else문 뒤에 대괄호의 유무는 해당 로직이 반드시 실행되는지, 또는 if문이 실패해야만 실행하는지를 결정하게 된다.
										            // else{} 는 if문이 실패했을 경우에 실행이 되고, 그렇지 않으면 생략되지만
										            // else 는 if문이 실패해도 반드시 실행이 된다.
										            // 따라서 위의 상황에서는, buildingList 의 size가 0이 아닌 경우와 상관없이 아래의 코드가 진행된다. 
										            // 아래의 코드는
            else							
            	buildingIndex = 1;
            
            										// 먼저 buildingIndex 를 1로 설정한다.
    		for (Building building : buildingList) {// 이 표현은 향상된 for문으로, 반복문을 좀 더 간편하게 표현하기 위해 사용하는것인데,
    												// buildingList 에 있는 객체들 중에서, Building 클래스를 상속받고있는 객체들을 building 이라고 칭하고,
    												// 그들에 대해서 시행문을 반복한다는 뜻이다.
    												
    			System.out.printf("\t입력번호<%d> : %s\n", buildingIndex++, building);		// '입력번호'와 building을 표현하고싶어서 위와 같은 프린트문을 뽑았고, 이를 통해
    		}																			// 바로 다음 콘솔창에서 사용자가 입력값을 쉽게 판단할 수 있게 도와준다.
    																					// buildingIndex가 1로 되어있기 때문에 건물번호와 상관없이 입력번호는 1부터 표현된다.
            	System.out.println(" 사용할 건물 번호를 고르세요 , 0 : 전체 선택, 1 : 1번 건물, 2 : 2번 건물 , ... , q : 종료 ");

            int BuildingNumber = getBuildingNumber(scanner);		// 입력값을 -2,-1,n 셋중에 하나로 반환해주는 메서드
            														// getBuildingNumber(scanner) 메서드를 통해서 BuildingNumber 안에
            														// -2, -1, n 셋 중 하나의 값을 입력한다.(n은 1이상의 자연수를 의미한다. Ex : 3, 6, 17, ...)
            														// 입력값을 셋 중 하나로 반환하는 이유는
            														// -2 : 취소
            														// -1 : 전체 선택
            														//  n : n번째 건물 선택
            														// 이라는 목적이다. 취소가 q임에도 불구하고 -2로 둔 것은, Scanner로 int값을 받아오기 때문이고,
            														// 프린트문에는 전체 선택 버튼이 0번인데 코드에는 -1번으로 둔 이유는, 자바가 우리에게 객체를 0번부터 보여주기 때문이다.
            														// 사용자의 기준으로는 1번 건물이 프로그램속에서는 0번 건물이기 때문에, 사용자는 1번을 입력해서 0번 객체를 받아야한다. 따라서
            														// 사용자의 입력값과 겹치지 않기 위해서는 사용자가 0번을 입력하면 -1번을 호출해서, 멀티커맨드라는 명령을 받도록 바꿔주었다.
			if (BuildingNumber == -2) {
				break;
				
																	// BuildingNumber가 -2라는 말은 즉 q를 눌렀다는 뜻이다. q는 종료버튼이므로 해당 경우에는 while문을 빠져나가도록 한다. 
			} else if (BuildingNumber == -1) { 						// BuildingNumber 가 -1인 경우는 사용자가 '0'을 입력햇다는 뜻이다. 해당 경우에는 멀티커맨드 메서드를 발동시켜
																	// 모든 건물에 대한, 또는 모든 유닛에 대한 명령을 시행해주도록 한다.
				// 건물 전체 선택 시
				System.out.println("다중 건물 명령을 선택했습니다.");

				for (Building Building : buildingList) { 			// 해당 종류의 모든 건물들에 대해 반복문 실행 ( 위의 예시를 계속 가져오면 모든 Barracks에 대한 명령을 실행하도록 한다 )
					handleBuildingMenu(Building, scanner);			// 건물에 대한 멀티커맨드 명령인데, handleBuildingMenu 를 사용할 시에는 개별 건물에 대한 명령콘솔창이 open되기 때문에
																	// 수정이 필요하다.
																	// 아래에 멀티커맨드 메서드를 추가해놨으니 고치도록 하자
																	// 수정 필요
																	// 수정 필요
				}
			} else {
				// 개별 건물 선택 시
				System.out.println(buildingList.get(BuildingNumber).getName() + "을(를) 선택했습니다.");		// 하나의 건물을 선택했을 시에 나타나는 프린트문이다.
																										// 위의 예시에 대한 출력 기댓값은
																										// Barracks.get(BuildingNumber).getName() 이다
																										// 만약 3번배럭을 눌렀다면 Barracks.get(2).getName() 이 되고 (순서대로 '3번' 과 get(2)라고 쓴건 절대 오타가 아니다)
																										// 이는 위에서 만들어진 Barracks 만을 객체로 가지는 buildingList의 3번 object 인
																										// Barracks.get(2) 의 이름을 불러온다. 따라서
																										// TERRAN Barrcaks을(를) 선택했습니다. 라는 출력값을 얻게 된다.
				handleBuildingMenu(buildingList.get(BuildingNumber), scanner);
			}																							
		}
        	// while문 종료
	}		// controlBuilding(Player, Scanner, Class <? extends Building>) 종료
        
    private static int getBuildingNumber(Scanner scanner) {							//BuildingNUmber(Scanner) 는 -2,-1,n 셋 중 하나의 값을 리턴해주는 메서드다
        while (true) {																// -2는 종료, -1은 멀티커맨드, 0 은 개별명령으로 이어진다.
            if (scanner.hasNext()) {
                String input = scanner.next().toLowerCase(); 

                if (input.equals("q")) {
                    System.out.println("종료합니다.");
                    return -2; // -2를 반환하여 호출한 곳에서 종료 여부를 확인할 수 있도록 함
                }
                try {
                    int parsedInput = Integer.parseInt(input);
                    if (parsedInput >= 0) {		//입력값이 0이거나 n일 경우
                        return parsedInput - 1;
                    } else {
                        System.out.println("잘못된 건물 번호입니다. 다시 선택하세요.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("올바른 숫자를 입력하세요.");
                }
            } else {
                System.out.println("입력값이 없습니다. 다시 입력하세요.");
                scanner.nextLine(); 
            }
        }
    }

    private static void handleBuildingMenu(Building building, Scanner scanner) {	// BuildingNumber가 0일때 실행되는 개별명령 메서드이다.
    	
        System.out.println("건물 명령 콘솔입니다. 명령을 선택하세요.");
        if(building instanceof CommandCenter) {
        	CommandCenter commandCenter = (CommandCenter) building;					// 건물이 CommandCenter 클래스를 상속받을 경우 커멘드센터에 대한 명령이 실행이되고
        	CommandCommandCenter(commandCenter,scanner);
        }
        else if (building instanceof Barracks) {
        	Barracks barracks = (Barracks) building;								// 건물이 Barracks 클래스를 상속받을 경우 배럭에 대한 명령이 실행된다.
        	CommandBarracks(barracks,scanner);
        }
        else
        	Command(building, scanner);
        
    }
    
    private static void multiCommand(Building building, Scanner scanner) {							//수정 필요
    	
        System.out.println("건물 명령 콘솔입니다. 명령을 선택하세요.");
        if(building instanceof CommandCenter) {
        	CommandCenter commandCenter = (CommandCenter) building;
        	CommandCommandCenter(commandCenter,scanner);
        }
        else if (building instanceof Barracks) {
        	Barracks barracks = (Barracks) building;
        	CommandBarracks(barracks,scanner);
        }
        else
        	Command(building, scanner);
        
    }


	private static void Command(Building building, Scanner scanner) {				// 건물이 CommandCenter나 Barracks가 아닐 경우(건물이 생산건물이 아닐 경우) 실행되는 명령창이다
        System.out.println("건물 명령 콘솔입니다. m: 내 상태 보여주기 , q: 종료");
        String input = scanner.next().toLowerCase();

        switch (input) {
	        case "m" :
                System.out.println(building.toString());
            case "q":
                System.out.println("되돌아갑니다.");
                break;

            default:
                System.out.println("에러코드 105");
                break;
        }
    }
	
	private static void CommandCommandCenter(CommandCenter commandCenter, Scanner scanner) {	// 건물이 CommandCenter인 경우 실행되는 명령창이다.
		System.out.println("커멘드센터 메뉴입니다. s: SCV 생산, q: 종료");
		String input = scanner.next().toLowerCase();

        switch (input) {
        case "s" :
			commandCenter.produceScv();
			break;
		case "q" :
			System.out.println("되돌아갑니다.");
			break;
			
		default :
			System.out.println("에러코드 123");
			break;

		}
	}
	
	
	private static void CommandBarracks(Barracks barracks, Scanner scanner) {				// 건물이 Barracks인 경우 실행되는 명령창이다.
		System.out.println("배럭 메뉴입니다. m : 마린 생산, c : 메딕 생산, q: 종료");
		String input = scanner.next().toLowerCase();

		switch (input) {
		case "m":
			barracks.produceMarine();
			break;
		case "c":
			barracks.produceMedic();
			break;
		case "q":
			System.out.println("되돌아갑니다.");
			break;

		default:
			System.out.println("에러코드 146");
			break;

		}
	}

}