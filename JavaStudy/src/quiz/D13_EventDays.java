package quiz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class D13_EventDays {
	/*
	 	실행하면 오늘부터 앞으로 1년간의 이벤트 날짜를 모두 출력해주는 프로그램을 만들어 주세요
	 	
	 	1 + 1 이벤트 : 매월 18일
	 	20% 할인 이벤트 : 홀수번째 주 금요일
	 	구매시 아메리카노 무료 이벤트 : 매주 화요일
	 	
	 	※ 이벤트 날짜가 겹치는 날에는 모든 이벤트를 출력해줘야 한다
	*/
	public static void printEventDays() {
		Calendar today = Calendar.getInstance();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		
		dateFormat.applyPattern("yyyy-MM-dd");
		for (int i = 0; i < 365; ++i) {
			System.out.printf("[%s]의 이벤트: ",
					dateFormat.format(today.getTime()));
			
			boolean eventExist = false;
			
			// 매월 18일
			if (today.get(Calendar.DAY_OF_MONTH) == 18) {
				System.out.print("1 + 1이벤트");
				eventExist = true;
			}
			// 홀수번째 주 금요일
			if (today.get(Calendar.WEEK_OF_MONTH)  % 2 == 1 &&
					today.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				if (eventExist) {
					System.out.print(", 20% 할인 이벤트");
				} else {
					System.out.print("20% 할인 이벤트");
				}
				eventExist = true;
			}
			
			if (today.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
				if (eventExist) {
					System.out.print(", 구매시 아메리카노 무료");
				} else {
					System.out.print("구매시 아메리카노 무료");
				}
				eventExist = true;
			}
			
			if (!eventExist) {
				System.out.print("이벤트 없음");
			}
			
			System.out.println();
			today.add(Calendar.DATE, 1);
		}
	}

	public static void main(String[] args) {
		printEventDays();
	}
	
	
}
