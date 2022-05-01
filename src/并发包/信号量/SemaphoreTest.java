package 并发包.信号量;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author GuoZeWei
 * @date 2022/5/1  16:41
 */
public class SemaphoreTest implements Runnable{
    //包含5个许可的信号量
    final Semaphore semp=new Semaphore(5);
    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+"运行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semp.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec= Executors.newFixedThreadPool(20);
        final SemaphoreTest demo=new SemaphoreTest();
        for (int i=0;i<20;i++){
            exec.submit(demo);
        }
    }
}
