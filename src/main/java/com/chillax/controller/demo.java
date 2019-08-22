package com.chillax.controller;

public class demo {
public static void main(String[] args) {
	//四舍五入 保留小数
	double x = 4.185638438;
	double y =  ((int)(x*10 + 0.5))/10.0; // y = 4.18
	System.out.println(x+"  "+y);
	/**/
/*	Timer timer=new Timer();//实例化Timer类
	timer.schedule(new TimerTask(){
		public void run(){
			System.out.println("退出");
			this.cancel();
		}
	},500);//五百毫秒
*/	/**/
	try {
		System.err.println("外层try");
		try {
			System.err.println("内层try");
			System.err.println(1/0);
			return;
		} catch (Exception e) {
			System.err.println("内层1catch"); 
		}finally {
			System.err.println("内层1finally");
		}
	} catch (Exception e) {
		System.err.println("内层2catch"); 
		try {
			System.err.println("内层2try");
			
		} catch (Exception e1) {
			System.err.println("内层2catch"); 
		}finally {
			System.err.println("外层finally");
		}
	}finally {
		System.err.println("外层finally");
	}
}
}
