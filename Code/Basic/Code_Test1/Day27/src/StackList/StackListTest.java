package StackList;

import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/13 1:51
 * @Version 1.0
 */
//栈模拟

class StackList{
    //内部维护一个数组
    private Object[] elements;
    int index = 0;
    private int initialCapacity = 10;

    public StackList() {
        this.elements = new Object[initialCapacity];
    }

    //压栈
    public void push(Object e){
        ensureCapacity();
        elements[index++] = e;
    }

    //确认数组长度是否满足需求
    private void ensureCapacity(){
        if (index == elements.length){
            elements = Arrays.copyOf(elements,elements.length*2);
        }
    }
    //弹栈
    public Object pop(){
        int temp = --index;
        Object e = elements[temp];
        elements[temp] = null; //取出后置空，等待垃圾回收
        return e;
    }
    //统计栈长度
    public int size(){
        return index;
    }
}
public class StackListTest {
    public static void main(String[] args) {
        StackList stackList = new StackList();
        stackList.push("aa");
        stackList.push("bb");
        stackList.push("cc");
        stackList.push("dd");
        System.out.println("Size: " + stackList.size());
        int size = stackList.size();
        for (int i = 0; i < size; i++) {
            System.out.println("弹出元素：" + stackList.pop());
        }


    }
}
