package er_lou_si;

import java.util.Random;

public class structure {
	c_block[][] c_block=new c_block[3][3];
	public static Random random=new Random();
	public panel panel;
	public structure(panel panel) {
		this.panel=panel;
	}
	public void shape() {
		int d=random.nextInt(6);
		switch(d) {
			case 0: shape1();;break;
			case 1: shape2();;break;
			case 2: shape3();;break;
			case 3: shape4();;break;
			case 4: shape5();;break;
			case 5: shape6();;break;
		}
	}
	
	private void take(int bx,int by,int sx,int sy) {
		panel.b_list[bx][by].c_block=new c_block(sx,sy);
		panel.structure[sx][sy]=panel.b_list[bx][by].c_block;
	}
	
	public void shape1() {
		take(5, 2, 1, 0);
		take(5, 3, 1, 1);
		take(5, 4, 1, 2);
	}
	public void shape2() {
		take(5,3,1,1);
		take(5,4,1,2);
		take(4,4,0,2);
		take(6,4,2,2);
	}
	public void shape3() {
		take(4,3,0,1);
		take(5,3,1,1);
		take(6,3,2,1);
	}
	public void shape4() {
		take(4,4,0,2);
		take(4,3,0,1);
		take(5,4,1,2);
		take(6,4,2,2);
	}
	public void shape5() {
		take(4,3,0,1);
		take(5,3,1,1);
		take(5,4,1,2);
		take(4,4,0,2);
	}
	public void shape6() {
		take(4,2,0,0);
		take(5,2,1,0);
		take(6,2,2,0);
		take(6,3,2,1);
		take(6,4,2,2);
		take(5,4,1,2);
		take(4,4,0,2);
		take(4,3,0,1);
	}
}
