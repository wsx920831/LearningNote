package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/15 0:16
 * @Version 1.0
 */

//反射练习

class Person{
    public String name;
    private int age;

    private Person(){};

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(age + "岁的" + name + "在吃。");
    }

    private void drink(){
        System.out.println(age + "岁的" + name + "在喝。");
    }

    public static void sleep(int sec){
        System.out.println("睡" + sec + "秒");
    }



    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //获取Class对象方式1
        Class p1zz = Person.class;
        System.out.println("完整类名：" + p1zz.getName());

//        //获取Class对象方式2
//        Person p1 = new Person("wsx",12);
//        Class p2zz = p1.getClass();
//        System.out.println("简单类名：" + p1zz.getSimpleName());

        //获取Class对象方式3
        Class p3zz = Class.forName("Reflect.Person");

        //获取公有构造函数
        System.out.println("======获取公有构造函数=======");
        Constructor[] constructors1 = p3zz.getConstructors();
        for (int i = 0; i < constructors1.length; i++) {
            System.out.println(constructors1[i]);
        }

        //获取全部构造函数
        System.out.println("======获取全部构造函数=======");
        Constructor[] constructors2 = p3zz.getDeclaredConstructors();
        for (int i = 0; i < constructors2.length; i++) {
            System.out.println(constructors2[i]);
        }

        //获取指定参数构造函数
        System.out.println("======获取指定参数构造函数=======");
        Constructor constructor3 = p3zz.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor3);

        System.out.println("======暴力反射：用私有构造函数创建对象=======");
        constructor3.setAccessible(true);
        Person p3 = (Person) constructor3.newInstance("wsx",12);
        p3.eat();

        System.out.println("======获取公有方法=======");
        Method[] methods1 = p3zz.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        System.out.println("======获取所有方法=======");
        Method[] methods2 = p3zz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }

        System.out.println("======获取指定公有方法并调用=======");
        Method method1 = p3zz.getMethod("eat",null);
        method1.invoke(new Person("wsx",12),null);

        System.out.println("======获取指定私有方法并调用=======");
        Method method2 = p3zz.getDeclaredMethod("drink",null);
        method2.setAccessible(true);
        method2.invoke(new Person("wsx",12),null);

        System.out.println("======获取指定静态方法并调用=======");
        Method method3 = p3zz.getMethod("sleep",int.class);
        method3.invoke(null,100);

        System.out.println("======获取全部公有属性=======");
        Field[] fields = p3zz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("======获取全部属性=======");
        Field[] fields2 = p3zz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }

        System.out.println("======获取指定属性=======");
        Field field = p3zz.getDeclaredField("age");
        System.out.println(field);
        field.setAccessible(true);
        Person p4 = new Person("lll",16);
        field.set(p4,200);
        p4.eat();

    }
}
