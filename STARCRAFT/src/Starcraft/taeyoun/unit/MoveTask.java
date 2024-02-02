//package Starcraft.taeyoun.unit;
//
//public class MoveTask implements Runnable {
//
//    private final Unit unit;
//    private final int x;
//    private final int y;
//    
//	
//    public MoveTask(Unit unit, int x, int y) {
//        this.unit = unit;
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public void run() {
//        unit.move(x, y);
//    }
//}

// MoveTask 를 따로 만들어서 Runnable 함수로써 작동시키려고 했었는데, 에러가 많이 발생해서 그냥 유닛 밑에 메서드로 추가했다. 이를 잘 해결하면 좀 더
// 가독성이 좋은 코드가 되었을텐에 아쉽다. 능력부족!