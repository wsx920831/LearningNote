/**
单例设计模式：保证一个类只有一个对象

@author wangsixin
@version 1.0		
*/
import java.util.*;
import java.io.*;


//饿汉单例设计模式（不管用不用，总会在类中声明一个类对象）
class Member{

public
	static Member getInstance(){
		return m;
	}

private
	static Member m = new Member(); //在类中声明并创建类对象，并通过static关键字共享

	Member(){ //私有化构造函数

	}
}

//懒汉单例设计模式（第一次使用时创建类对象）
class Human{

public
	static Human getInstance(){

		//第一次调用时创建类对象
		if (h==null){
			h = new Human();
		}
		return h;
	}

private
	static Human h; //在类中声明并对象，并通过static关键字共享

	Human(){ //私有化构造函数

	}
}


public class Single_Instance_Design{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args) throws Exception{
		Member m1 = Member.getInstance();
		Member m2 = Member.getInstance();
		System.out.println("饿汉模式是否是同一个对象: " + (m1==m2));

		Human h1 = Human.getInstance();
		Human h2 = Human.getInstance();
		System.out.println("懒汉模式是否是同一个对象: " + (h1==h2));
	}		
}