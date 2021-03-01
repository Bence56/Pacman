import java.awt.Color;
import java.awt.*;

import javax.swing.*;

public class Infopanel extends JPanel implements Runnable{
	int elet=3;
	public int pontok=0;
	Thread thread=new Thread(this);
	JLabel pontlabel=new JLabel("Pontok: "+pontok);
	JLabel eletlabel=new JLabel("Életek: "+elet);
	public Infopanel(){
		//this.setSize(100, 100);
		pontlabel.setSize(840, 50);
		eletlabel.setSize(840, 50);
		this.setLayout(new GridLayout());
		this.add(eletlabel);
		//this.add(eletfield);
		this.add(pontlabel);
		//this.add(pontfield);
		this.setBackground(Color.CYAN);
		
		//this.setVisible(true);
		
	}
	public void pontotkapott() {
	
		pontok+=10;
	}
	public void Start() {
		thread.start();
	}
	@Override
	public void run() {
		while(!Screen.jatekvege()) {
			//System.out.print("PONTOK LACIKÁM");
			pontlabel.setText("Pontok: "+pontok);
			eletlabel.setText("Elet: "+Integer.toString(elet));
		}
	}
	public boolean killANDisGameOver() {
		elet--;
		if(elet>0)
		return false;
		else
			return true;
	}
}
