package er_lou_si;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject {
	public int x;
	public int y;
	public GameObject[] child;
	public GameObject fater;
	public boolean isstart;
	public abstract void run();
	public abstract void start();
	public GameObject() {
		fater=this;
		start();
	}
}
