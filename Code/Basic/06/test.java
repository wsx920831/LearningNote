/**
类说明文档
@author wangsixin
@version 1.0		
*/
import java.util.*;
import java.io.*;

class car{

	//成员变量
	int wheel;
	String name;
	String color;

	//成员方法
	public void run(){
		if (wheel >= 4){
			System.out.println(color + " " + name + " 汽车跑");
		}
		else{
			System.out.println("需要修理");
		}
	}
}

class repairFac{

	//成员变量
	String name;
	String address;
	String tel;

	//成员方法
	public void repair(car c){ //传入引用
		c.wheel = 4;
	}
}

class Memeber{

public
	String getSex(){
		return sex;
	}

	void setSex(String s){
		if (s.equals("男") || s.equals("女")){
			sex = s;
		}
		else{
			sex = "Nan";
		}

	}

private
	String name;
	String sex;
}

class Compute{

	void set_all(int n1, int n2, String s){
		this.n1 = n1;
		this.n2 = n2;
		if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
			this.symbol = s;
		}
		else{
			this.symbol = "Nan";
		}

	}

	int compute1(){
		if (this.symbol.equals("Nan") || this.symbol.equals("+")){
			return this.n1 + this.n2;
		}
		else if (this.symbol.equals("-")){
			return this.n1 - this.n2;
		}
		else if (this.symbol.equals("*")){
			return this.n1 * this.n2;
		}
		else {
			return this.n1 / this.n2;
		}
	}

private
	int n1;
	int n2;
	String symbol;
}

public class test{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args) throws Exception{
		car cc = new car();
		cc.name = "BMW";
		cc.color = "Red";
		cc.wheel = 3;
		cc.run();

		repairFac r = new repairFac();

		r.repair(cc);

		cc.run();

		Memeber mm = new Memeber();

		mm.setSex("男");

		System.out.println(mm.getSex());

		Compute c1 = new Compute();

		c1.set_all(12,15,"a");

		int re = c1.compute1();

		System.out.println("结果 = " + re);

		int[] cc1 = {1,20,0,0,30,50};

		cc1 = clearZero(cc1);

		System.out.println("去0结果 = " + Arrays.toString(cc1));



	}

	static int[] clearZero(int[] n){

		//统计0的个数
		int num = 0;
		for (int i=0; i<n.length; i++){
			if (n[i] != 0){
				num += 1;
			}
		}

		if (num == n.length){
			return n;
		}
		else{
			int[] n2 = new int[num];
			int count = 0;
			for (int i=0; i<n.length; i++){
				if (n[i] != 0){
					n2[count] = n[i];
					count ++;
				}

			}
			return n2;
		}


	}
		
}