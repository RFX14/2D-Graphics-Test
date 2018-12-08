import java.awt.*;
import java.security.SecureRandom;
import java.util.Random;

public class Buildings {
    Random rand= new SecureRandom();
    int xPos = rand.nextInt(1281);
    int yPos = rand.nextInt(721);

    public void draw(Graphics g) {
        g.setColor(new Color(158, 129, 96));
        g.fillRect(xPos, yPos, 300, 100);

        g.setColor(new Color(110, 216, 255));
        g.fillRect(xPos + 100, yPos + 75, 25, 25);
        g.fillRect(xPos + 200, yPos + 75, 25, 25);
    }
}
