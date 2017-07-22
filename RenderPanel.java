package volunteering;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RenderPanel extends JPanel{
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 50, 50);
	}
}
