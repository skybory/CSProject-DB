package Starcraft.taeyoun.resource.map;

public class Map {
	private final static int WIDTH = 100; // 맵의 가로 길이는 100 으로 고정
	private final static int HEIGHT = 100; // 맵의 세로 길이는 100 으로 고정
	private static Cell[][] grid; // 2차원 Cell type 배열 grid 생성

	public Map() { // Map의 생성자 , 파라미터가 없음
		initializeMap();
	}

	private void initializeMap() { // map 에 좌표 번호 지정하기
		grid = new Cell[WIDTH][HEIGHT];
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				grid[x][y] = new Cell(x, y);
			}
		}
	}

	public static Cell getCell(int x, int y) {
		if (isValidCoordinate(x, y)) {
			return grid[x][y];
		} else {
//			System.out.println("유효 범위 밖입니다 . 하지만 null 값 리턴이라 상관없음. 이거 그냥 지워라 미래의 나야...");
			return null;
		}
	}

	private static boolean isValidCoordinate(int x, int y) {
		return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
	}
}
