import java.awt.Component;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class Frame extends JFrame{
		static Screen screen;
		public static Infopanel info=new Infopanel();
		private static LoadingScreen ls=new LoadingScreen();
		public static EndScreen end=new EndScreen();
		public Frame() throws IOException {
			screen=new Screen();
			info=new Infopanel();
			end=new EndScreen();
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			this.setSize(840,1030);
			this.setResizable(false);
			this.setLayout(new FlowLayout());
			this.addKeyListener(new KeyHandler());
			this.add(ls);
			this.add(screen);
			this.add(info);
			this.add(end);
			screen.setVisible(false);
			info.setVisible(false);
			end.setVisible(false);
			ls.run();
			this.setVisible(true);			
		}
		public static void Start() {		
			ls.setVisible(false);
			screen.setVisible(true);
			info.setVisible(true);
			screen.Start();
			info.Start();
		}
}
