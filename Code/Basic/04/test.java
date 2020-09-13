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

		int age = 20;
		//IF语句
		if (age>=18){
			System.out.println("成年人");
		}
		else{
			System.out.println("未成年人");
		}

		//录入数据
		// System.out.println("请输入成绩: ");
		// Scanner scanner = new Scanner(System.in); //创建扫描器
		// int num = scanner.nextInt(); //接收扫描到的数据
		// System.out.println("输入的成绩是: " + num);

		//switch
		String option = "abc";
		switch (option){
			case "cdf":
				System.out.println("C++");
				// break;
			case "abc":
				System.out.println("Java");
				// break;
			case "hkk":
				System.out.println("Python");
				// break;
			default:
				System.out.println("Error");
				// break;
		}
		
		//swich练习
		// System.out.println("请输月份: ");
		Scanner scanner = new Scanner(System.in); //创建扫描器
		// int num = scanner.nextInt(); //接收扫描到的数据
		// System.out.println("输入的月份是: " + num);

		// switch (num){
		// 	//当num=1时，程序会继续往下执行直至遇到break
		// 	case 1:
		// 	case 2:
		// 	case 3:
		// 		System.out.println("春天");
		// 		break;
		// 	case 4:
		// 	case 5:
		// 	case 6:
		// 		System.out.println("夏天");
		// 		break;	
		// 	case 7:
		// 	case 8:
		// 	case 9:
		// 		System.out.println("秋天");
		// 		break;
		// 	case 10:
		// 	case 11:
		// 	case 12:
		// 		System.out.println("冬天");
		// 		break;
		// 	default:				
		// 	    System.out.println("Error");
		// 		break;

		// }

		//while练习
		
		//计算1-100中7的倍数总和
		int num1 = 1;
		int sum1 = 0;
		while (num1<=100){
			if (num1%7 == 0) sum1 += num1;
			num1++;
		}
		System.out.println("7倍数之和= " + sum1);
		
		
		//创建随机数对象
		Random random = new Random();

		int count = 0;

		while (true){
			System.out.println("请输入数字: ");
			int num = scanner.nextInt(); //接收扫描到的数据
			int N0 = 5 + random.nextInt(6);
			if (N0 == num){
				System.out.println("恭喜你猜对了！");
				break;
			}
			
			else{
				count++;
				if (count >= 3){
					System.out.println("游戏失败！");
					break;
				}
				else System.out.println("猜错了, 游戏剩余次数：" + (3-count) + "次");

			} 
		}

		//for 循环与转义字符练习：9*9乘法表
		for (int i = 1; i<=9; i++){
			for (int j = 1; j<=i; j++){
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();//换行
		}

		System.out.println("Hello123\rworld");//换行

		File file = new File("E:\\a.txt");
		FileWriter hh = new FileWriter(file);
		hh.write("123\r\n");
		hh.write("456\n");
		hh.close();







		










		
	}
	
}