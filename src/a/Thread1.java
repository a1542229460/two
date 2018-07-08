package a;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.CharBuffer;
import java.text.DecimalFormat;

import javax.net.ssl.HttpsURLConnection;

public class Thread1 {

	public static void main(String[] args) throws Exception {
		Thread my=new Thread(new MyThread(),"demo线程");
		my.start();
		
			for(int i=0;i<6;i++) {
				System.out.println(Thread.currentThread().getName()+"="+i);
				if(i==3) {
					try {
						my.join();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread.sleep(500);
				}
			
		}
		
		
		//new Thread(my,"窗口1").start();
		//new Thread(my,"窗口2").start();
		//new Thread(my,"窗口3").start();
		//new Thread(my,"窗口4").start();
	}
}
class MyThread implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			
		
			for(int i=0;i<6;i++) {
				System.out.println(Thread.currentThread().getName()+"="+i);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}
	
}