/**
类说明文档
@author wangsixin
@version 1.0		
*/
import java.util.*;
import java.io.*;
public class test{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args) throws Exception{


		//数组
		//声明数组
		double[] a = new double[10];

		a[0] = 10;
		a[1] = 30;

		System.out.println("数组长度 = " + a.length);
		System.out.println("a[0] = " + a[0]);

		int[] b = {10,100,32,4,5,6,7};
		int max0 = max(b);
		System.out.println("最大值 = " + max0);

		sort(b);
		System.out.println("===");
		Bubblesort(b);

		int c[] = {4,7,10,12,16};
		int index = BinSearch(c, 16);
		System.out.println("索引 = " + index);

		String str = Arrays.toString(c);
		System.out.println("c = " + str);

		String str1 = "[";
		for (int i=0; i<c.length; i++){
			str1 += c[i];
			if (i < c.length-1){
				str1 += ", ";
			}
		}
		str1 += "]";
		System.out.println("str1 = " + str1);


		
	}

	public static int max(int[] a){
		int max = a[0];
		for (int i = 1; i<a.length; i++){
			if (a[i] > max){
				max = a[i];
			}
		}
		return max;
	}

	//选择排序(一个元素去跟所有值比较)
	public static void sort(int[] a){
		for (int i=0; i<a.length-1; i++){
			for (int j=i+1; j<a.length; j++){
				if (a[i] < a[j]){
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
		}

		for (int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	
	//冒泡排序(相邻元素比较)
	public static void Bubblesort(int[] a){
		for (int k=1; k<a.length; k++){
			for (int i=0; i<a.length-k; i++){
				if (a[i] > a[i+1]){
					a[i] = a[i] + a[i+1];
					a[i+1] = a[i] - a[i+1];
					a[i] = a[i] - a[i+1];				
				}
			}			
		}


		for (int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}		

	}
	

	//二分查找
	public static int BinSearch(int[] a, int b){
		int left = 0; //左边界索引初始值
		int mid; //中间索引
		int right = a.length-1; //右边界索引初始值
		while (left<=right){
			mid = left + (right-left)/2;
			if (a[mid] == b){
				return mid;
			}
			else if (a[mid] < b){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
						
		}
		return -1;
	}
	
	
}