package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CGB on 2019/4/13.
 */
public class TestLock {
    private Lock lock=new ReentrantLock();

    public void tryLockTest(Thread thread){
        if (lock.tryLock()){
            try {
                System.out.println("线程"+thread.getName()+"获取当前锁");
                thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("线程"+thread.getName()+"执行完毕释放锁");
                lock.unlock();
            }
        }else {
            System.out.println("我是线程"+thread.currentThread().getName()+",有人占着茅坑在拉屎我无法获取当前锁");
        }
    }
    public static void main(String[] args){
        TestLock testLock = new TestLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testLock.tryLockTest(Thread.currentThread());
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testLock.tryLockTest(Thread.currentThread());
            }
        }, "thread2");
        thread1.start();
        thread2.start();
    }
}
