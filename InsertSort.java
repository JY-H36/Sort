package algorithm;

public class InsertSort {
	public static int[] insert(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i];
			//从后往前走，比要插入的数的大的均后移一位
			int j;
			for(j=i;j>0&&arr[j-1]>temp;j--) {
				arr[j]=arr[j-1];
			}
			arr[j]=temp;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr=new int[] {6,1,4,3,5};
		int[] arr1=new int[arr.length];
		arr1=insert(arr);
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
}
