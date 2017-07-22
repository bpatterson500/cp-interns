import java.awt.Color;
import java.awt.Rectangle;

public class Button extends Rectangle{
	public Color color = RenderPanel.buttonUnpressed, colorPressed = RenderPanel.buttonPressed;
	public String info;
	public boolean pressed = false;
	public Button(int x, int y, int sizeX, int sizeY, String info){
		super(x, y, sizeX, sizeY);
		this.info = info;
	}
}
