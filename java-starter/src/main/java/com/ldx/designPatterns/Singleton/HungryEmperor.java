package com.ldx.designPatterns.Singleton;

/**
 * @ClassName:HungryEmperor
 * @Description: TODO
 * @Author: lindaixun
 * @Date: 2021/2/20 16:53
 * @Version 1.0 设计模式单例，懒汉模式测试
 */
public class HungryEmperor {
    //私有化构造方法
    private HungryEmperor(){}{

    }

    //设置静态对象，让内存中只存在一个例子
    private static HungryEmperor instance=new HungryEmperor();

    //设置开放的方法，让外部可以使用
    public static  HungryEmperor getInstance(){
        return instance;
    }
}
