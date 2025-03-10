package er_lou_si;

import java.awt.Color;
import java.awt.Font;


public class button extends GameObject implements buttontext {
	int w;
	int h;
	String text="adsds";
	map map;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		map.g.setColor(Color.red);
		map.g.fillRect(x, y, w, h);
		map.g.setFont(new Font(text, w, h));
		if(map.mouse_lock==false&&input.inputmosue[0]==true) {
			if(x<input.x_m&&x+w>input.x_m&&
				y<input.y_m&&y+h>input.y_m) {
				try {
					use();
					map.g.clearRect(x, y, w, h);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	public button(int x,int y,int w,int h,String text,map map) {
		// TODO Auto-generated constructor stub
		isstart=false;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.text=text;
		this.map=map;
	}
	public void use() {
		
	}

}
