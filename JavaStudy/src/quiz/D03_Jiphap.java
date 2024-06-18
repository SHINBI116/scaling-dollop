package quiz;

import java.util.*;


public class D03_Jiphap {
	/*
	 	1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set으로 반환하는 메서드
	 	   [1, 2, 3] + [2, 3, 4, 5] => [1, 2, 3, 4, 5]
	 	2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
	 	   [1, 2, 3] 교 [2, 3, 4, 5] => [2, 3]
	 	3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
	 	   [1, 2, 3] - [2, 3, 4, 5] => [1]
	 	   [2, 3, 4, 5] - [1, 2, 3] => [4, 5]
	 */
	
	public static Collection copyList (Collection col) {
		ArrayList list = new ArrayList();
		list.addAll(col);
		
		return list;
	}

	
	public static HashSet plusSet (Collection col1, Collection col2) {
		Collection list1 = copyList(col1);
		Collection list2 = copyList(col2);
		
		list1.addAll(list2);
		
		HashSet plus = new HashSet(list1);
		
		return plus;
	}
	
	public static HashSet commonSet (Collection col1, Collection col2) {		
		Collection list1 = copyList(col1);
		Collection list2 = copyList(col2);
		
		list1.retainAll(list2);		
		HashSet common = new HashSet(list1);
		
		return common;
	}
	
	public static HashSet minusSet (Collection col1, Collection col2) {
		Collection list1 = copyList(col1);
		Collection list2 = copyList(col2);
		
		list1.removeAll(list2);
		HashSet minus = new HashSet(list1);
		
		return minus;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>();
		Collection<Integer> arr2 = new LinkedList<>();
		
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		
		arr2.add(2);
		arr2.add(3);
		arr2.add(4);
		arr2.add(5);
		
		System.out.println("arr1 : " + arr1);
		System.out.println("arr2 : " + arr2);
		
		System.out.println(plusSet(arr1, arr2));
		System.out.println(commonSet(arr1, arr2));
		System.out.println(minusSet(arr1, arr2));
		System.out.println(minusSet(arr2, arr1));
	
	}
}
