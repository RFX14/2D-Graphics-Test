import java.awt.*;

public class Bullet {
	int xPosB;
	int yPosB;
	int xSize;
	int xVelB = 0;
	int yVelB = 0;
	boolean shoot;

	public Bullet(Player player) {
		this.xPosB = player.getX() + 50;
		this.yPosB = player.getY() + 20;
	}

	public void update(Player player) {
		shoot = player.shoot();
		if(shoot) {
			xVelB = 20;
		}

		xPosB += xVelB;
		yPosB += yVelB;

		xSize = xPosB;
	}

	public void draw(Graphics2D g2d) {
		g2d.fillRect(xPosB, yPosB, 10, 10);


		String objectLocation = "(" + xSize + ", " + yPosB + ")";;
		Font pInfo = new Font ("Courier New", 1, 30);
		g2d.setFont(pInfo);
		g2d.setColor(Color.black);
		g2d.drawString(objectLocation, xPosB - 100, yPosB + 70);
	}

	public boolean bounds(boolean shoot, int enemyX, int enemyY) {
		if(shoot) {
			if(xSize <= (enemyX + 50) && xSize >= enemyX) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
