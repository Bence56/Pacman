import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Clyde extends Monster{
	public Clyde() {
		kepszam=3;
		imgfel=new Image[3];
		imgle=new Image[3];
		imgbal=new Image[3];
		imgjobb=new Image[3];
		imgfel[0]=new ImageIcon("res/Clyde/Fel1.png").getImage();
		imgfel[1]=new ImageIcon("res/Clyde/Fel2.png").getImage();
		imgfel[2]=new ImageIcon("res/Clyde/Fel1.png").getImage();
		
		imgle[0]=new ImageIcon("res/Clyde/Le1.png").getImage();
		imgle[1]=new ImageIcon("res/Clyde/Le2.png").getImage();
		imgle[2]=new ImageIcon("res/Clyde/Le1.png").getImage();
		
		imgbal[0]=new ImageIcon("res/Clyde/Bal1.png").getImage();
		imgbal[1]=new ImageIcon("res/Clyde/Bal2.png").getImage();
		imgbal[2]=new ImageIcon("res/Clyde/Bal1.png").getImage();
		
		imgjobb[0]=new ImageIcon("res/Clyde/Jobb1.png").getImage();
		imgjobb[1]=new ImageIcon("res/Clyde/Jobb2.png").getImage();
		imgjobb[2]=new ImageIcon("res/Clyde/Jobb1.png").getImage();
		
		x=30;
		y=30;
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
//			elozoirany=irany.get(szam);
//			}
//			if(mehet(elozoirany,true))
//			mozog(elozoirany);
//			else {
//				
//				kovetkezoirany=kovetkezoirany.ellentetes();
//			}
//			irany.clear();
//		}
//		else {
//			mozog(elozoirany);
//		}
//		
//	}
	
}
