package myobj;

import java.util.Arrays;

public class Academy {
	
	

	
	

	public static void main(String[] args) {
		
		
	}

}


class Web extends Academy_Students {
	int[] subject = new int[6];
	public int totalScore() {
		int sum = 0;
		for (int i = 0; i < this.subject.length; ++i) {
			sum += this.subject[i];
		}
		return sum;
	}
	
	public double avg() {
		double average = totalScore() / this.subject.length;
		
		return average;
	}
	public char grade() {
		if (avg() > 90) {
			return 'A';
		} else if (avg() > 80) {
			return 'B';
		} else if (avg() > 70) {
			return 'C';
		} else {
			return 'F';
		}
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}

}

class Network extends Academy_Students {
	int[] subject = new int[5];
	public int totalScore() {
		int sum = 0;
		for (int i = 0; i < this.subject.length; ++i) {
			sum += this.subject[i];
		}
		return sum;
	}
	
	public double avg() {
		double average = totalScore() / this.subject.length;
		
		return average;
	}
	
	public void ranScore() {
		for (int i = 0; i < this.subject.length; ++i) {
			int ran = (int)(Math.random() * 101);
			this.subject[i] = ran;
		}
		
	}
	public char grade() {
		if (avg() > 90) {
			return 'A';
		} else if (avg() > 80) {
			return 'B';
		} else if (avg() > 70) {
			return 'C';
		} else {
			return 'F';
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	

}

class Machinerunning extends Academy_Students {
	int[] subject = new int[6];
	public int totalScore() {
		int sum = 0;
		for (int i = 0; i < this.subject.length; ++i) {
			sum += this.subject[i];
		}
		return sum;
	}
	
	public double avg() {
		double average = totalScore() / this.subject.length;
		
		return average;
	}
	
	public char grade() {
		if (avg() > 90) {
			return 'A';
		} else if (avg() > 80) {
			return 'B';
		} else if (avg() > 70) {
			return 'C';
		} else {
			return 'F';
		}
	}
	@Override
	public String toString() {
		return super.toString();
	}
}

