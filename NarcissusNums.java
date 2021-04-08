package algorithm;

import java.util.Scanner;

public class NarcissusNums {
	// �ж�n�Ƿ���ˮ�ɻ���
	public static boolean narcissusGet(int n) {
		if (n < 100) {
			System.out.println("���������̫С!!");
			return false;
		}
		boolean flag = false;
		// k���n��λ��
		int k = 0;
		// ����n�ĸ���
		int fb1 = n;
		int fb2 = n;
		while (fb1 != 0) {
			k++;
			fb1 /= 10;
		}
		int sum = 0;
		while (fb2 > 0) {
			int j = fb2 % 10;
			fb2 /= 10;
			sum += Math.pow(j, k);
		}
		if (sum == n) {
			flag = true;
		}
		return flag;
	}

	// ��Ŀ�귶Χ�ڵ�ˮ�ɻ����鳤��
	public static int narcissusNumsLen(int bound) {
		int len = 0;
		for (int i = 100; i < bound; i++) {
			if (narcissusGet(i)) {
				len++;
			}
		}
		return len;
	}

	// �Է�Χ�ڵ�ˮ�ɻ����鸳ֵ
	public int[] narcissusNums(int bound) {
		int[] arr = new int[narcissusNumsLen(bound)];
		int mark = 0;
		for (int i = 100; i < bound; i++) {
			if (narcissusGet(i)) {
				arr[mark] = i;
				mark++;
			}
		}
		return arr;
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		NarcissusNums nar = new NarcissusNums();
		Scanner read = new Scanner(System.in);
		int bound = read.nextInt();
		int[] arr = nar.narcissusNums(bound);
		nar.print(arr);
		read.close();
	}
}
