package Starcraft.taeyoun.application;


import java.util.List;
import java.util.Scanner;

import Starcraft.taeyoun.resource.Player;
import Starcraft.taeyoun.unit.Scv;
import Starcraft.taeyoun.unit.Unit;

public class UnitController {

	static int unitIndex;
	public static void controlUnit(Player human, Scanner scanner, Class<? extends Unit> unitType) {		//BuildingController 와 메커니즘이 같다.
        List<? extends Unit> unitList = human.getListOfType(unitType);
        while (true) {
            if (unitList.size() == 0) {
                System.out.println("유닛이 없습니다.");
                break;
            }
            else 
            	unitIndex = 1;
        		for (Unit unit : unitList) {
        			System.out.printf("\t입력번호<%d> : %s\n", unitIndex++, unit);
        		}
            	System.out.println(" 사용할 유닛 번호를 고르세요 , 0 : 전체 선택, q : 종료 ");
            	int unitNumber = getUnitNumber(scanner);
            	if (unitNumber == -2) {
    				break;
    			}	
            	else if (unitNumber == -1) {
	            	boolean allScv = unitList.stream().allMatch(unit -> unit instanceof Scv);		// 이 부분만 조금 다른데, unitNumber가 -1일때, 즉 MultiCommand를 호출했을 때
	            	if (allScv) {
	            		MultiCommandScv((List<Scv>) unitList,scanner);								// 유닛의 대상이 SCV인 경우 MultiCommandScv를 호출하고, 그렇지 않을 경우
	            	} else {
	            		System.out.println("다중 명령을 선택했습니다.");
		                MultiCommand((List<Unit>) unitList,scanner);								// 그냥 MultiCommand를 호출한다. SCV인 경우에는 일반 유닛과
		                																			// 가지고있는 기능이 다르기 때문에 다른 메서드를 호출해줬다.
	            	}
	            }
	           
	            else {
	                // 개별 유닛 선택 시
	                System.out.println(unitList.get(unitNumber).getName() + "을(를) 선택했습니다.");
	                
	                
	                handleUnitMenu(unitList.get(unitNumber), scanner);
            }
        }
    }

