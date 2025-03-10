package er_lou_si;

import java.awt.Color;
import java.util.Random;

public class c_block {
	int x;
	int y;//structure的值
	Color color;
	block block;
	public static Random random=new Random();
	public c_block(int x,int y) {
		int randomnum=random.nextInt(4);
		switch(randomnum) {
			case 0: color=Color.green;break;
			case 1: color=Color.yellow;break;
			case 2: color=Color.gray;break;
			case 3: color=Color.blue;break;
		}
		block=null;
		this.x=x;
		this.y=y;
	}
	public c_block() {
		x=-1;
		y=-1;
		color=Color.green;
	}
}
