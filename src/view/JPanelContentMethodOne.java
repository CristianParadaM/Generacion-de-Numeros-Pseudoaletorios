package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class JPanelContentMethodOne extends JPanel{
	
	public JPanelContentMethodOne() {
		super(new GridBagLayout());
		init();
	}

	private void init() {
		this.setOpaque(false);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.drawLine(20, 50, getWidth()-20, 50);
		super.paint(g);
	}

}
