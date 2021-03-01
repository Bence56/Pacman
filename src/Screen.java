import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.awt.*;

import javax.swing.*;

public class Screen extends JPanel implements Runnable{
	
	public static Map map;
	private Thread thread=new Thread(this);
	public static Irany irany;
	private boolean isFirst=true;
	public static boolean jatekvege=false;
	public static Pacman pacman=new Pacman();
	public Blinky blinky=new Blinky();
	private Pinky pinky=new Pinky();
	private Inky inky=new Inky();
	private Clyde clyde =new Clyde();
	
	public Screen() throws IOException {		
		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension(840,930));
		this.setSize(840, 930);
	}
	public void define() throws IOException {		
		map=new Map();
		pacman=new Pacman();
		blinky=new Blinky();
		thread=new Thread(this);
		//info.thread.start();
	}	
	public void Start() {
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		if(!isFirst) {
		map.draw(g);
		pacman.draw(g);
		blinky.draw(g);
		pinky.draw(g);
		inky.draw(g);
		clyde.draw(g);
		}
	}
	private void step() {
		pacman.step(irany);
		blinky.step(irany);
		inky.step(irany);
		clyde.step(irany);
		pinky.step(irany);
		pontvan();
		
	}
	public boolean pontvan() {
		int x=pacman.getX();
		int y=pacman.getY();
		int i=(int)Math.ceil(x/30);
		int j=(int)Math.ceil(y/30);
		if(x%30==0 && y%30==0&&Screen.map.getId(j, i)==3) {
			Frame.info.pontotkapott();
			map.setId(j, i, 2);
			return true;
		}
		return false;
	}
	@Override
	public void run() {
		while(!jatekvege) {
			if(isFirst) {
				try {
					define();
					
					Thread.sleep(8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isFirst=false;
			}
			else {
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!map.vanmeggolyo()) {
					this.setisFirst(true);
					try {
						map.define();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				repaint();
				step();
			}
			
		}
	}
	public void setisFirst(boolean shit) {
		isFirst=shit;
	}
	public static boolean jatekvege() {
		return jatekvege;
	}
	public static void killPacman() {
		pacman.setX(26*30);
		pacman.setY(29*30);
		
		if(Frame.info.killANDisGameOver()) {
			jatekvege=true;
			Frame.screen.thread.stop();
			Frame.info.thread.stop();
			Frame.screen.setVisible(false);
			Frame.info.setVisible(false);
			Frame.end.setVisible(true);
			System.out.println("Game over");
		}
	}

}
