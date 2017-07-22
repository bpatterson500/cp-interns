package volunteering;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JStuff {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		RenderPanel panel = new RenderPanel();
		
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(panel);
		frame.addMouseListener(new MyMouseListener());
		
	}
}
