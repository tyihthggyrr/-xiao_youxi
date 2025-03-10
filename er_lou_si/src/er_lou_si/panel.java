package er_lou_si;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class panel extends GameObject {
 	public block[][] b_list;
 	public double time;
 	public structure structure_;
 	public c_block[][] structure;
 	public boolean is_structure_null;
 	public double down_speed;
 	public boolean key_A;
 	public boolean key_D;
 	public boolean key_S;
 	public map map;
	public panel(int x,int y,map map) {
		this.x=x;
		this.y=y;
		this.map=map;
	}
	@Override
	public void run() {
		key_A=input.inputkey[65];
		key_S=input.inputkey[83];
		key_D=input.inputkey[68];
		if(is_structure_null==true) {
			down_speed=0;
			is_structure_null=false;
			structure_.shape();
		}
		if(time+down_speed<200) {
			time=time+run.daltime;
		}else {
			time=0;
			for(int i=0;i<20;i++) {
				for(int j=0;j<10;j++) {
					b_list[j][i].is_down=true;
				}
			}
		}
		if(key_A==true&&map.key_lock==false) {
//			System.out.print(false);
			input.inputkey[65]=false;
			map.key_lock=true;
			int i;
			if(left(structure)==0) {
				for(i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(structure[i][j]!=null) {
							structure[i][j].block.left();
						}
					}
				}
			}
		}
		if(key_D==true&&map.key_lock==false) {
			input.inputkey[68]=false;
			map.key_lock=true;
			int i;
			if(right(structure)==0) {
				for(i=2;i>=0;i--) {
					for(int j=0;j<3;j++) {
						if(structure[i][j]!=null) {
							structure[i][j].block.right();
						}
					}
				}
			}
		}
		if(key_S==true&&map.key_lock==false) {
			down_speed=150.0;
			map.key_lock=true;
		}
		if(map.mouse_lock==false&&input.inputmosue[0]==true) {
			input.inputmosue[0]=false;
			int x=(input.x_m-input.x_m%20)/20-2;
			int y=(input.y_m-input.y_m%20)/20-2;
			map.mouse_lock=true;
	//		System.out.print("take("+x+","+y+","+(x-4)+","+(y-2)+");"+"\n");
			ArrayList<block> blocks=new ArrayList<block>();
			if(x<0||x>=10) {}
			else if(y<5||y>20) {}
			else if(b_list[x][y].same_block(blocks)>=2) {
				map.sorce=map.sorce+blocks.size();
				for(int i=0;i<blocks.size();i++) {
					c_block c_block=blocks.get(i).c_block;
					if(c_block.x!=-1&&c_block.y!=-1)structure[c_block.x][c_block.y]=null;
					blocks.get(i).c_block=null;
				}
			}
			
		}
	//	System.out.print(b_list[2][2].color);
		for(int i=19;i>=0;i--) {
			for(int j=0;j<10;j++) {
				b_list[j][i].run();
			//	System.out.print("("+i+","+j+")"+b_list[j][i].is_down+" ");
				b_list[j][i].draw(map.g);//从上到下
			}
			//System.out.println();
		}
		
	}
	@Override
	public void start() {
		isstart=false;
		down_speed=0.0;
		is_structure_null=true;
		time=0;
	 	b_list=new block[10][20];
	 	structure_=new structure(this);
	 	structure=structure_.c_block;
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<20;j++) {
				b_list[i][j]=new block(i*20, j*20, null,this);
				b_list[i][j].fater=this;
				if(j<5) {
					b_list[i][j].can_displayed=false;
				}
			}
		}
	}
	public int left(c_block[][] struction) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(struction[j][i]==null)continue;
				block block=struction[j][i].block;
				if(block.x/20-1>=0
						&&b_list[block.x/20-1][block.y/20].c_block==null) {
					break;
				}else {
					return 1;
				}
			}
		}
		return 0;
	}
	public int right(c_block[][] struction) {
		for(int i=0;i<3;i++) {
			for(int j=2;j>=0;j--) {
				if(struction[j][i]==null)continue;
				block block=struction[j][i].block;
				if(block.x/20+1<10
						&&b_list[block.x/20+1][block.y/20].c_block==null) {
					break;
				}else {
					return 1;
				}
			}
		}
		return 0;
	}
}
