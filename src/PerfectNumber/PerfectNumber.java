package PerfectNumber;

public class PerfectNumber {
	SinglyLinkedList divisors = new SinglyLinkedList();
	public boolean isPerfect(int val) {
		divisors.clear();
		for (int i = val - 1; i >= 1; i--) {
			if (val % i == 0) {
				divisors.add(i);
			}
		}
		int size = divisors.size();
		if (size > 0) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				sum += divisors.get(i);
			}
			if (sum == val) return true;
		}
		return false;
	}
}
