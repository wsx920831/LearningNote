package ObserverMode;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/14 1:01
 * @Version 1.0
 */

//抽象主题
interface Subject {
    //订阅
    public void register(Observer observer);

    //取消订阅
    public void unregister(Observer observer);

    //通知
    public void notify(String message);
}

//具体主题：实现一系列逻辑操作，维护与观察者的关系
class YLi implements Subject{

    //维护与观察者的关系
    private ArrayList<Observer> User = new ArrayList<Observer>();

    @Override
    public void register(Observer observer) {
        User.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        User.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : User) {
            observer.update(message);
        }
    }
}

