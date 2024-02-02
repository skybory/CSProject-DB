///package trashBin;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class UnitManager {
//    private ExecutorService executorService;
//
//    public UnitManager() {
//        this.executorService = Executors.newCachedThreadPool();
//    }
//
// /*   public void moveUnitAsync(Unit unit, int x, int y) {
//    	shutdown();
//    	Runnable moveTask = new MoveTask(unit, x, y);
//        executorService.submit(moveTask);
//    }
//*/
//    public void shutdown() {
//        executorService.shutdown();
//    }
//    
//    
//    
//    
//     // UnitManager 클래스의 moveUnitAsync 메서드에서 stopMoving 호출 예시
//        public void moveUnitAsync(Unit unit, int x, int y) {
//  /*          unit.stop(); // 먼저 이동 중인 명령이 있다면 중단
//            shutdown();
//            Runnable moveTask = new MoveTask(unit, x, y);
//            executorService.submit(moveTask);
//   */
//           unit.stop(); // 먼저 이동 중인 명령이 있다면 중단
//            shutdown();
//            if (executorService.isShutdown() || executorService.isTerminated()) {
//                // ExecutorService가 종료된 경우 새로운 ExecutorService 생성
//                executorService = Executors.newCachedThreadPool();
//            }
//            Runnable moveTask = new MoveTask(unit, x, y);
//            executorService.submit(moveTask);
//            
//    }
//}
