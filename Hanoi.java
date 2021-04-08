package algorithm;

public class Hanoi {
	public static void hanoiReturn(int n,char begin,char mid,char end){
	//汉诺塔方法执行3步，n为当前需要移的总数，begin为起点，mid为桥梁点，end为终点
	//1：将前n-1个移到除终点外的点
	//2：将第n个移到终点
	//3：将前n-1个移到终点
		if(n==1) {
			System.out.println(n+"从"+begin+"移到"+end);
		}
		else {
			hanoiReturn(n-1,begin,end,mid);             //第一步
			System.out.println(n+"从"+begin+"移到"+end);//第二步
			hanoiReturn(n-1,mid,begin,end);				//第三步
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
