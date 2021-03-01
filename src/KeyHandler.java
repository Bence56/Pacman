import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_UP) {
			Screen.irany=Irany.Fel;
			//System.out.println("Felfele gomb");
		}
		else if(code==KeyEvent.VK_DOWN) {
			Screen.irany=Irany.Le;
			//System.out.println("Lefele gomb");
		}
		else if(code==KeyEvent.VK_LEFT) {
			Screen.irany=Irany.Bal;
			//System.out.println("Balra gomb");
		}
		else if(code==KeyEvent.VK_RIGHT) {
			Screen.irany=Irany.Jobb;
			//System.out.println("Jobbra gomb");
		}
		else if(code==KeyEvent.VK_ENTER&&!Frame.screen.jatekvege) {
			LoadingScreen.thread.stop();
			Frame.Start();
		}
		else if(code==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		else if(Frame.screen.jatekvege==true) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
