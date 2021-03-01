import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class EndScreen extends JPanel implements Runnable{
	static Thread thread=new Thread();
	 Image img=new ImageIcon("res/Map/Gameover.jpg").getImage();
	public EndScreen() {
		this.setSize(940, 930);
		JLabel piclabel=new JLabel(new ImageIcon(img));
		this.add(piclabel);
	}
	public void paintComponent(Graphics g) {		
		g.drawImage(img, 0, 0, 940, 930, null);
	}
	@Override
	public void run() {
		repaint();
	}
	
}
