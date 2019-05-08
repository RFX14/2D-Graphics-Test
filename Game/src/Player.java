import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class Player {
	String name;
	int xPos = 10;
	int yPos = 10;
	int xSize = 10;
	int ySize = 10;
	int ammo = 10;
	int HP = 10;

	int xVel = 0;
	int yVel = 0;

	boolean shoot = false;
	boolean hitObject = false;
	Font pInfo, pLocation;

	public Player(String name, int xPos, int yPos, int xSize, int ySize, int ammo , int HP) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.ammo = ammo;
		this.HP = HP;
	}

	public void update(Bullet bullet, Obstacle obstacle) {
		xPos += xVel;
		yPos += yVel;
		hitObject = bullet.bounds(shoot(), obstacle.getXPos(), obstacle.getYPos());
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_D) {
			xVel = 5;
		} else if(key == KeyEvent.VK_A) {
			xVel = -5;
		} else if(key == KeyEvent.VK_W) {
			yVel = -5;
		} else if(key == KeyEvent.VK_S) {
			yVel = 5;
		} else if(key == KeyEvent.VK_SHIFT) {
			shoot = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_D) {
			xVel = 0;
		} else if(key == KeyEvent.VK_A) {
			xVel = 0;
		} else if(key == KeyEvent.VK_W) {
			yVel = 0;
		} else if(key == KeyEvent.VK_S) {
			yVel = 0;
		} else if(key == KeyEvent.VK_SHIFT) {
			shoot = false;
		}
	}

	public void draw(Graphics2D g2d, Player player) {
		Bullet bullet = new Bullet(player);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(xPos, yPos, xSize, ySize);

		if(hitObject) {
			HP -= 10;
		}

		String info = getName() + ": " + getHP() + "/100HP" + " Shoot = " + shoot;
		String locaInfo = "(" + getX() + ", " + getY() + ")" + " HP: " + HP;


		pInfo = new Font ("Courier New", 1, 30);
		g2d.setFont(pInfo);
		g2d.setColor(Color.black);
		g2d.drawString(info, player.getX() - 100, player.getY() - 10);
		//g2d.drawString(locaInfo, player.getX() - 100, player.getY() + 80);

		if(shoot() == true) {
			bullet.draw(g2d);
		}
	}

	public int getX() {
		return xPos;
	}
	public int getXVel() {
		return xVel;
	}
	public int getY() {
		return yPos;
	}
	public int getYVel() {
		return yVel;
	}
	public String getName() {
		return name;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hp) {
		HP = hp;
	}
	public boolean shoot() {
		return shoot;
	}

}