	private static void MultiCommand(List<Unit> unitList, Scanner scanner) {						// 멀티커맨드 콘솔로써 유닛에게 명령할 내용을 정할수있다.
        System.out.println("멀티 커맨드 콘솔입니다. m : 전체 이동, s : 전체 정지, a : 전체 공격, q: 종료");			// 이동, 정지, 공격을 내릴 수 있고, Unit Class 에 각 메서드가 정의되어있다.
        String input = scanner.next().toLowerCase();

        switch (input) {
            case "m":
                int x;
                int y;
            	System.out.println("유닛을 이동합니다. 목표 x좌표를 입력하세요");
            	x = scanner.nextInt();
            	System.out.println("유닛을 이동합니다. 목표 y좌표를 입력하세요");
            	y = scanner.nextInt();
            	
            	for(int i = 0; i < unitList.size(); i++)
            	{
            		unitList.get(i).move(x, y);
            	}
        		try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	break;

            case "s":
            	  for (Unit unit : unitList) {
                      unit.stop();
            	  }
          		try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                break;

            case "a" : 
          	  for (Unit unit : unitList) {
                  unit.attack();
          	  }
      		try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                break;

            case "q":
                System.out.println("메인 메뉴로 돌아갑니다.");
                break;

            default:
                System.out.println("에러코드 103");							// 실행 테스트를 하면서 에러가 어디서 발생하는지 체크하기 위한 코드이다.
                															// 이 코드가 몇번째 줄에 있는지 체크하면서 표시했지만, 코드를 수정하면서 계속 줄이 바뀌는 불편함이 있다.
                break;
        }
    }
	
	
	private static void MultiCommandScv(List<Scv> unitList, Scanner scanner) {					// SCV에 대한 멀티커맨드 명령 콘솔이고, 일반 유닛과 달리 자원채굴을 할 수 있다.
        System.out.println("SCV 전용 멀티 커맨드 콘솔입니다. m : 전체 이동, s : 전체 정지, a : 전체 공격, g : 전체 자원 채굴 q: 종료");
        String input = scanner.next().toLowerCase();

        switch (input) {
            case "m":
                int x;
                int y;
            	System.out.println("유닛을 이동합니다. 목표 x좌표를 입력하세요");
            	x = scanner.nextInt();
            	System.out.println("유닛을 이동합니다. 목표 y좌표를 입력하세요");
            	y = scanner.nextInt();
            	
            	for(int i = 0; i < unitList.size(); i++)				// for 문과 향상된 for문의 차이점을 보여주기 위해 일부러 for문으로 작성했다.
            	{
            		unitList.get(i).move(x, y);
            		try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            	break;

            case "s":	
            	  for (Unit unit : unitList) {							// for 문과 향상된 for문의 차이점의 보여주기 위해 일부러 향상된 for문으로 작성했다.
                      unit.stop();										// 바로 위에있는 식과 내리는 명령(move 인지 stop인지)만 다르고, 로직은 같다.
              		try {
  						Thread.sleep(20);
  					} catch (InterruptedException e) {
  						e.printStackTrace();
  					}
            	  }
                break;

            case "a" : 
            	for (Unit unit : unitList) {
                    unit.attack();
            	}
                break;

			case "g":
				System.out.println("자원을 채굴합니다. m: 미네랄 캐기, g: 가스 캐기, q: 종료");
				input = scanner.next().toLowerCase();

				switch (input) {
				case "m":
					for (Scv scv : unitList) {
						scv.gatherMineral();
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
//						System.out.println("멀티 커맨드 : 미네랄 캐기 성공");
					}
					break;

				case "g":
					for (Scv scv : unitList) {
						scv.gatherGas();
	            		try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
//						System.out.println("멀티 커맨드 : 가스 캐기 성공");
					}
					break;

				case "q":
					System.out.println("유닛 명령 콘솔로 되돌아갑니다.");
					break;

				default:
					System.out.println("잘못된 입력입니다.");
					break;
				}
				break;
			case "q":
				System.out.println("메인 메뉴로 돌아갑니다.");
                break;

            default:
                System.out.println("에러코드 194");
                break;
        }
    }
	
    private static int getUnitNumber(Scanner scanner) {
        while (true) {
            if (scanner.hasNext()) {
                String input = scanner.next().toLowerCase();

                if (input.equals("q")) {
                    System.out.println("종료합니다.");
                    return -2; 									// -2를 반환하여 호출한 곳에서 종료 여부를 확인할 수 있도록 했다.
                }

                try {
                    int parsedInput = Integer.parseInt(input);
                    if (parsedInput >= 0) {
                        return parsedInput - 1;
                    } else {
                        System.out.println("잘못된 유닛 번호입니다. 다시 선택하세요.");
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

    private static void handleUnitMenu(Unit unit, Scanner scanner) {
    	
        System.out.println("유닛 명령 콘솔입니다. 명령을 선택하세요.");
    if(unit instanceof Scv) {
    	Scv scv = (Scv) unit;
    	CommandScv(scv,scanner);
    }
    else
        Command(unit, scanner);
    }

    

    
	private static void Command(Unit unit, Scanner scanner) {						// 일반 유닛에 대한 명령 콘솔이다.
        System.out.println("유닛 명령 콘솔입니다. m : 이동, s : 정지, a : 공격, q: 종료");
        String input = scanner.next().toLowerCase();

        switch (input) {
            case "m":
                int x;
                int y;
            	System.out.println("유닛을 이동합니다. 목표 x좌표를 입력하세요");
            	x = scanner.nextInt();
            	System.out.println("유닛을 이동합니다. 목표 y좌표를 입력하세요");
            	y = scanner.nextInt();
            	unit.move(x, y);
                break;

            case "s":
                unit.stop();
                break;

            case "a" : 
            	unit.attack();
                break;
                
            case "q":
                System.out.println("메인 메뉴로 돌아갑니다.");
                break;

            default:
                System.out.println("에러코드 268");
                break;
        }
    }
	
	private static void CommandScv(Scv scv, Scanner scanner) {			// SCV에 대한 일반 명령이다.
		System.out.println("SCV 전용 유닛 명령 콘솔입니다. m : 이동, s : 정지, a : 공격, b : 건물 짓기 , g : 자원 채굴 q: 종료");
		String input = scanner.next().toLowerCase();

		switch (input) {
		case "m":
			int x;
			int y;
			System.out.println("유닛을 이동합니다. 목표 x좌표를 입력하세요");
			x = scanner.nextInt();
			System.out.println("유닛을 이동합니다. 목표 y좌표를 입력하세요");
			y = scanner.nextInt();
			scv.move(x, y);
			break;

		case "s":
			scv.stop();
			break;

		case "a":
			scv.attack();
			break;

		case "b":
			System.out.println("설치할 건물을 고르세요.");
			System.out.println(" 건물 리스트 -> c : Command Center, b : Barracks, s : Supply depot, r : Refinery q : 종료");
			input = scanner.next().toLowerCase();
			switch (input) {
			case "c":
				scv.produceCommandCenter(scv.getX(), scv.getY());
				break;
			case "b":
				scv.produceBarracks(scv.getX(), scv.getY());
				break;
			case "s":
				scv.produceSupplyDepot(scv.getX(), scv.getY());
				break;
			case "r":
				scv.produceRefinery(scv.getX(), scv.getY());
				break;
			}

			break;
		case "g":
			System.out.println("자원을 채굴합니다. m: 미네랄 캐기, g: 가스 캐기, q: 종료");
			input = scanner.next().toLowerCase();

			switch (input) {
			case "m":
				scv.gatherMineral();
				System.out.println("단독 명령 : 미네랄을 캐러갑니다");
				break;
			case "g":
				scv.gatherGas();
				System.out.println("단독 명령 : 가스를 캐러갑니다");
				break;
			case "q":
				System.out.println("유닛 명령 콘솔로 되돌아갑니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			break;
		case "q":
			System.out.println("메인 콘솔로 되돌아갑니다.");
			break;

		default:
			System.out.println("에러코드 344");
			break;
		}
	}
}