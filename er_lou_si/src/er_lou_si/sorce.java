package er_lou_si;

import java.awt.Color;

public class sorce extends GameObject {
	String title="";
	map map;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		title=""+map.sorce;
		int title_length=title.length();
		for(int i=0;i<6-title_length;i++) {
			title='0'+title;
		}
		d1(title);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	public sorce(int x,int y,map map) {
		this.x=x;
		this.y=y;
		isstart=false;
		this.map=map;
	}
	public void d(String a,int index) {
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='1') {
				map.g.setColor(Color.red);
			}else {
				map.g.setColor(Color.LIGHT_GRAY);
			}
			switch (i) {
			case 0:map.g.fillRect(x+index*25, y, 5, 15);break;
			case 1:map.g.fillRect(x+index*25, y+20, 5, 15);break;
			case 2:map.g.fillRect(x+index*25+16, y, 5, 15);break;
			case 3:map.g.fillRect(x+index*25+16, y+20,5,15);break;
			case 4:map.g.fillRect(x+index*25+5, y-6,12,5);break;
			case 5:map.g.fillRect(x+index*25+5, y+15, 12, 5);break;
			case 6:map.g.fillRect(x+index*25+5, y+35, 12, 5);break;
				}
		}
	}
	public void d1(String a) {
		for(int i=0;i<a.length();i++) {
			switch(a.charAt(i)-'0') {
				case 0:d("1111101",i);break;
				case 1:d("1100000",i);break;
				case 2:d("0110111",i);break;
				case 3:d("0011111",i);break;
				case 4:d("1011010",i);break;
				case 5:d("1001111",i);break;
				case 6:d("1101111",i);break;
				case 7:d("0011100",i);break;
				case 8:d("1111111",i);break;
				case 9:d("1011111",i);break;
			}
		}
	}
}

