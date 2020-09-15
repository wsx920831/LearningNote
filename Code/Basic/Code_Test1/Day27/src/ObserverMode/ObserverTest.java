package ObserverMode;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/14 1:14
 * @Version 1.0
 */
public class ObserverTest {
    public static void main(String[] args) {
        YLi User = new YLi();
        MyWeixin aa = new MyWeixin();
        User.register(aa);
        User.register(new MyQQ());
        User.unregister(aa);
        User.notify("hahaha");
    }
}
