package er_lou_si;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
public class run extends JFrame {
	public static run run=new run();
	public static double time;
	public static double daltime;
	public static void main(String[] args) {
		run.setVisible(true);
		run.setTitle("俄罗斯");
		run.setBounds(600, 250, 300, 450);
		run.setDefaultCloseOperation(EXIT_ON_CLOSE);
		while(true) {
			time=0;
			BufferedImage b=new BufferedImage(300, 450, BufferedImage.TYPE_3BYTE_BGR);
			/*	for(int i=0;i<300;i++) {
					for(int j=0;j<450;j++) {
						b.setRGB(i, j, Color.white.getRGB());
					}
				}*/
				map map1=new map();
				map1.g=run.getGraphics();
				input input=new input(map1);
				input.start();
				map1.start();
				while(map.strat==true) { 
					long startTime = System.nanoTime();
					map1.scan();
					long endTime = System.nanoTime();
					daltime = (endTime - startTime) / 1000000L ;
					int i524=(int)(3-daltime);
					if(daltime>=3) {
						i524=0;
					}
					try {
					Thread.sleep(i524);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}
				map.strat=true;
				run.getGraphics().clearRect(0,0, 300, 450);
				try {
					FileWriter file=new FileWriter("src/ty.txt");
					int a=map1.sorce>map1.best_sorce?map1.sorce:map1.best_sorce;
					file.write(a+" "+map1.sorce);
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
