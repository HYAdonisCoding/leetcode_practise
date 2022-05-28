import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1, 3, 4, 6, 7, 4, 9, 10};

		// for循环
		for (int i = 0; i < list.length; i++) {
			System.out.println("1 -" + list[i]);
		}
		
		// for earch
		for (Integer i: list) {
			System.out.println("2 -" + i);
		}


		// 迭代器
		Iterator<Integer> iterator = Arrays.stream(list).iterator();
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println("3 -" + i);
		}
	}

}
