import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;
public class Blinky extends Monster{
	public Blinky() {
		kepszam=3;
		imgfel=new Image[3];
		imgle=new Image[3];
		imgbal=new Image[3];
		imgjobb=new Image[3];
		imgfel[0]=new ImageIcon("res/Blinky/Fel1.png").getImage();
		imgfel[1]=new ImageIcon("res/Blinky/Fel2.png").getImage();
		imgfel[2]=new ImageIcon("res/Blinky/Fel1.png").getImage();
		
		imgle[0]=new ImageIcon("res/Blinky/Le1.png").getImage();
		imgle[1]=new ImageIcon("res/Blinky/Le2.png").getImage();
		imgle[2]=new ImageIcon("res/Blinky/Le1.png").getImage();
		
		imgbal[0]=new ImageIcon("res/Blinky/Bal1.png").getImage();
		imgbal[1]=new ImageIcon("res/Blinky/Bal2.png").getImage();
		imgbal[2]=new ImageIcon("res/Blinky/Bal1.png").getImage();
		
		imgjobb[0]=new ImageIcon("res/Blinky/Jobb1.png").getImage();
		imgjobb[1]=new ImageIcon("res/Blinky/Jobb2.png").getImage();
		imgjobb[2]=new ImageIcon("res/Blinky/Jobb1.png").getImage();
		
		x=21*30;
		y=16*30;
		elozoirany=Irany.Le;
		kovetkezoirany=Irany.Fel;
	}
	//@Override
//	public void step(Irany i) {
//		if(x%30==0&&y%30==0) {
//			ArrayList<Irany> irany=new ArrayList<Irany>();
//			if(mehet(Irany.Fel,true))irany.add(Irany.Fel);
//			if(mehet(Irany.Le,true))irany.add(Irany.Le);
//			if(mehet(Irany.Jobb,true))irany.add(Irany.Jobb);
//			if(mehet(Irany.Bal,true))irany.add(Irany.Bal);
//			if(irany.size()>=3) {
//			Random gep=new Random();
//			int szam=gep.nextInt(irany.size());
//			kovetkezoirany=irany.get(szam);
//			}
//			if(mehet(kovetkezoirany,true))
//			mozog(kovetkezoirany);
//			else {
//				
//				kovetkezoirany=kovetkezoirany.ellentetes();
//			}
//			irany.clear();
//			elozoirany=kovetkezoirany;
//		}
//		else {
//			
//			mozog(elozoirany);
//		}
//	}
}
