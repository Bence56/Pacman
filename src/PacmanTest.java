import java.awt.Color;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

import java.awt.*;
public class PacmanTest {	
	@Test
	public void Pacmanbal() {
		Pacman pacman=new Pacman();
		for(int i=0;i<30;i++)
		pacman.mozog(Irany.Bal);
		Assert.assertEquals(25*30, pacman.getX());
		Assert.assertEquals(29*30, pacman.getY());

	}
	@Test
	public void Pacmanjobb(){
		Pacman pacman=new Pacman();
		for(int i=0;i<30;i++)
		pacman.mozog(Irany.Fel);
		Assert.assertEquals(26*30, pacman.getX());
		Assert.assertEquals(28*30, pacman.getY());
	}
	@Test
	public void vanmeggolyotest() throws IOException {
		Frame frame=new Frame();
		frame.screen=new Screen();
		frame.screen.map=new Map();
		Frame.Start();
		Assert.assertEquals(true, Frame.screen.map.vanmeggolyo());
	}
	@Test
	public void trynaendgame() throws IOException {
		Frame frame=new Frame();
		frame.screen=new Screen();
		frame.screen.map=new Map();
		frame.Start();
		Assert.assertEquals(false, frame.screen.jatekvege);
		frame.screen.killPacman();
		frame.screen.killPacman();
		frame.screen.killPacman();
		Assert.assertEquals(true, frame.screen.jatekvege);
	}
	@Test
	public void elettest() throws IOException {
		Frame frame=new Frame();
		frame.screen=new Screen();
		frame.screen.map=new Map();
		frame.Start();
		Assert.assertEquals(3, frame.info.elet);
		frame.screen.killPacman();
		Assert.assertEquals(2, frame.info.elet);
		frame.screen.killPacman();
		Assert.assertEquals(1, frame.info.elet);
		frame.screen.killPacman();
		Assert.assertEquals(0, frame.info.elet);
	}
	@Test
	public void point() throws IOException {
		Frame frame=new Frame();
		frame.screen=new Screen();
		frame.screen.map=new Map();
		frame.Start();
		for(int i=0;i<30;i++) {
			frame.screen.pacman.step(Irany.Fel);
			frame.screen.pontvan();
		}
		Assert.assertEquals(10, frame.info.pontok);
	}
	@Test
	public void Pacmanmegyem() throws IOException {
		Frame frame=new Frame();
		frame.screen=new Screen();
		frame.screen.map=new Map();
		frame.Start();
		Assert.assertEquals(false, Frame.screen.pacman.mehet(Irany.Bal, true));
		Assert.assertEquals(true, Frame.screen.pacman.mehet(Irany.Fel, true));
		Assert.assertEquals(true, Frame.screen.pacman.mehet(Irany.Le, true));		
		Assert.assertEquals(false, Frame.screen.pacman.mehet(Irany.Jobb, true));
	}
	@Test
	public void drawTest() throws IOException {
		Frame frame=new Frame();
		frame.screen=new Screen();
		frame.screen.map=new Map();
		frame.Start();
		frame.screen.repaint();
	}
	
}
