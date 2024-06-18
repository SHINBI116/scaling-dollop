package quiz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class D14_EventDays {
	/*
		java.time 패키지의 클래스들만 활용하여
	 	실행하면 오늘부터 앞으로 1년간의 이벤트 날짜를 모두 출력해주는 프로그램을 만들어 주세요
	 	
	 	1 + 1 이벤트 : 매월 18일
	 	20% 할인 이벤트 : 홀수번째 주 금요일
	 	구매시 아메리카노 무료 이벤트 : 매주 화요일
	 	
	 	※ 이벤트 날짜가 겹치는 날에는 모든 이벤트를 출력해줘야 한다
    */
	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		
		int day = 0;
		while (day < 365) {
			DayOfWeek dow = today.getDayOfWeek();
			String dowFormat = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
			
			boolean eventDay = false;
			
			System.out.printf("%s(%s) : ", today.toString(), dowFormat);
			if (today.getDayOfMonth() == 18) {
				System.out.print("1 + 1 이벤트");
				eventDay = true;
			}
			
			if (today.get(ChronoField.ALIGNED_WEEK_OF_MONTH) % 2 == 1 && dow.equals(DayOfWeek.FRIDAY)) {
				if(eventDay) {
					System.out.print(", ");
				} 
				System.out.print("20% 할인 이벤트");
				eventDay = true;
			}
			
			if (dow.equals(DayOfWeek.TUESDAY)) {
				if(eventDay) {
					System.out.print(", ");
				} 
				System.out.print("아메리카노 무료");
				eventDay = true;
				
			}
			
			if (!eventDay) {
				System.out.print("이벤트없음");
			}
			
			System.out.println();
			today = today.plusDays(1);
			++day;
		}
		
	}
}
