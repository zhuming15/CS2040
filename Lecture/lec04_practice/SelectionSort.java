import java.util.Arrays;

class SelectionSort {
	public static void selectionSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			int index = i;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[index]) index = j;
			}

			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		};
		System.out.println(Arrays.toString(a));
	}
}
