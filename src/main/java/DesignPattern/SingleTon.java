package DesignPattern;
/*
方法和instance都是静态的
instance用volatile修饰（防止指令重拍）

 */
public class SingleTon {
    private volatile static SingleTon instance;
    public static SingleTon getInstance(){
        if(instance==null){
            //给类对象加锁
            synchronized (SingleTon.class){
                if(instance==null){
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
