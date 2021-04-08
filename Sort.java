package algorithm;

public class Sort {
	// ����(�Ƚ�������):ÿ��ȷ�����������first���յ�last�����л�����λ��,(�ڼ���ܻ������ݵĽ���),��������,������ݾ��Ȼ���С,�ұ����ݾ��Ȼ�����
	// �����������ð������,��������Ծʽ�Ľ���,ÿһ�ֱȽ�ʵ�ֵĹ���:1.ȷ��������λ�� 2.��������:������ݾ��Ȼ���С,�ұ����ݾ��Ȼ�����
	// ʱ�临�Ӷ�: ƽ��:nlgn �(���ڵ������н���):n*n
	public static int[] quick(int[] arr, int first, int last) {
		int i = first;
		int j = last;
		int t;
		// ���û���
		int base = arr[first];
		// ���õݹ����
		if (first > last)
			return arr;
		// �Ի�����λ
		while (i != j) {
			// �Ӻ�����ǰ��С�ڻ��������ݣ����
			// ����ȡ��һ��ʱ�����ȴӺ���ǰ��,���������������:
			// ���������ڱȽϵ�����������С��ʱ,��Ȼ���»������һλ���ݽ��н������Ҳ�����
			// �����Դ�ʱ�õ��Ķ��������Ѿ����������ƿ����㷨ʱ��Ҫ�õ���������
			while (arr[j] >= base && i < j) {
				j--;
			}
			// ��ǰ�������Ҵ��ڻ��������ݣ����
			while (arr[i] <= base && i < j) {
				i++;
			}
			// ����ǰ���ǵ���������
			if (i < j) {
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		// ���������붨λ��λ���ϵ���
		arr[first] = arr[i];
		arr[i] = base;
		// ��������ݵݹ���ÿ���
		quick(arr, first, i - 1);
		// ���ұ����ݵݹ���ÿ���
		quick(arr, i + 1, last);
		return arr;
	}

	// ��������:����������(�������е�ǰ������ݿ���һ����������,��һ�ν���һ��Ԫ�ؿ���һ������)�в�����Ԫ��ʹ����������
	// ʱ�临�Ӷ�: ���:O(n) �:O(n2)
	public static int[] insert(int[] arr) {
		// ÿһ�ֲ���ʹ0��i��Ԫ������
		for (int i = 1; i < arr.length; i++) {
			// ��ǽ�Ҫ�����Ŀ��Ԫ��
			int temp = arr[i];
			int j;
			// �Ӻ���ǰ��,��0��i-1��Ԫ���д���Ŀ��Ԫ��temp�ľ�����һλ
			for (j = i; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			// ����Ŀ��Ԫ��
			arr[j] = temp;
		}
		return arr;
	}

	// ð������:ÿһ�ֽ���������������Ԫ���������,��������,С��ð��.
	// ʱ�临�Ӷ�: ���:O(n) �:O(n2)
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

	// ѡ������:ÿһ�ֱȽϽ���������Сֵ���ֵ����
	// ʱ�临�Ӷ�: ���:O(n) �:O(n2)
	public static int[] select(int[] arr) {
		int temp = 0;
		int j;
		// ���ƱȽϴ���
		for (int i = 0; i < arr.length - 1; i++) {
			// �����ó�ֵ����Сֵ
			int min = arr[i];
			// ��Сֵ���
			int k = i;
			// ͨ��ѭ�������������Сֵ
			for (j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					k = j;
				}
			}
			// ������Сֵ���ֵ
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	// ϣ������(��С��������):���������ݰ�����������,��ÿһ�����ݽ��в�������,ʹ����������Խ��Խ�ӽ�����,����Ϊ1��Ϊ�����ı�־,ִ�����һ�β�����������ϣ������
	public static int[] shell(int[] arr) {
		// ���������null��������Ԫ��ֻ��һ��ֱ�ӷ���
		if (arr == null || arr.length == 1) {
			return arr;
		}
		// ����ϣ������
		int len = arr.length / 2;
		while (len > 0) {
			for (int i = len; i < arr.length; i++) {
				// ���Ҫ�����������
				int temp = arr[i];
				int j;
				// j�ǰ���ϣ�����������i֮ǰ������
				// ��j<0������������Ԫ��tempС������ʱѭ������
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
