package algorithm;

public class QuickSort {
	public static int[] sort(int[] arr, int first, int last) {

		int i = first;
		int j = last;
		int t;
		//设置递归出口
		if (first > last)
			return arr;
		//设置基数，一般取首位上的数据
		int base = arr[first];
		while (i < j) {
		//从后面往前找小于基数的数据，标记
		//基数取第一个时必须先从后往前走,否则会出现以下情况:
		//基数本身在比较的数据中是最小的时,必然导致基数与后一位数据进行交换，且不可逆
		//很明显此时得到的二份数据已经不是最初设计快排算法时想要得到的数据了
			while (arr[j] >= base && i < j) {
				j--;
			}
		//从前面往后找大于基数的数据，标记
			while (arr[i] <= base && i < j) {
				i++;
			}
		//交换前面标记的两个数据
			if (i < j) {
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		//交换基数与定位后位置上的数
		arr[first] = arr[i];
		arr[i] = base;
		//对左边数据递归调用快排
		sort(arr, i + 1, last);
		//对右边数据递归调用快排
		sort(arr, first, i - 1);
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {6,1,5,4,8,3,10,9,2};
		sort(arr, 0, arr.length - 1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
