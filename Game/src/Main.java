import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
	public static void main(String []args) {
		JFrame myFrame = new JFrame("Game");
		myFrame.pack();
		myFrame.setSize(1280, 720);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.add(new Game());
		myFrame.setVisible(true);
	}

}
