package algorithm;
public class ShellSort {
    public static void shellSort(int[] arr) {
        // ������ �� ֻ��һ��Ԫ�ص����飬��ʲô��������
        if (arr == null || arr.length <= 1) return;
        // ����ϣ��������
        int gap = arr.length / 2;
        // gap��С��0��ʱ����˳�ѭ����
        while (gap != 0) {
            // ÿ�����ֱ�Ӳ�������
            for (int i = gap; i < arr.length; i++) {    // i ���������Ԫ�ص�������
                int value = arr[i];
                int j = i - gap;    // j ����i����һ��Ԫ�أ����һ������gap��
 
                // j < 0 ʱ�˳�ѭ����˵�� j ����С��Ԫ�ص�����ֵ��
                // ���� arr[j] <= value ʱ�˳�ѭ����˵�� j �Ǳ�valueС��Ԫ�ص�����ֵ��
                for (; j >= 0 && arr[j] > value; j -= gap) {
                    arr[j + gap] = arr[j];  // ��Ԫ������Ų��
                }
                arr[j + gap] = value;
 
            }
            // ��ÿһ������Ľ��Ҳ���һ�¡�
            print(arr);
 
            // ��С������
            gap /= 2;
        }
    }
 
    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};
 
        System.out.print("����ǰ:  ");
        print(arr);
 
        shellSort(arr);
 
        System.out.print("�����:  ");
        print(arr);
    }
 
    // ��ӡ����
    public static void print(int[] arr) {
        if (arr == null)    return;
 
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
/*
����ǰ:  6 9 1 4 5 8 7 0 2 3 
6 7 0 2 3 8 9 1 4 5 
0 1 3 2 4 5 6 7 9 8 
0 1 2 3 4 5 6 7 8 9 
�����:  0 1 2 3 4 5 6 7 8 9 
*/
