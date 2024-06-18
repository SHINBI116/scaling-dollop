package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	연습1: 복숭아 클래스 정의해보세요
		  복숭아는 가격, 등급, 무게, 농장이름을 필드로 가지고 있습니다
		  (등급은 +, -를 매길 수 있음)
		  
	연습2: 복숭아를 크기 비교가 가능한 객체로 만들어보세요 (무게 기준)
	
	연습3: 복숭아를 리스트에 넣고 등급기준으로 내림차순 정렬하고,
		  등급이 같은 경우 가격 기준으로 내림차순 정렬해보세요
	
	연습4: 복숭아를 농장이름순으로 오름차순 정렬하고 농장이름이 같은 경우
		  등급 기준으로 내림차순 정렬 해주세요
*/
public class D07_Peach implements Comparable<D07_Peach> {
	String farm;
	int price;
	double weight;
	String grade;
	
	public D07_Peach(String farm, int price, double weight, String grade) {
		this.price = price;
		this.grade = grade;
		this.weight = weight;
		this.farm = farm;
	}
	
	@Override
		public String toString() {
			return String.format("[%s/%d원/%.2fkg/%s]", farm, price, weight, grade);
		}

	@Override
	public int compareTo(D07_Peach p) {
		if (this.weight == p.weight) {
			return 0;
		} else if (this.weight > p.weight) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		List<D07_Peach> peach = new ArrayList<>();
		
		peach.add(new D07_Peach("가가농장", 2000, 1.3, "B"));
		peach.add(new D07_Peach("나농장", 4000, 3, "A+"));
		peach.add(new D07_Peach("다농장", 3200, 2.4, "B"));
		peach.add(new D07_Peach("라농장", 6000, 5.2, "C+"));
		peach.add(new D07_Peach("사농장", 8000, 4.6, "C-"));
		peach.add(new D07_Peach("바농장", 4000, 3.5, "B-"));
		peach.add(new D07_Peach("가농장", 2300, 4.1, "A"));
		
		System.out.println("분류전");
		System.out.println(peach);
		
		System.out.println("2.");
		Collections.sort(peach);
		System.out.println(peach);
		
		System.out.println("3.");
		Collections.sort(peach, new peachSortDes());
		System.out.println(peach);
		
		System.out.println("4.");
		Collections.sort(peach, new peachSortAsc());
		System.out.println(peach);
		



		
	}
}

class peachSortDes implements Comparator<D07_Peach>{

	@Override
	public int compare(D07_Peach p1, D07_Peach p2) {
		char alpha1 = p1.grade.charAt(0);
		char alpha2 = p2.grade.charAt(0);
		
		if (p1.grade.equals(p2.grade)) {
			if (p1.price == p2.price) {
				return 0;
			} else if (p1.price > p2.price) {
				return -1;
			} else {
				return 1;
			}
		}
		
		if (alpha1 == alpha2) {
			if (p1.grade.length() > 1 && p1.grade.charAt(1) == '+') {
				return -1;
			} else if (p1.grade.length() == 1) {
				if (p2.grade.charAt(1) == '-') {
					return -1;
				} else {
					return 1;
				}
				
			} else {
				return 1;
			}
		} else if ((int)alpha1 < (int)alpha2) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
}
//연습4: 복숭아를 농장이름순으로 오름차순 정렬하고 농장이름이 같은 경우
//등급 기준으로 내림차순 정렬 해주세요
class peachSortAsc implements Comparator<D07_Peach> {
	
	@Override
	public int compare(D07_Peach p1, D07_Peach p2) {
		ArrayList<Character> ch1 = new ArrayList<>();
		ArrayList<Character> ch2 = new ArrayList<>();
		
		for (int i = 0; i < p1.farm.length(); ++i) {
			ch1.add(p1.farm.charAt(i));
		}
		for (int i = 0; i < p2.farm.length(); ++i) {
			ch2.add(p2.farm.charAt(i));
		}
		
		if (p1.farm.equals(p2.farm)) {
			char alpha1 = p1.grade.charAt(0);
			char alpha2 = p2.grade.charAt(0);
			
			if (p1.grade.equals(p2.grade)) {
				if (p1.price == p2.price) {
					return 0;
				} else if (p1.price > p2.price) {
					return -1;
				} else {
					return 1;
				}
			}
			
			if (alpha1 == alpha2) {
				if (p1.grade.length() > 1 && p1.grade.charAt(1) == '+') {
					return -1;
				} else if (p1.grade.length() == 1) {
					if (p2.grade.charAt(1) == '-') {
						return -1;
					} else {
						return 1;
					}
					
				} else {
					return 1;
				}
			} else if ((int)alpha1 < (int)alpha2) {
				return -1;
			} else {
				return 1;
			}
		}
		int len = p1.farm.length() > p2.farm.length() ? p2.farm.length() : p1.farm.length();
		
		for (int i = 0; i < len; ++i) {
			if (ch1.get(i) < ch2.get(i)) {
				return -1;
			} else if (ch1.get(i) == ch2.get(i)) {
				continue;
			} else {
				return 1;
			}
		}
		return 0;
	}
	
}
