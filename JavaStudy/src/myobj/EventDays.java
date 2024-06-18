package myobj;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventDays {
	
	final static int EVENT_PERIOUD = 365;
	
	public EventDays() {
		// TODO Auto-generated constructor stub
	}
	
	private void isOneplus(Calendar cal) {
		int event_oneplus = cal.get(Calendar.DAY_OF_MONTH);
		
		if (event_oneplus == 18) {
			System.out.println("1 + 1 이벤트");
		}
		
		
	}
	
	private void isDiscount20per(Calendar cal) {
		int monthWeek = cal.get(Calendar.WEEK_OF_MONTH);
		int weekend = cal.get(Calendar.DAY_OF_WEEK);
		
		if (monthWeek % 2 != 0 && weekend == Calendar.FRIDAY) {
			System.out.println("20% 할인");
			
		}
		
	}
	
	private void isFreeAmericano(Calendar cal) {
		int weekend = cal.get(Calendar.DAY_OF_WEEK);
		
		if (weekend == Calendar.TUESDAY) {
			System.out.println("구매시 아메리카노 무료 이벤트");
			
		}
		
	}
	
	public void printEventDate(Calendar cal) {
		SimpleDateFormat f = new SimpleDateFormat("yy년 MM월 dd일 (E)");
		
		int day = 0;
		
		while (day <= EVENT_PERIOUD) {
			
			String dateStr = f.format(cal.getTime());
			
			System.out.printf("### %s의 이벤트 ###\n", dateStr);
			isOneplus(cal);				
			isDiscount20per(cal);
			isFreeAmericano(cal);
				
			System.out.println();
			System.out.println("---------------------------------------------");
			cal.add(Calendar.DATE, 1);
			++day;
		}
	}
	
}
