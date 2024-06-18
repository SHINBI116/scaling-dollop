package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D03_Jiphap_Ans {
	
	public static Set union(Collection a,Collection b) {
		//전달된 원본을 훼손시키는 방법
//		a.addAll(b);		
//		Set union = new HashSet(a);
		Set union = new HashSet();
		
		union.addAll(a);
		union.addAll(b);
		
		return union;
	}
	
	public static Set inter(Collection a, Collection b) {
		Set inter = new HashSet();
		inter.addAll(a);
		inter.retainAll(b);
		return inter;
	}
	
	public static Set diff (Collection a, Collection b) {
		Set diff = new HashSet();
		diff.addAll(a);
		diff.removeAll(b);
		return diff;
	}
	
	public static void main(String[] args) {
		List<String> snack1 = new ArrayList<>();
		List<String> snack2 = new ArrayList<>();
		
		snack1.add("초코파이");
		snack1.add("웨하스");
		snack1.add("쿠크다스");
		
		snack2.add("쿠크다스");
		snack2.add("오예스");
		snack2.add("포스틱");
		
		List<Integer> num1 = new ArrayList<>();
		List<Integer> num2 = new ArrayList<>();
		
		num1.add(1);
		num1.add(2);
		num1.add(3);
		
		num2.add(3);
		num2.add(3);
		num2.add(4);
		num2.add(5);
		
		System.out.println(num1 + " vs " + num2);
		System.out.println(snack1 + " vs " + snack2);
		
		System.out.println("### 합집합 ###");
		Set unionResult = union(num1, num2);
		Set unionResult2 = union(snack1, snack2);
		
		System.out.println(unionResult);
		System.out.println(unionResult2);
		
		System.out.println("### 교집합 ###");		
		System.out.println(num1 + " vs " + num2);
		System.out.println(snack1 + " vs " + snack2);
		
		Set interResult = inter(num1, num2);
		System.out.println(interResult);
	}
}
