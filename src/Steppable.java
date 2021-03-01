import java.awt.Graphics;
import java.awt.Image;

import org.junit.Test;

public abstract class Steppable {
	int x;
	int y;
	Irany elozoirany;
	Irany kovetkezoirany;
	int kepvaltoz=0;
	int kepszam;
	int kepcnt=0;
	Image[] imgfel;
	Image[] imgle;
	Image[] imgbal;
	Image[] imgjobb;
	
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
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public abstract void step(Irany i);
	
	public boolean mehet(Irany irany,boolean osztvaharminc) {
		int i=(int)Math.ceil(x/30);
		int j=(int)Math.ceil(y/30);
		//System.out.println("x: "+i+"    y: "+j+"     id: "+Screen.map.getId(j, i));
		if(!osztvaharminc) {
		if(irany==Irany.Fel&&Screen.map.getId(j, i)!=1)
			return true;
		else if(irany==Irany.Le&&Screen.map.getId(j, i)!=1)
			return true;
		else if(irany==Irany.Bal&&Screen.map.getId(j, i)!=1)
			return true;
		else if(irany==Irany.Le&&Screen.map.getId(j, i)!=1)
			return true;
		else
			return false;
		}
		else {
			if(irany==Irany.Fel&&Screen.map.getId(j-1, i)==1)
				return false;
			else if(irany==Irany.Le&&Screen.map.getId(j+1, i)==1)
				return false;
			else if(irany==Irany.Bal&&Screen.map.getId(j, i-1)==1)
				return false;
			else if(irany==Irany.Jobb&&Screen.map.getId(j, i+1)==1)
				return false;
			
				return true;
		}
	}
}
