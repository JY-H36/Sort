package algorithm;

public class SelectSort {
	int[] arr;
	public SelectSort(int[] arr) {
		this.arr=arr;
	}
	public int[] toHigher() {
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			int k=i;
			int min=arr[i];
			for(int j=i;j<arr.length;j++)
				if(arr[j]<min) {
					min=arr[j];
					k=j;
				}
			temp=arr[k];
			arr[k]=arr[i];
			arr[i]=temp;
		}
		return arr;
	}
	public int[] toLower() {
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			int k=i;
			int max=arr[i];
			for(int j=i;j<arr.length;j++)
				if(arr[j]>max) {
					max=arr[j];
					k=j;
				}
			temp=arr[k];
			arr[k]=arr[i];
			arr[i]=temp;
		}
		return arr;
	}
	public void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) 
			System.out.print(" "+arr[i]);
	}
}
