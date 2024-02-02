//package trashBin;
//
//import com.taeyoun.resource.Player;
//
//public class ShowResourcestrash implements Runnable {
//    private final Player player;
//
//    public ShowResourcestrash(Player player) {
//        this.player = player;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("현재 자원을 표시합니다");
//        System.out.printf("%s의 미네랄 : %d\t%s의 가스 : %d\t%s의 인구수 : %d%n",
//                player.getPlayerName(), player.getMinerals(), player.getPlayerName(), player.getGas(), player.getPlayerName(), player.getPopulation());
//    }
//}