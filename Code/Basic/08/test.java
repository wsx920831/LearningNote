/**
类说明文档
@author wangsixin
@version 1.0		
*/
import java.util.*;
import java.io.*;

//父类
class Human{

	String name;
	int age;

	int chan = 100;

	Human(){
		System.out.println("父类无参构造函数被调用");
	}

	Human(int age, String name){
		System.out.println("父类有参构造函数被调用");
		this.age = age;
		this.name = name;
	}

	public void Drink(){
		System.out.println(this.name + "在喝水");
	}

}

//子类
class Student extends Human{

	String SchoolNum;

	int chan = 200;

	//	super关键字调用父类有参数构造函数
	Student(int age, String name){
		super(age,name);
	}

	public void Study(){
		System.out.println(this.name + "在学习");
		System.out.println("子类成员变量chan = " + this.chan);
		System.out.println("父类成员变量chan = " + super.chan);
	}
}

public class test{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args) throws Exception{

		Student s1 = new Student(12,"honghong");
		s1.Drink();
		s1.Study();

		System.out.println(s1.name + "是学生类么:" + (s1 instanceof Student));
		System.out.println(s1.name + "是人类么:" + (s1 instanceof Human));

		Human h1 = new Human(88,"King");

		System.out.println(h1.name + "是学生类么:" + (h1 instanceof Student));
		System.out.println(h1.name + "是人类么:" + (h1 instanceof Human));



	}		
}