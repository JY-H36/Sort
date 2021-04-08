package algorithm;

public class Sort {
	// 快排(比较类排序):每次确定数组中起点first到终点last数据中基数的位置,(期间可能会有数据的交换),二分数据,左边数据均比基数小,右边数据均比基数大
	// 快速排序相比冒泡排序,进行了跳跃式的交换,每一轮比较实现的功能:1.确定基数的位置 2.二分数据:左边数据均比基数小,右边数据均比基数大
	// 时间复杂度: 平均:nlgn 最坏(相邻的数进行交换):n*n
	public static int[] quick(int[] arr, int first, int last) {
		int i = first;
		int j = last;
		int t;
		// 设置基数
		int base = arr[first];
		// 设置递归出口
		if (first > last)
			return arr;
		// 对基数定位
		while (i != j) {
			// 从后面往前找小于基数的数据，标记
			// 基数取第一个时必须先从后往前走,否则会出现以下情况:
			// 基数本身在比较的数据中是最小的时,必然导致基数与后一位数据进行交换，且不可逆
			// 很明显此时得到的二份数据已经不是最初设计快排算法时想要得到的数据了
			while (arr[j] >= base && i < j) {
				j--;
			}
			// 从前面往后找大于基数的数据，标记
			while (arr[i] <= base && i < j) {
				i++;
			}
			// 交换前面标记的两个数据
			if (i < j) {
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		// 交换基数与定位后位置上的数
		arr[first] = arr[i];
		arr[i] = base;
		// 对左边数据递归调用快排
		quick(arr, first, i - 1);
		// 对右边数据递归调用快排
		quick(arr, i + 1, last);
		return arr;
	}

	// 插入排序:在有序数组(将数组中的前面的数据看成一个有序数组,第一次将第一个元素看成一个数组)中插入新元素使新数组有序
	// 时间复杂度: 最好:O(n) 最坏:O(n2)
	public static int[] insert(int[] arr) {
		// 每一轮插入使0到i的元素有序
		for (int i = 1; i < arr.length; i++) {
			// 标记将要插入的目标元素
			int temp = arr[i];
			int j;
			// 从后往前走,在0到i-1的元素中大于目标元素temp的均后移一位
			for (j = i; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			// 插入目标元素
			arr[j] = temp;
		}
		return arr;
	}

	// 冒泡排序:每一轮交换将无序区最大的元素置于最后,大数沉淀,小数冒泡.
	// 时间复杂度: 最好:O(n) 最坏:O(n2)
	public static int[] bubble(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	// 选择排序:每一轮比较将无序区最小值与初值交换
	// 时间复杂度: 最好:O(n) 最坏:O(n2)
	public static int[] select(int[] arr) {
		int temp = 0;
		int j;
		// 控制比较次数
		for (int i = 0; i < arr.length - 1; i++) {
			// 先设置初值是最小值
			int min = arr[i];
			// 最小值标记
			int k = i;
			// 通过循环求得无序区最小值
			for (j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					k = j;
				}
			}
			// 交换最小值与初值
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	// 希尔排序(缩小增量排序):将整组数据按照增量分组,对每一组数据进行插入排序,使得整组数据越来越接近有序,增量为1作为结束的标志,执行最后一次插入排序后结束希尔排序
	public static int[] shell(int[] arr) {
		// 如果数组是null或者数组元素只有一个直接返回
		if (arr == null || arr.length == 1) {
			return arr;
		}
		// 设置希尔增量
		int len = arr.length / 2;
		while (len > 0) {
			for (int i = len; i < arr.length; i++) {
				// 标记要插入的新数据
				int temp = arr[i];
				int j;
				// j是按照希尔增量分组后i之前的数据
				// 当j<0或者遇到比新元素temp小的数据时循环结束
				for (j = i - len; j >= 0 && arr[j] >= temp; j -= len) {
					if (arr[j] > temp) {
						arr[j + len] = arr[j];
					}
				}
				arr[j + len] = temp;
			}
			len /= 2;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 6, 4, 8, 3, 10 };
		int[] arr1 = new int[arr.length];
		arr1 = shell(arr);
		PrintArray.pri(arr1);
	}
}
