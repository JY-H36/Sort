package algorithm;

public class QuickSort {
	public static int[] sort(int[] arr, int first, int last) {

		int i = first;
		int j = last;
		int t;
		//���õݹ����
		if (first > last)
			return arr;
		//���û�����һ��ȡ��λ�ϵ�����
		int base = arr[first];
		while (i < j) {
		//�Ӻ�����ǰ��С�ڻ��������ݣ����
		//����ȡ��һ��ʱ�����ȴӺ���ǰ��,���������������:
		//���������ڱȽϵ�����������С��ʱ,��Ȼ���»������һλ���ݽ��н������Ҳ�����
		//�����Դ�ʱ�õ��Ķ��������Ѿ����������ƿ����㷨ʱ��Ҫ�õ���������
			while (arr[j] >= base && i < j) {
				j--;
			}
		//��ǰ�������Ҵ��ڻ��������ݣ����
			while (arr[i] <= base && i < j) {
				i++;
			}
		//����ǰ���ǵ���������
			if (i < j) {
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		//���������붨λ��λ���ϵ���
		arr[first] = arr[i];
		arr[i] = base;
		//��������ݵݹ���ÿ���
		sort(arr, i + 1, last);
		//���ұ����ݵݹ���ÿ���
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
