import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        ArrayList<Car> carList = new ArrayList<Car>();

        for(String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String T = st.nextToken();	        	
            StringTokenizer st2 = new StringTokenizer(T, ":");
            int time = Integer.parseInt(st2.nextToken())*60 + Integer.parseInt(st2.nextToken());

            int num = Integer.parseInt(st.nextToken());
            String inout = st.nextToken();


            if(inout.equals("IN")) {	// 입차
                boolean flag = true;
                for (Car car : carList) {
                    if(car.num == num) {
                        car.in(time);
                        flag = false;
                        break;
                    }
                }
                if(flag) carList.add(new Car(num, time));
            } else {	// 출차
                for (Car car : carList) {
                    if(car.num == num)	{
                        car.out(time);
                        break;
                    }
                }
            }	
        }
        Collections.sort(carList);
        int[] answer = new int[carList.size()];
        int i = 0;
        for (Car car : carList) {
            int money = fees[1];
            if(car.time > fees[0]) {
                int t = (car.time - fees[0]) / fees[2];
                money += t * fees[3];
                if((car.time - fees[0]) % fees[2] != 0)	money += fees[3];
            }
            answer[i++] = money;
        }

        return answer;
    }
}

class Car implements Comparable<Car> {
    int num = -1;
    int inTime;
    int outTime;
    int time;

    public Car(int num, int inTime) {
        super();
        this.num = num;
        this.inTime = inTime;
        outTime = 1439;
        time = outTime - inTime;
    }

    public void in(int inTime) {
        this.inTime = inTime;
        outTime = 1439;
        time += (1439 - inTime);
    }

    public void out(int outTime) {
        time -= (1439 - outTime);
    }

    public int compareTo(Car o) {
        return this.num - o.num;
    }
}