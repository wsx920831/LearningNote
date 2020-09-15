package ObserverMode;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/14 0:58
 * @Version 1.0
 */

//抽象观察者
interface Observer {
    public void update(String message);

}

//具体观察者
class MyWeixin implements Observer{
    @Override
    public void update(String message) {
        System.out.println("我收到的通知：" + message);
    }
}

class MyQQ implements Observer{
    @Override
    public void update(String message) {
        System.out.println("ou收到的通知：" + message);
    }
}


