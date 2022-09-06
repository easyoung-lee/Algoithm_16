
import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String, Integer> carTimeMap = new HashMap<>();
        for (String s : records) {
            recordsAnalyze(s, carTimeMap);
        }
        parkingLotEnd(carTimeMap);
        calculateFee(carTimeMap, fees);
        ArrayList<String> sortedCarNumList = new ArrayList<>();

        for (String s : carTimeMap.keySet()) {

            sortedCarNumList.add(s);
        }
        Collections.sort(sortedCarNumList);
        answer = new int[sortedCarNumList.size()];
        for (int i = 0, end = sortedCarNumList.size(); i < end; i++) {

            answer[i] = carTimeMap.get(sortedCarNumList.get(i));
        }
        return answer;
    }

    // 입차 == -(시각*60+분)
    // 출차 == +(시각*60+분)

    public void recordsAnalyze(String record, HashMap<String, Integer> carTimeMap) {
        String[] temp = record.split(" ");
        String[] timeTemp = temp[0].split(":");
        int time = 0;
        if (temp[2].equals("IN")) {
            time -= (Integer.parseInt(timeTemp[0]) * 60 + Integer.parseInt(timeTemp[1]));
        } else if (temp[2].equals("OUT")) {
            time += (Integer.parseInt(timeTemp[0]) * 60 + Integer.parseInt(timeTemp[1]));
        }
        carTimeMap.put(temp[1], carTimeMap.getOrDefault(temp[1], 0) + time);

        return;
    }

    // 출차 기록이 없다면 23:59 에 출차
    // 시간 기록이 음수 == 아직 출차 안함
    // 시간 기록이 양수 == 출차 함
    public void parkingLotEnd(HashMap<String, Integer> carTimeMap) {
        Set<String> carNum = carTimeMap.keySet();
        for (String s : carNum) {
            int time = carTimeMap.get(s);
            if (time <= 0) {
                carTimeMap.put(s, carTimeMap.get(s) + (23 * 60 + 59));
            }

        }
    }

    // 요금 계산 후 map의 value에 시간대신 요금 입력
    public void calculateFee(HashMap<String, Integer> carTimeMap, int[] fees) {
        Set<String> carNum = carTimeMap.keySet();
        for (String s : carNum) {
            int time = carTimeMap.get(s);
            if (time <= fees[0]) {
                carTimeMap.put(s, fees[1]);
            } else if (time > fees[0]) {
                int feeTemp = fees[1];
                time -= fees[0];
                feeTemp += ((int) Math.ceil((double) time / fees[2])) * fees[3];
                carTimeMap.put(s, feeTemp);
            }
        }
        return;
    }

}