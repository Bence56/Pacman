import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LoadingScreen extends JPanel implements Runnable{
	 static Thread thread=new Thread();
	 Image img=new ImageIcon("res/Map/LoadingScreen.png").getImage();
	public LoadingScreen() {
		this.setSize(940, 930);
		this.setBackground(Color.black);
		JLabel picLabel = new JLabel(new ImageIcon(img));
		this.add(picLabel);
	}
	public void paintComponent(Graphics g) {		
		
		//g.drawRect(0, 0, 70, 70);
		//g.drawString("Press Enter to Start the game", 500, 565);
		g.drawImage(img, 0, 0, 940, 930, null);
	}
	@Override
	public void run() {
		repaint();
	}
}
