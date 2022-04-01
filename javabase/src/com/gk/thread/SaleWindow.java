package com.gk.thread;

/**
 * @author goodking
 * @data 2022-03-21 8:47
 */
public class SaleWindow implements Runnable {
    private int ticket = 10;


    @Override
    public void run() {
        int threadNum = Integer.parseInt(Thread.currentThread().getName().substring(7));
        String saleWindowName = "销售窗口" + threadNum;
        //开始卖票
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(saleWindowName + ": 卖出了" + ticket--+"号票!");
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SaleWindow sw = new SaleWindow();
        //
        new Thread(sw).start();
        new Thread(sw).start();
        new Thread(sw).start();
    }
}
