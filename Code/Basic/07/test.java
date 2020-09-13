/**
类说明文档
@author wangsixin
@version 1.0		
*/
import java.util.*;
import java.io.*;


class Member{

public
	Member(int a, String n){
		
		this(n); //调用另外一个构造函数
		System.out.println("被调用");
		this.age = a;
	}

	Member(String n){
		this.name = n;
	}

	//构造代码块执行
	{
		PrintAge();
	}

	int getAge(){
		int age = 200;
		System.out.println("局部变量 Age = " + age);
		System.out.println("成员变量 Age = " + this.age);
		return this.age;
	}

	String getName(){
		return this.name;
	}

	void PrintAge(){
		System.out.println("Age = " + this.age);
	}

private
	String name;
	int age;
}

class Human{

	String name;
	int age;

	//静态成员变量
	static int count = 0;

	{
		count ++;
		System.out.println("创建" + count + "次对象");

	}

	Human(String name, int age){
		this.age = age;
		this.name = name;
	}

	void CompareAge(Human p){
		if (this.age > p.age){
			System.out.println(this.name + "年龄大");			
		}
		else if (this.age < p.age){
			System.out.println(p.name + "年龄大");	
		}
		else{
			System.out.println("同龄");	
		}
	}

	static void ware(){
		System.out.println("count = " + count);	
	}

}

public class test{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args) throws Exception{
		Member m1 = new Member(12,"honghong");

		System.out.println("年龄 = " + m1.getAge());

		System.out.println("名字= " + m1.getName());

		Human p1 = new Human("honghong",12);

		Human p2 = new Human("huanghuang",12);

		Human p3 = new Human("huanghuang",12);

		System.out.println("count = " + Human.count);

		p1.CompareAge(p2);

		p1.ware();
	}		
}