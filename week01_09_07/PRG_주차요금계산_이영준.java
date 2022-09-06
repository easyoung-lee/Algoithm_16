package codingTestPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class PRG_주차요금계산_이영준 {

	static class Car implements Comparable<Car> {
		int num, time;
		String now_time;
		boolean state; // true : IN, false : OUT

		public Car(int num, int time, String now_time, boolean state) {
			super();
			this.num = num;
			this.time = time;
			this.now_time = now_time;
			this.state = state;
		}

		public void addTime(int time) {
			this.time += time;
		}

		public void setNow_time(String now_time) {
			this.now_time = now_time;
		}

		public boolean isState() {
			return state;
		}

		public void setState(boolean state) {
			this.state = state;
		}

		@Override
		public int compareTo(Car o) {
			return num - o.num;
		}

	}

	public int[] solution(int[] fees, String[] records) {
		int base_time = fees[0];
		int base_cost = fees[1];
		int more_time = fees[2];
		int more_cost = fees[3];
		ArrayList<Car> list = new ArrayList<>();
		StringTokenizer st;

		// records 읽어오면서 계산하기..
		for (int i = 0, end = records.length; i < end; i++) {
			st = new StringTokenizer(records[i], " ");
			String t = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			String state = st.nextToken();

			switch (state) { // IN/OUT 구분
			case "IN":
				boolean check = false;
				for (Car car : list) {
					if (car.num == n) { // 기존에 왔던 차량이면 setting
						car.setNow_time(t);
						car.setState(true);
						check = true;
						break;
					}
				}
				if (!check) { // 기존에 없는 차량이면 list 새로추가
					list.add(new Car(n, 0, t, true)); // 차량번호, 누적시간, 입차 시간, IN/OUT인지 상태
				}
				break;

			case "OUT":
				for (Car car : list) {
					if (car.num == n) { // 차량 누적시간 갱신
						car.addTime(calculateTime(car.now_time, t));
						car.setState(false);
						break;
					}
				}
				break;
			}
		}

		Collections.sort(list); // 차량 번호 -> 오름차순
		int[] answer = new int[list.size()];
		int idx = 0;
		for (Car car : list) {
			if (car.state) { // 차량이 IN한 상태일때
				car.addTime(calculateTime(car.now_time, "23:59"));
				System.out.println("완료");
			}
			if (car.time <= base_time) {
				answer[idx++] = base_cost;
			} else {
				answer[idx++] = base_cost + (int) (Math.ceil((double) (car.time - base_time) / more_time)) * more_cost;
			}
		}
		return answer;
	}

	private int calculateTime(String now_time, String t) {
		StringTokenizer st = new StringTokenizer(now_time, ":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(t, ":");
		int nh = Integer.parseInt(st.nextToken());
		int nm = Integer.parseInt(st.nextToken());

		return (nh - h) * 60 + nm - m;
	}
}