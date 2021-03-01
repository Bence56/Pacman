import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public abstract class Monster extends Steppable{
	ArrayList<Irany> path=new ArrayList<Irany>();
	int stepcnt=0;
	public void CollideWithPacman() {
		if(Math.abs(this.x-Screen.pacman.getX())<30&&Math.abs(this.y-Screen.pacman.getY())<30) {
			killPacman();
			System.out.println("Gotta kill the biatch");
		}
		else if(this.x==Screen.pacman.getX()&&this.y==Screen.pacman.getY()) {
			System.out.println("Gotta kill the biatch");
			killPacman();
		}
	}
	public void mozog(Irany i) {
		if(i==Irany.Bal) {
			x--;
		}
		else if(i==Irany.Jobb){
			x++;
		}
		else if(i==Irany.Fel) {
			y--;
		}
		else if(i==Irany.Le) {
			y++;
		}
	}
	public void draw(Graphics g) {
		Image tmpimg=imgfel[0];
		if(elozoirany==Irany.Bal) {
			tmpimg=imgbal[kepcnt];
		}
		else if(elozoirany==Irany.Fel) {
			tmpimg=imgfel[kepcnt];
		}
		else if(elozoirany==Irany.Jobb) {
			tmpimg=imgjobb[kepcnt];
		}
		else if(elozoirany==Irany.Le) {
			tmpimg=imgle[kepcnt];
		}
		kepvaltoz++;
		if(kepvaltoz==6) {
		kepcnt+=1;
		kepcnt=kepcnt%kepszam;
		kepvaltoz=0;
		}
		g.drawImage(tmpimg, x, y, null);
		//CollideWithPacman();
	}
	public void killPacman() {
		
		Screen.killPacman();
	}
	public void step(Irany i) {
		if(x%30==0&&y%30==0) {
			ArrayList<Irany> irany=new ArrayList<Irany>();
			if(mehet(Irany.Fel,true))irany.add(Irany.Fel);
			if(mehet(Irany.Le,true))irany.add(Irany.Le);
			if(mehet(Irany.Jobb,true))irany.add(Irany.Jobb);
			if(mehet(Irany.Bal,true))irany.add(Irany.Bal);
			if(irany.size()>=3) {
			Random gep=new Random();
			int szam=gep.nextInt(irany.size());
			kovetkezoirany=irany.get(szam);
			}
			if(mehet(kovetkezoirany,true))
			mozog(kovetkezoirany);
			else {
				
				kovetkezoirany=kovetkezoirany.ellentetes();
			}
			irany.clear();
			elozoirany=kovetkezoirany;
			CollideWithPacman();
		}
		else {
			
			mozog(elozoirany);
			CollideWithPacman();
		}
	}
}
