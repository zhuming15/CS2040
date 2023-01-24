import java.util.Arrays;

class BubbleSort {
   public static void bubbleSort(int[] a) {
	for (int i = 1; i < a.length; i++) {
		boolean sorted = false;
		for (int j = 0; j < a.length - i; j++) {
			if (a[j] > a[j+1]) { // the larger item bubbles down (swap)
				int temp = a[j]; 
				a[j] = a[j+1]; 
				a[j+1] = temp; 
				sorted = true;
				}
			}
		if (!sorted) break;
		}
	}
}
