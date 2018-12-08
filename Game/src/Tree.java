import java.awt.*;
import java.security.SecureRandom;
import java.util.Random;

public class Tree {
    Random rand= new SecureRandom();
    int xPos = rand.nextInt(1281);
    int yPos = rand.nextInt(721);

    public Tree(){

    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(99,78,32));
        g2d.fillRect(xPos, yPos, 20, 50);

        g2d.setColor(new Color(39,119,47));
        g2d.fillOval(xPos - 25,yPos - 30,40,40); //Left Leaf
        g2d.fillOval(xPos + 5,yPos - 30,40,40); //Right Leaf
        g2d.fillOval(xPos - 8,yPos - 50,40,40); //Top Leaf
    }
}
