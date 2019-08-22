package com.chillax.controller;

public class Singleton  {
	
  private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
    	System.out.println(singleton+" 静态初始化");
        if (singleton == null) {
        	System.out.println(singleton+" 静态变量为null");
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    System.out.println(singleton+"创建静态变量");
                }
            }
        }
        return singleton;
    }
    public static void main(String[] args) {
    	System.out.println(singleton+"11");
    	getInstance();
    	System.out.println(singleton+" 22");
    	getInstance();
    	System.out.println(singleton+" 33");
    	
    	Singleton studen=singleton.getInstance();
    	Singleton studen2=singleton.getInstance();
    	
    	System.out.println(studen.equals(studen2));
    	System.out.println(studen == studen2);
	}
}
