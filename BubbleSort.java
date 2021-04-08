package algorithm;

public class BubbleSort{
	int[] arr;
	public BubbleSort(int[] arr) {
		this.arr=arr;
	}
	public int[] toHigher(){ //����BubbleSort�е�toHigher�����󷵻������������
		int temp=0;
		for(int i=0;i<arr.length-1;i++) {	
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public int[] toLower() { //����BubbleSort�е�toLower�����󷵻������������
		int temp=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]<arr[j+1]) {
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) 
			System.out.print(" "+arr[i]);
	}
}

