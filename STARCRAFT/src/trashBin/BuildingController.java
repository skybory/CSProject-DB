///*package com.taeyoun.application;
//
//import java.util.List;
//import java.util.Scanner;
//import com.taeyoun.building.Barracks;
//import com.taeyoun.building.CommandCenter;
//import com.taeyoun.building.Refinery;
//import com.taeyoun.building.SupplyDepot;
//import com.taeyoun.resource.Player;
//
//public class BuildingController {
//	
//// 게임시작 후 press b	
//
//	 public static void controlBuilding(Player human, Scanner scanner) {		
//	 System.out.println("건물을 조작합니다");
//        System.out.println(human.getBuildingList());
//        System.out.println("조작할 건물을 고르세요 (c : Command Center, b : Barracks, r : Refinery, S : Supply Depot, q : 종료):");
//        String input = scanner.next();		// 메뉴판 인쇄랑 input은 세트
//
//        switch (input.toLowerCase()) {
//            case "c" :
//            	CommandCenter.controlCommandCenter(human, scanner);
//                break;
//
//			case "b" :
//				Barracks.controlBarracks(human, scanner);
//				break;
//				
//			case "r" :
//				Refinery.controlRefinery(human, scanner);
//				break;
//				
//			case "s" :
//				SupplyDepot.controlSupplyDepot ( human, scanner);
//				break;
//				
//            case "q" :
//                System.out.println("건물 조작을 종료합니다.");
//                break;
//
//            default:
//                System.out.println("잘못된 입력입니다");
//                break;
//        }
//    }
//}*/
//package trashBin;
//
//
