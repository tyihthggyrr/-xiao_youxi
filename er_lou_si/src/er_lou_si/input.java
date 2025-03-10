package er_lou_si;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class input {
	static boolean[] inputkey=new boolean[255];
	static boolean[] inputmosue=new boolean[3];
	static int x_m;
	static int y_m;
	map map;
	public input(map map) {
		this.map=map;
		inputkey=new boolean[255];
		inputmosue=new boolean[3];
	}
	public void start() {
		for(int i=0;i<255;i++) {
			inputkey[i]=false;
		}
		for(int i=0;i<3;i++) {
			inputmosue[i]=false;
		}
		x_m=-1;
		y_m=-1;
		run.run.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				inputkey[e.getKeyCode()]=false;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(map.key_lock==false) {
					inputkey[e.getKeyCode()]=true;
			//		System.out.print(e.getKeyCode());
				}
			}
		});
		run.run.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(map.mouse_lock==false) {
					inputmosue[e.getButton()-1]=true;
					x_m=e.getPoint().x;
					y_m=e.getPoint().y;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}
}
