package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JPanel;
import view.utils.Constants;

public class JPanelLateral extends JPanel {

	private JPanelLateralMethodOne jPanelLateralMethodOne;
	
	public JPanelLateral() {
		super(new GridLayout());
		this.jPanelLateralMethodOne = new JPanelLateralMethodOne();
		init();
	}

	private void init() {
		this.setPreferredSize(new Dimension(322 * JFrameMain.WIDTH_FRAME / 1920, 0));
		this.setOpaque(false);
		changeMethodLateral(Constants.METHOD_ONE);
	}
	
	public void changeMethodLateral(String option) {
		removeComponents();
		switch (option) {
			case Constants.METHOD_ONE:
				jPanelLateralMethodOne.setVisible(true);
				this.add(jPanelLateralMethodOne, BorderLayout.CENTER);
				break;
//			case Constants.METHOD_TWO: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
//			case Constants.METHOD_THREE: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
//			case Constants.METHOD_FOUR: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
		}
	}
	
	public void removeComponents() {
		for (int i = 0; i < this.getComponentCount(); i++) {
			this.getComponent(i).setVisible(false);
		}
		this.removeAll();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(new GradientPaint(0, 0, Constants.COLOR_BACKGROUND_GRADIENT_ONE, getWidth() / 2, getHeight(),
				Constants.COLOR_BACKGROUND_GRADIENT_TWO));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Constants.COLOR_BORDER);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(getWidth(), 0, getWidth(), getHeight());
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.WHITE);
		g2d.drawLine(20 * JFrameMain.WIDTH_FRAME / 1920, 50 * JFrameMain.HEIGHT_FRAME / 1080,
				getWidth() - (20 * JFrameMain.WIDTH_FRAME / 1920), 50 * JFrameMain.HEIGHT_FRAME / 1080);
		super.paint(g);

	}
}
