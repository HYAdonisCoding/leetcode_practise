package com.adam.tools;

public class Integers {

	public static Integer[] random(int count, int min, int max) {
		if (count <= 0 || min > max) {
			return null;
		}
		Integer[] array = new Integer[count];
		int delta = max - min + 1;
		for (int i = 0; i < count; i++) {
			array[i] = min + (int) (Math.random() * delta);
		}
		return array;
	}

	public static Integer[] same(int count, int unsameCount) {
		if (count <= 0 || unsameCount > count) {
			return null;
		}
		Integer[] array = new Integer[count];
		for (int i = 0; i < count; i++) {
			array[i] = unsameCount - i;
		}
		for (int i = unsameCount; i < count; i++) {
			array[i] = unsameCount + 1;
		}
		return array;
	}

	public static Integer[] copy(Integer[] array) {
		if (array.length <= 0) {
			return null;
		}
		Integer[] array1 = new Integer[array.length];

		for (int i = 0; i < array.length; i++) {
			array1[i] = array[i];
		}
		return array1;
	}

	public static Integer[] ascOrder(int min, int max) {
		if (min > max) {
			return null;
		}
		Integer[] array = new Integer[max - min + 1];

		for (int i = 0; i < array.length; i++) {
			array[i] = min + i;
		}
		return array;
	}

	public static Integer[] headTailAscOrder(int min, int max, int disorderCount) {

		Integer[] array = ascOrder(min, max);
		if (disorderCount > array.length) {
			return array;
		}

		int begin = (array.length - disorderCount) >> 1;
		reverse(array, begin, begin + disorderCount);
		return array;
	}

	public static Integer[] centerAscOrder(int min, int max, int disorderCount) {

		Integer[] array = ascOrder(min, max);
		if (disorderCount > array.length) {
			return array;
		}

		int left = disorderCount >> 1;
		reverse(array, 0, left);
		reverse(array, array.length - left, array.length);
		return array;
	}

	public static void reverse(Integer[] array, int begin, int end) {
		if (array == null || array.length <= 0 || begin >= end || begin < 0 || end > array.length) {
			return;
		}
		end--;
		while (begin < end) {
			Integer e = array[begin];
			array[begin] = array[end];
			array[end] = e;

			begin++;
			end--;
		}
	}

	public static Integer[] tailAscOrder(int min, int max, int disorderCount) {
		if (min > max || disorderCount > max - min) {
			return null;
		}
		Integer[] array = new Integer[max - min + 1];

		for (int i = 0; i < array.length; i++) {
			array[i] = min + i;
		}
		/// 没有排好序的处理disorderCount 区间[min, min+disorderCount-1]
		for (int i = 0; i < disorderCount; i++) {
			array[i] = min + (int) (Math.random() * disorderCount);
		}
		return array;
	}

	public static boolean isAscOrder(Integer[] array) {
		if (array.length <= 0) {
			return false;
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				return false;
			}
		}
		return true;
	}

	public static void print(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print(array[i]);
			} else {
				System.out.print("_" + array[i]);
			}

		}
		System.out.print("\n");
	}
}
