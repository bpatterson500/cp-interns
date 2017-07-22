
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseCoordListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e){
		System.out.println(e.getLocationOnScreen());
		if(RenderPanel.buttons != null){
			for(Button b: RenderPanel.buttons){
				if(b.contains(e.getLocationOnScreen())){
					b.pressed = !b.pressed;
					Main.panel.repaint();
					System.out.println(b.info);
					System.out.println(b.pressed);
				}
			}
		}else{
			System.out.println("null arraylist");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
