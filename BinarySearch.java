package algorithm;

public class BinarySearch {
	//��ͨ���ֲ���:int����������
	public static void search(int[] arr,int key) {
		int high=arr.length-1;
		int low=0;
		while(low<=high) {
			int mid=(low+high)/2;
			if(key>arr[mid]) {
				low=mid+1;		
			}
			else if(arr[mid]==key) {
				System.out.println(key+"���������±�:"+mid);
				break;
			}
			else {
				high=mid-1;	
			}
		}
		if(low>high){
			System.out.println("�������Ҳ���"+key);
		}
	}
	//double����������
	public static void search(double[] arr,double key) {
		int high=arr.length-1;
		int low=0;
		while(low<=high) {
			int mid=(low+high)/2;
			if(key>arr[mid]) {
				low=mid+1;		
			}
			else if(arr[mid]==key) {
				System.out.println(key+"���������±�:"+mid);
				break;
			}
			else {
				high=mid-1;	
			}
		}
		if(low>high){
			System.out.println("�������Ҳ���"+key);
		}
	}
	//�ݹ���ö��ֲ���
	public static void search(int[] arr,int low,int high,int key) {
		int mid=(low+high)/2;
		//���õݹ����
		if(low>high) {
			System.out.println("�Ҳ����ؼ���"+key);
			return ;
		}
		//�ؼ���С���м�ֵʱ����������ݵݹ���ö��ֲ���
		if(arr[mid]>key) {
			search(arr,low,mid-1,key);
		}
		//�ؼ��ִ����м�ֵʱ�����ұ����ݵݹ���ö��ֲ���
		else if(arr[mid]<key) {
			search(arr,mid+1,high,key);
		}
		else{
			System.out.println("�ؼ���"+key+"�������е��±�:"+mid);
		}
	}
	public static void search(double[] arr,int low,int high,int key) {
		int mid=(low+high)/2;
		//���õݹ����
		if(low>high) {
			System.out.println("�Ҳ����ؼ���"+key);
			return ;
		}
		//�ؼ���С���м�ֵʱ����������ݵݹ���ö��ֲ���
		if(arr[mid]>key) {
			search(arr,low,mid-1,key);
		}
		//�ؼ��ִ����м�ֵʱ�����ұ����ݵݹ���ö��ֲ���
		else if(arr[mid]<key) {
			search(arr,mid+1,high,key);
		}
		else{
			System.out.println("�ؼ���"+key+"�������е��±�:"+mid);
		}
	}
}
