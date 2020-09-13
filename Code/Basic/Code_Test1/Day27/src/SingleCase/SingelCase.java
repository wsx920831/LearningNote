package SingleCase;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/13 2:19
 * @Version 1.0
 */

//解决懒汉单例设计模式的线程安全问题
class Single{
    int age;
    //私有化声明本类静态变量（饿汉模式直接在这new一个本类对象）
    private static Single s;

    //私有化构造函数
    private Single(int age) {
        this.age = age;
    }

    //提供公有静态方法获取本类对象
    public static Single getInstance(){
        if (s == null) { //解决效率问题，不用每次同步
            synchronized ("lock") { //解决线程安全问题
                if (s == null){
                    s = new Single(12);
                }
            }
        }
        return s;
    }
}

public class SingelCase {
    public static void main(String[] args) {
        System.out.println("age = " + Single.getInstance().age);

    }
}
