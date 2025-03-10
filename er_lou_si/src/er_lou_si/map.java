package er_lou_si;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class map {
	public ArrayList<GameObject> list=new ArrayList<GameObject>();
	public Graphics g;
	public  boolean mouse_lock;
	public boolean key_lock;
	private double mtime;
	private double ktime;
	public int sorce;
	public static boolean strat=true;
	public int best_sorce=0;
	public int next_sorce=0;
	public void start() {
		InputStream file = null;
		String text2="";
		while(file==null) {
			try {
				text2="";
				File f=new File("src/ty.txt");
		//		System.out.print(f.getAbsolutePath());
				if(f.exists()==false) {
					FileWriter fw=new FileWriter(f);
					fw.write(0+" "+0);
					fw.close();
				}
				file= new FileInputStream(f);
				int d=file.read();
				while(d!=-1) {
					text2=text2+(char)d;
					d=file.read();
				}
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] da=text2.split(" ");
		best_sorce=Integer.parseInt(da[0]);
		next_sorce=Integer.parseInt(da[1]);
		mtime=0;
		ktime=0;
		mouse_lock=false;
		key_lock=false;
		g=run.run.getGraphics();
		panel panel=new panel(40,40,this);
		list.add(panel);
		sorce=0;
		sorce sorce_=new sorce(75,50,this);
		list.add(sorce_);
		text t1=new text(110,300) {
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				font=new Font("宋体", Font.BOLD, 20);
			}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				g.setFont(font);
				g.setColor(Color.black);
				g.drawString("最高分:"+best_sorce, x, y);
			}
		};
		text t2=new text(100,350) {
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				font=new Font("宋体", Font.BOLD, 20);
			}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				g.setFont(font);
				g.setColor(Color.black);
				g.drawString("上次得分:"+next_sorce, x, y);
			}
		};
		button button=new button(60,50,200,200,"",this) {
			public void use() {
				map.g.clearRect(0, 0, 300, 450);
				sorce_.isstart=true;
				panel.isstart=true;
				this.isstart=false;
				t1.isstart=false;
				t2.isstart=false;
			}
		};
		button.isstart=true;
		t1.isstart=true;
		t2.isstart=true;
		list.add(button);
		list.add(t1);
		list.add(t2);
	}
	public void scan() {
		for(int i=0;i<list.size();i++) {
			GameObject gameObject=list.get(i);
			if(gameObject.isstart==true) {
				gameObject.run();
			}
		}
		if(mtime<100) {
			mtime=mtime+run.daltime;
		}else {
			mtime=0;
			mouse_lock=false;
		}
		if(ktime<100) {
			ktime=ktime+run.daltime;
		}else {
			ktime=0;
			key_lock=false;
		}
		for(int i=0;i<input.inputkey.length;i++) {
			input.inputkey[i]=false;
		}
		for(int i=0;i<input.inputmosue.length;i++) {
			input.inputmosue[i]=false;
		}
	}
}


