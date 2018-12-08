import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	String name = "RFX14";
	int xPos = 640;
	int yPos = 360;
	int HP = 100;

	int xPosB = xPos + 50;
	int yPosB = yPos + 25;
	int xVelB = 0;
	int yVelB = 0;

	Player player;
	Bullet bullet;
	Obstacle obstacle;
	Tree tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, tree10;
	Buildings build1, build2;

	Timer gamelooptimer;

	public Game() {
		setFocusable(true);
		gamelooptimer = new Timer(10, this);
		gamelooptimer.start();

		build1 = new Buildings();
		build2 = new Buildings();

		tree1 = new Tree();
		tree2 = new Tree();
		tree3 = new Tree();
		tree4 = new Tree();
		tree5 = new Tree();
		tree6 = new Tree();
		tree7 = new Tree();
		tree8 = new Tree();
		tree9 = new Tree();
		tree10 = new Tree();

		player = new Player(name, xPos, yPos, 50, 50, 500 ,100);
		bullet = new Bullet(player);
		obstacle = new Obstacle(600,300);
		addKeyListener(new KeyInput(player));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		tree1.draw(g2d);
		tree2.draw(g2d);
		tree3.draw(g2d);
		tree4.draw(g2d);
		tree5.draw(g2d);

		build1.draw(g);

		player.draw(g2d, player);
		obstacle.draw(g2d);

		build2.draw(g);

		tree6.draw(g2d);
		tree7.draw(g2d);
		tree8.draw(g2d);
		tree9.draw(g2d);
		tree10.draw(g2d);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void actionPerformed(ActionEvent e) {
		if(bullet != null && obstacle != null) {
			player.update(bullet, obstacle);
			bullet.update(player);
		}

		repaint();
	}
}
