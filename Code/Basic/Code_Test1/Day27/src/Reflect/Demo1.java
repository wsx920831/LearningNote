package Reflect;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.FieldAccessor_Double;
import sun.swing.plaf.windows.ClassicSortArrowIcon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/15 1:38
 * @Version 1.0
 */

//根据配置文件创建对应的类

public class Demo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Config.txt"));
        String classname = bufferedReader.readLine();
        //获取类
        Class p1zz = Class.forName(classname);

        //获取无参构造函数
        Constructor constructor = p1zz.getDeclaredConstructor(null);
        constructor.setAccessible(true);

        //创建类对象
        Object o = constructor.newInstance(null);

        //获取属性并赋值
        String content = null;
        while ((content = bufferedReader.readLine()) != null){
            String fieldname = content.split("=")[0];
            //获取field
            Field field = p1zz.getDeclaredField(fieldname);
            field.setAccessible(true);
            if (field.getType() == int.class){
                field.set(o,Integer.parseInt(content.split("=")[1]));
            }else{
                field.set(o,content.split("=")[1]);
            }
        }
//        bufferedReader.close();
//        Person p = (Person) o;
//        p.eat();








    }
}
