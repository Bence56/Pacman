import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import java.awt.*;

public class Map {
	private int worldWidth = 31;
	private int worldHeight = 28;
	private int blockSize = 64;
	public static Block[][] blocks;
	public Map() throws IOException {
		define();
	}
	public void define() throws IOException {
		blocks = new Block[31][28];
		int num=0;
		String line;
		BufferedReader br=new BufferedReader(new FileReader("res/Map/Map.txt"));
		int y=0;
		while((line=br.readLine())!=null) {
			String[] tomb=line.split(" ");
			for(int x = 0; x < blocks[0].length;x++) {
				int aktid=Integer.parseInt(tomb[x]);
				blocks[y][x] = new Block(x*30,y*30, 30,30,aktid,(new ImageIcon("res/Map/Fal.png").getImage()));
				blocks[y][x].setimg(aktid);
				if(aktid==1) {
					blocks[y][x].setnum(-1);
				}
				else {
					blocks[y][x].setnum(num);
					num++;
				}
			}
			y++;
		}
		namegyemfeltolto();
	}
	public void draw(Graphics g) {
		//System.out.println("		Map");
		for(int y = 0; y < blocks.length; y++) {
			for(int x = 0; x < blocks[0].length;x++) {
				blocks[y][x].draw(g);
			}
		}	
	}
	public static int getId(int i, int j) {
		return blocks[i][j].getid();
	}
	public static void setId(int y,int x,int id) {
		blocks[y][x].setid(id);
	}
	public boolean vanmeggolyo() {
		for(int y=0;y<blocks.length;y++) {
			for(int x=0;x<blocks[0].length;x++) {
				if(blocks[y][x].getid()==3) {
					return true;
				}
			}
		}
		return false;
	}
	public void namegyemfeltolto() {
		for(int y=0;y<blocks.length;y++) {
			for(int x=0;x<blocks[0].length;x++) {
				int i=y;
				int j=x;
				if(blocks[y][x].getid()!=1) {
					if(i-1>=0&&blocks[i-1][j].getid()!=1&&blocks[i][j].getid()!=1) {
						blocks[y][x].namegyem.add(Irany.Fel);
						blocks[y][x].szomszedok.add(blocks[i-1][j].getnum());
					}
					else if(i+1<=30&&blocks[i+1][j].getid()!=1&&blocks[i][j].getid()!=1) {
						blocks[y][x].namegyem.add(Irany.Le);
						blocks[y][x].szomszedok.add(blocks[i+1][j].getnum());
					}
					else if(j-1>=0&&blocks[i][j-1].getid()!=1&&blocks[i][j].getid()!=1) {
						blocks[y][x].namegyem.add(Irany.Bal);
						blocks[y][x].szomszedok.add(blocks[i][j-1].getnum());
					}
					else if(j+1<=27&&blocks[i][j+1].getid()!=1&&blocks[i][j].getid()!=1) {
						blocks[y][x].namegyem.add(Irany.Jobb);
						blocks[y][x].szomszedok.add(blocks[i][j+1].getnum());
					}
				}
			}
		}
	}

	public static ArrayList<Irany> bfs(int startnum, int exitnum) {
	//solve bfs
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(startnum);
		int len=0;
		for(int y=0;y<blocks.length;y++) {
			for(int x=0;x<blocks[0].length;x++) {
				if(blocks[y][x].getnum()!=-1)
				len++;
			}
		}
		boolean[] visited=new boolean[len];
		for(int i=0;i<visited.length;i++) {
			visited[i]=false;
		}
		visited[startnum]=true;
		
		int[] previousnum=new int[len];
		int cnt=0;
		for(int i=0;i<len;i++){
			previousnum[i]=-1;
		}
		while(!que.isEmpty()) {
			int node=que.get(0);
			
			ArrayList<Integer>szomszedok=new ArrayList();
			for(int y=0;y<blocks.length;y++) {
				for(int x=0;x<blocks[0].length;x++) {
					if(blocks[y][x].getnum()==node) {
						szomszedok=blocks[y][x].szomszedok;
					}
				}
			}
			for(int i=0;i<szomszedok.size();i++) {
				if(!visited[szomszedok.get(i)]) {
					que.add(szomszedok.get(i));
					visited[szomszedok.get(i)]=true;
					previousnum[cnt]=szomszedok.get(i);
				}
			}
			que.remove(0);
			
		}
		ArrayList<Integer>path=new ArrayList<Integer>();
		ArrayList<Irany>pathirany=new ArrayList<Irany>();
		for(int i=exitnum;i!=-1&&i>=0;i=previousnum[i]) {
			path.add(i);
		}
		if(path.get(0)!=startnum)
		for(int i=0;i<path.size()-1;i++) {
			for(int y=0;y<blocks.length;y++) {
				for(int x=0;x<blocks[0].length;x++) {
					if(blocks[y][x].getnum()==path.get(i)) {
						pathirany.add(blocks[y][x].toget(path.get(i+1)));
					}
				}
			}
		}
		return pathirany;
		 
	}
}

