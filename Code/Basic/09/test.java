/**
类说明文档
@author wangsixin
@version 1.0		
*/
import java.util.*;
import java.io.*;

//父类(抽象类)
abstract class Human{

	String name;
	int age;

	int chan = 100;

	Human(){
		System.out.println("父类无参构造函数被调用");
	}

	Human(int age, String name){
		this.age = age;
		this.name = name;
	}

	public void Drink(){
		System.out.println(this.name + "在喝水");
	}

	//抽象方法
	public abstract void Study();

}

//子类
class Student extends Human{

	String SchoolNum;

	int chan = 200;

	//	super关键字调用父类有参数构造函数
	Student(int age, String name){
		super(age,name);
	}

	//重写抽象函数
	public void Study(){
		System.out.println(this.age + "岁的" + this.name + "在背古诗");
	}
}

class Engineer extends Human{

	String WorkAddress;

	int chan = 200;

	//	super关键字调用父类有参数构造函数
	Engineer(int age, String name){
		super(age,name);
	}

	//重写抽象函数
	public void Study(){
		System.out.println(this.age + "岁的" + this.name + "在看论文");
	}
}

abstract class Figure{

	String name; //图形名称

	public Figure(String name){
		this.name = name;
	}

	public abstract void getArea(); //计算面积抽象函数
	public abstract void getLength(); //计算周长抽象函数

}

class Circle extends Figure{
	double r; //半径
	public static final double PI = 3.14; //不能被改写的常量

	public Circle(String name, double r){
		super(name);
		this.r = r;
	}

	//重写抽象函数
	public void getArea(){
		System.out.println(name + "的面积为: " + PI*r*r);
	}

	public void getLength(){
		System.out.println(name + "的周长为: " + PI*r*2);
	}
}

class Rectangle extends Figure{
	double h; //长
	double w; //宽

	public Rectangle(String name, double h, double w){
		super(name);
		this.h = h;
		this.w = w;
	}

	//重写抽象函数
	public void getArea(){
		System.out.println(name + "的面积为: " + h*w);
	}

	public void getLength(){
		System.out.println(name + "的周长为: " + (h+w)*2);
	}
}

//铅笔类
class Pencil{
	String name;

	public Pencil(String name){
		this.name = name;
	}

	public void write(){
		System.out.println(this.name + "在写字");
	}
}

//橡皮接口
interface Eraser{
	public static final int LEN = 10; //成员变量都是常量(常量有啥用？)
	public abstract void clear(); //成员函数都是抽象函数
}

//带橡皮的接口类，继承橡皮类，实现橡皮接口
class PencilWithEraser extends Pencil implements Eraser{

	//调用父类构造函数
	PencilWithEraser(String name){
		super(name);
	}

	//实现接口clear方法
	public void clear(){
		System.out.println(this.name + "清除了内容");
	}
}

public class test{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args) throws Exception{

		Student s1 = new Student(12,"彤彤");
		Engineer e1 = new Engineer(30,"孙大炮");
		s1.Study();
		e1.Study();

		System.out.println("\n==================================\n");

		Circle c1 = new Circle("圆形",2);
		c1.getArea();
		c1.getLength();

		Rectangle r1 = new Rectangle("矩形", 3, 4);
		r1.getArea();
		r1.getLength();

		System.out.println("\n==================================\n");

		
		//交换失败，基本类型传参传的是值
		double a = 2;
		double b = 3; 
		changeValue(a,b);
		System.out.println("main交换结果：" + "a=" + a + ", b=" + b);

		//交换成功，引用类型传参传的是变量
		double[] c = {2,3};
		changeArr(c);
		System.out.println("main交换结果：" + "a=" + c[0] + ", b=" + c[1]);

		//修改成功,Circle是应引用类型变量
		changeObj(c1,200);
		System.out.println("圆形半径 = " + c1.r);

		System.out.println("\n==================================\n");

		PencilWithEraser pe = new PencilWithEraser("2B铅笔");

		pe.write();
		pe.clear();

	}

	public static void changeValue(double a, double b){
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("changeValue交换结果：" + "a=" + a + ", b=" + b);
	}

	public static void changeArr(double[] arr){
		arr[0] = arr[0] + arr[1];
		arr[1] = arr[0] - arr[1];
		arr[0] = arr[0] - arr[1];
		System.out.println("changeValue交换结果：" + "a=" + arr[0] + ", b=" + arr[1]);
	}

	public static void changeObj(Circle c, double r){
		c.r = r;
	}		
}