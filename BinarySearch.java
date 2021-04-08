package algorithm;

public class BinarySearch {
	//普通二分查找:int型有序数组
	public static void search(int[] arr,int key) {
		int high=arr.length-1;
		int low=0;
		while(low<=high) {
			int mid=(low+high)/2;
			if(key>arr[mid]) {
				low=mid+1;		
			}
			else if(arr[mid]==key) {
				System.out.println(key+"在数组中下标:"+mid);
				break;
			}
			else {
				high=mid-1;	
			}
		}
		if(low>high){
			System.out.println("数组中找不到"+key);
		}
	}
	//double型有序数组
	public static void search(double[] arr,double key) {
		int high=arr.length-1;
		int low=0;
		while(low<=high) {
			int mid=(low+high)/2;
			if(key>arr[mid]) {
				low=mid+1;		
			}
			else if(arr[mid]==key) {
				System.out.println(key+"在数组中下标:"+mid);
				break;
			}
			else {
				high=mid-1;	
			}
		}
		if(low>high){
			System.out.println("数组中找不到"+key);
		}
	}
	//递归调用二分查找
	public static void search(int[] arr,int low,int high,int key) {
		int mid=(low+high)/2;
		//设置递归出口
		if(low>high) {
			System.out.println("找不到关键字"+key);
			return ;
		}
		//关键字小于中间值时，对左边数据递归调用二分查找
		if(arr[mid]>key) {
			search(arr,low,mid-1,key);
		}
		//关键字大于中间值时，对右边数据递归调用二分查找
		else if(arr[mid]<key) {
			search(arr,mid+1,high,key);
		}
		else{
			System.out.println("关键字"+key+"在数组中的下标:"+mid);
		}
	}
	public static void search(double[] arr,int low,int high,int key) {
		int mid=(low+high)/2;
		//设置递归出口
		if(low>high) {
			System.out.println("找不到关键字"+key);
			return ;
		}
		//关键字小于中间值时，对左边数据递归调用二分查找
		if(arr[mid]>key) {
			search(arr,low,mid-1,key);
		}
		//关键字大于中间值时，对右边数据递归调用二分查找
		else if(arr[mid]<key) {
			search(arr,mid+1,high,key);
		}
		else{
			System.out.println("关键字"+key+"在数组中的下标:"+mid);
		}
	}
}
