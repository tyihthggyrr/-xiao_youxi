package er_lou_si;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class block extends GameObject {
	panel panel;
	block[][] b_list;
	public boolean is_down;
	public c_block c_block;
	public boolean can_displayed;
	public void run() {
		int down_num = -1;
		if(c_block!=null) {
			c_block.block=this;
		}
		if(is_down==true) {
			is_down=false;
			down_num=down();
		}
		if(down_num==4&&y/20<5) {
			map.strat=false;
		}
		if(down_num==4&&can_displayed) {
			move();
		}
	}
	public block(int x,int y,Color color,panel panel) {
		// TODO Auto-generated constructor stub
		this.x=x;//i*20
		this.y=y;
		this.panel=panel;
		b_list=panel.b_list;
	}
	public void draw(Graphics g) {
		if(can_displayed) {
			if(c_block==null) {
				g.setColor(Color.LIGHT_GRAY);
			}else {
				g.setColor(c_block.color);
			}
			g.fillRect(x+fater.x, y+fater.y, 19, 19);
		}
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		is_down=true;
		c_block=null;
		can_displayed=true;
	}
	public int left() {
		if(c_block!=null
				&&x/20-1>=0
				&&b_list[x/20-1][y/20].c_block==null
					) {
				b_list[x/20-1][y/20].c_block=c_block;
				b_list[x/20][y/20].c_block=null;
				return 1;
			}
		return 0;
	}
	public int right() {
		if(c_block!=null
				&&x/20+1<10
				&&b_list[x/20+1][y/20].c_block==null
					) {
				b_list[x/20+1][y/20].c_block=c_block;
				b_list[x/20][y/20].c_block=null;
				return 1;
			}
		return 0;
	}
	public int down() {
		if(c_block==null)return 2;//空格子
		if(y/20>=19) {
			if(c_block.x!=-1&&
					c_block.y!=-1) {
				panel.structure[c_block.x][c_block.y]=null;
				c_block.x=-1;
				c_block.y=-1;
				is_structure_null();
			}
			return 3;//最后一行 
		}
		if(b_list[x/20][y/20+1].c_block!=null) {
			if(c_block.x!=-1&&
					c_block.y!=-1) {
				panel.structure[c_block.x][c_block.y]=null;
				c_block.x=-1;
				c_block.y=-1;
				is_structure_null();
			}
			return 4;//下方有方块
		}
		b_list[x/20][y/20+1].c_block=c_block;
		b_list[x/20][y/20].c_block=null;
		return 0;//成功执行
	}
	private void is_structure_null() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(panel.structure[i][j]!=null) {
					return;
				}
			}
		}
		panel.is_structure_null=true;
	}
	public int same_block(ArrayList<block> blocks) {
		int[] result=new int[1];
		if(c_block!=null)result[0]=1;
		else return 0;
		blocks.add(this);
		tection(1,blocks, result, c_block.color);
		return result[0];
	}
	public void tection(int n,ArrayList<block> blocks,int[] a,Color color) {
		if(n==30)return ;
		yes_color(b_list,n, blocks, a, color, x/20, y/20+1);
		yes_color(b_list,n, blocks, a, color, x/20+1, y/20);
		yes_color(b_list,n, blocks, a, color, x/20, y/20-1);
		yes_color(b_list,n, blocks, a, color, x/20-1, y/20);
	}
	public static void yes_color(block[][] b_list,int n,ArrayList<block> blocks,int[] a,Color color,int x,int y) {
		if(x<0||x>=10)return;
		if(y<0||y>=20)return;
		if(b_list[x][y].c_block==null)return;
		if(b_list[x][y].c_block.color!=color)return;
		for(int i = 0;i<blocks.size();i++) {
			if(b_list[x][y]==blocks.get(i)) return;
		}
		
		a[0]++;
		blocks.add(b_list[x][y]);
		b_list[x][y].tection(n+1,blocks, a, color);
	}
	public int move() {
		if(x/20+1<10) {
			if(b_list[x/20+1][y/20+1].c_block==null) {
				b_list[x/20+1][y/20+1].c_block=c_block;
				b_list[x/20][y/20].c_block=null;
				return 0;//成功执行,
			}
		}
		if(x/20-1>=0){
			if(b_list[x/20-1][y/20+1].c_block==null){
				b_list[x/20-1][y/20+1].c_block=c_block;
				b_list[x/20][y/20].c_block=null;
				return 0;//成功执行,
			}
		}
		return 1;
	}
}
