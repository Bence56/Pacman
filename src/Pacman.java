import java.awt.*;
import javax.swing.*;

public class Pacman extends Steppable{

	public Pacman() {
		kepszam=4;
		imgfel=new Image[4];
		imgle=new Image[4];
		imgbal=new Image[4];
		imgjobb=new Image[4];
		imgfel[0]=new ImageIcon("res/Pacman/Pacmanclosed.png").getImage();
		imgfel[1]=new ImageIcon("res/Pacman/Pacmanfel1.png").getImage();
		imgfel[2]=new ImageIcon("res/Pacman/Pacmanfel2.png").getImage();
		imgfel[3]=new ImageIcon("res/Pacman/Pacmanfel1.png").getImage();
		
		imgle[0]=new ImageIcon("res/Pacman/Pacmanclosed.png").getImage();
		imgle[1]=new ImageIcon("res/Pacman/Pacmanle1.png").getImage();
		imgle[2]=new ImageIcon("res/Pacman/Pacmanle2.png").getImage();
		imgle[3]=new ImageIcon("res/Pacman/Pacmanle1.png").getImage();
		
		imgbal[0]=new ImageIcon("res/Pacman/Pacmanclosed.png").getImage();
		imgbal[1]=new ImageIcon("res/Pacman/Pacmanbal1.png").getImage();
		imgbal[2]=new ImageIcon("res/Pacman/Pacmanbal2.png").getImage();
		imgbal[3]=new ImageIcon("res/Pacman/Pacmanbal1.png").getImage();
		
		imgjobb[0]=new ImageIcon("res/Pacman/Pacmanclosed.png").getImage();
		imgjobb[1]=new ImageIcon("res/Pacman/Pacmanjobb1.png").getImage();
		imgjobb[2]=new ImageIcon("res/Pacman/Pacmanjobb2.png").getImage();
		imgjobb[3]=new ImageIcon("res/Pacman/Pacmanjobb1.png").getImage();
		
		x=26*30;
		y=29*30;
		elozoirany=Irany.Bal;
		kovetkezoirany=Irany.Bal;
	}
	public void step(Irany i) {
		if(x%30==0 && y%30==0) {
			if(i==Irany.Bal) {
				if(mehet(Irany.Bal,true)) {
					kovetkezoirany=Irany.Bal;
					mozog(Irany.Bal);	
				}
				else if(mehet(elozoirany,true)){
					mozog(elozoirany);
				}
			}
			else if(i==Irany.Fel) {
				if(mehet(Irany.Fel,true)) {
					kovetkezoirany=Irany.Fel;
					mozog(Irany.Fel);
				}
				else if(mehet(elozoirany,true)){
					mozog(elozoirany);
				}
			}
			else if(i==Irany.Jobb) {
				if(mehet(Irany.Jobb,true)) {
					kovetkezoirany=Irany.Jobb;
					mozog(Irany.Jobb);	
				}
				else if(mehet(elozoirany,true)){
					mozog(elozoirany);
				}
			}
			else if(i==Irany.Le) {
				if(mehet(Irany.Le,true)) {
					kovetkezoirany=Irany.Le;
					mozog(Irany.Le);
				}
				else if(mehet(elozoirany,true)){
					mozog(elozoirany);
				}
			}
			elozoirany=kovetkezoirany;
		}
		else {
			if(elozoirany==Irany.Bal) {
					mozog(Irany.Bal);
			}
			else if(elozoirany==Irany.Fel) {
					mozog(Irany.Fel);
			}
			else if(elozoirany==Irany.Jobb) {
					mozog(Irany.Jobb);

			}
			else if(elozoirany==Irany.Le) {
					mozog(Irany.Le);
			}
		}
	}
	
}
