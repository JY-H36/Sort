package algorithm;

public class Hanoi {
	public static void hanoiReturn(int n,char begin,char mid,char end){
	//��ŵ������ִ��3����nΪ��ǰ��Ҫ�Ƶ�������beginΪ��㣬midΪ�����㣬endΪ�յ�
	//1����ǰn-1���Ƶ����յ���ĵ�
	//2������n���Ƶ��յ�
	//3����ǰn-1���Ƶ��յ�
		if(n==1) {
			System.out.println(n+"��"+begin+"�Ƶ�"+end);
		}
		else {
			hanoiReturn(n-1,begin,end,mid);             //��һ��
			System.out.println(n+"��"+begin+"�Ƶ�"+end);//�ڶ���
			hanoiReturn(n-1,mid,begin,end);				//������
		}	
	}
	public static void main(String[] args) {
		int n=5;
		char left='A';
		char mid='B';
		char right='C';
		hanoiReturn(n,left,mid,right);
	}
}
