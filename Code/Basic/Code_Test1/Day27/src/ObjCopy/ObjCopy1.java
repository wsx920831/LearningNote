package ObjCopy;

import javax.lang.model.SourceVersion;
import java.io.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/13 0:55
 * @Version 1.0
 */
class Address implements Serializable{
    String city;

    public Address(String city) {
        this.city = city;
    }
}
//拷贝须实现Cloneable接口
class Person implements Cloneable,Serializable{
    int age;
    String name;
    Address add;

    public Person(int age, String name,Address add) {
        this.age = age;
        this.name = name;
        this.add = add;
    }

    @Override
    public String toString() {
        return "{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", city='" + add.city + '\'' +
                '}';
    }

    //拷贝须重写clone()方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class ObjCopy1 {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //浅拷贝
        Person p1 = new Person(12,"www",new Address("Taian"));
        Person p2 = (Person) p1.clone();
        p2.name = "lll";

        //浅拷贝不能拷贝对象所属类中维护的其他对象
        p2.add.city = "Beijing";
        System.out.println("p1 = " + p1.toString());
        System.out.println("p2 = " + p2.toString());

        //深拷贝：利用对象的持久化
        //输出
        FileOutputStream fileOutputStream = new FileOutputStream("Obj.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(p1);
        objectOutputStream.close();

        //输入
        FileInputStream fileInputStream = new FileInputStream("Obj.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person p3 = (Person) objectInputStream.readObject();
        objectInputStream.close();
        p3.add.city = "tianjin";
        System.out.println("p1 = " + p1);
        System.out.println("p3 = " + p3);

    }
}
