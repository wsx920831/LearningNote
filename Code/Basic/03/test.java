/**
类说明文档
@author wangsixin
@version 1.0		
*/
import java.util.*;
public class test{

	/**
	main说明文档		
 	*/
 	
	public static void main(String[] args){

		//byte、short、char运算时都会自动转换成int计算，结果也为int类型，其他类型需要强转
		byte a = -10;
		byte b = 20;
		byte c = (byte) (a + b); //计算完成为int,其他类型需要强转
		System.out.println(Integer.toBinaryString(c));

		System.out.println(c);
		System.out.println('a'+1);

		//不同类型数据运算时，结果取决于大数据类型
		int i = 10;
		long j = 20L;
		i = (int) (i + j); //结果为long,需要强转
		System.out.println(i);

		//算术运算符
		System.out.println(1+2+3+"abc"+4+5+6);

		//先自增
		int aa = 10;
		int sum1 = ++aa;

		//后自增
		int bb = 10;
		int sum2 = bb++;

		System.out.println("sum1="+sum1+"  sum2="+sum2);

		int cc = 10;
		cc = cc++;

		System.out.println("cc = "+cc);

		//位运算
		System.out.println(6&3);
		System.out.println(6|3);
		System.out.println(6^3^3);

		//不用第三个变量交换两个变量的值
		
		//相加法(可能超int范围)
		aa = 3;
		bb = 5;

		aa = aa + bb;
		bb = aa - bb;
		aa = aa - bb;

		System.out.println("aa = "+aa+"  bb = "+bb);

		//异或法
		aa = aa^bb;
		bb = aa^bb;
		aa = aa^bb;

		System.out.println("aa = "+aa+"  bb = "+bb);

		System.out.println(2<<3);

		//三元运算符
		int age = 19;
		String Str = age>=18? "成年人": "未成年人";

		System.out.println(Str);

		//IF语句
		if (age>=18){
			System.out.println("成年人");
		}
		else{
			System.out.println("未成年人");
		}

		//录入数据
		System.out.println("请输入成绩: ");
		Scanner scanner = new Scanner(System.in); //创建扫描器
		int num = scanner.nextInt(); //接收扫描到的数据
		System.out.println("输入的成绩是: " + num);




		










		
	}
	
}