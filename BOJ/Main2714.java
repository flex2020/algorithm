import java.util.*;
import java.io.*;

public class Main2714 {
	
	static class Robot {
		int x, y, d;
		Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Command{
		int robotNum;
		String type;
		int count;
		public Command(int robotNum, String type, int count) {
			super();
			this.robotNum = robotNum;
			this.type = type;
			this.count = count;
		}
	}
	static int[][] map;
	static Robot[] robots;
	static String answer;
	static int A, B;
	// 상우하좌
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 지도 정보 입력받기
		map = new int[B + 2][A + 2];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[map.length - 1], -1);
		for (int i = 1; i < map.length - 1; i++) {
			map[i][0] = -1;
			map[i][map[0].length - 1] = -1;
		}
		
		// 로봇 정보 입력받기
		robots = new Robot[N + 1];
		for (int i = 1; i < robots.length; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			robots[i] = new Robot(x, y);
			
			switch(st.nextToken()) {
				case "N":
					robots[i].d = 0;
					break;
				case "E":
					robots[i].d = 1;
					break;
				case "S":
					robots[i].d = 2;
					break;
				case "W":
					robots[i].d = 3;
					break;
			}
			
			map[x][y] = i;
		}
		
		answer = "OK";
		
		Command[] commands = new Command[M];
		
		// 명령어 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int robotNumber = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			commands[i] = new Command(robotNumber, command, count);
		}
		
		L: for (int i = 0; i < commands.length; i++) {
			Command command = commands[i];
			for (int j = 0; j < command.count; j++) {
				switch(command.type) {
					case "L":
						rotate(command.robotNum, command.type);
						break;
					case "R":
						rotate(command.robotNum, command.type);
						break;
					case "F":
						go(command.robotNum);
				}
				if(!answer.equals("OK")) {
					break L;
				}
			}
		}

		System.out.println(answer);
	}
	
	public static void go(int robotNumber) {
		Robot robot = robots[robotNumber];
		int nextX = robot.x + dx[robot.d];
		int nextY = robot.y + dy[robot.d];
		
		if (map[nextX][nextY] == -1) {
			answer = "Robot "+ robotNumber +" crashes into the wall";
			return;
		} else if (map[nextX][nextY] != 0) {
			answer = "Robot "+ robotNumber +" crashes into robot " + map[nextX][nextY];
			return;
		}
		map[robot.x][robot.y] = 0;
		robot.x = nextX;
		robot.y = nextY;
		map[nextX][nextY] = robotNumber;
	}
	
	public static void rotate(int robotNumber, String s) {
		Robot robot = robots[robotNumber];
		switch(s){
			case "L":
				robot.d = (robot.d + 3) % 4;
				break;
			case "R":
				robot.d = (robot.d + 1) % 4;
				break;
		}
	}

}
