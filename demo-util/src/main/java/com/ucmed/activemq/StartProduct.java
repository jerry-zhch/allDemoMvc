package com.ucmed.activemq;

public class StartProduct {

    public static void main(String[] args){
        Producter producter = new Producter();
        producter.init();
        StartProduct startProduct = new StartProduct();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(startProduct.new ProductorMq(producter)).start();
        //Thread 2
//        new Thread(startProduct.new ProductorMq(producter)).start();
//        //Thread 3
//        new Thread(startProduct.new ProductorMq(producter)).start();
//        //Thread 4
//        new Thread(startProduct.new ProductorMq(producter)).start();
//        //Thread 5
//        new Thread(startProduct.new ProductorMq(producter)).start();
    }

    private class ProductorMq implements Runnable{
        Producter producter;
        private ProductorMq(Producter producter){
            this.producter = producter;
        }

        @Override
        public void run() {
//            while(true){
                try {
//                    producter.sendMessage("Jaycekon-MQ");
                    producter.sendMessage("wechatPush");
                    System.out.println("sendMessage Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }
}
