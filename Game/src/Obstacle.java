import java.awt.*;

public class Obstacle {

	int xPos = 500;
	int yPos = 500;

	public Obstacle(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.CYAN);
		g2d.fillRect(xPos, yPos, 50, 50);

		String objectLocation = "(" + getXPos() + ", " + getYPos() + ")";;
		Font pInfo = new Font ("Courier New", 1, 30);
		g2d.setFont(pInfo);
		g2d.setColor(Color.black);
		g2d.drawString(objectLocation, getXPos() - 100, getYPos() - 10);
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}
}
