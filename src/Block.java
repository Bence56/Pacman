import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;
public class Block extends Rectangle{
	private int id;
	private Image img;
	ArrayList<Irany>namegyem=new ArrayList<Irany>();
	ArrayList<Integer>szomszedok=new ArrayList<Integer>();
	private int num;
	public Block(int x,int y,int widht,int height,int id,Image img) {
		this.id = id;
		img=img;
		setBounds(x,y,widht,height);
	}
	public void setimg(int id) {
		if(id==1) {
			img=new ImageIcon("res/Map/Fal.png").getImage();
		}
		else if(id==2) {
			img=new ImageIcon("res/Map/Mezo.png").getImage();
		}
		else if(id==3) {
			img=new ImageIcon("res/Map/MezoArannyal.png").getImage();
		}
	}
	public void setid(int ids) {
		id=ids;
		setimg(id);
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	public int getid() {
		return id;
	}
	public int getnum() {
		return num;
	}
	public void setnum(int i) {
		num=i;
	}
	public Irany toget(int num) {
		if(szomszedok.contains(num)) {
			int i=szomszedok.get(num);
			return namegyem.get(i);
		}
		return null;
	}
}