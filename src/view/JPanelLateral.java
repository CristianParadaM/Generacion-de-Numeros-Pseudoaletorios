package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.utils.Constants;

public class JPanelLateral extends JPanel {

	private JPanelLateralMethodOne jPanelLateralMethodOne;
	private JPanelLateralMethodTwo jPanelLateralMethodTwo;

	private JPanel jPanellateralDefault;
	private GridBagConstraints gbc;

	private JLabel jLabelMainMenu;
	private JLabel jLabelChooseOption;
	private JLabel jLabelVersion;

	public JPanelLateral() {
		super(new GridLayout());
		this.gbc = new GridBagConstraints();
		this.jLabelVersion = new JLabel(Constants.VERSION);
		this.jLabelMainMenu = new JLabel(Constants.MAIN_MENU, JLabel.CENTER);
		this.jLabelChooseOption = new JLabel(
				"<html><p style='text-align: justify;'>" + Constants.CHOOSE_OPTION + "</p></html>");
		this.jPanellateralDefault = new JPanel(new GridBagLayout());
		this.jPanelLateralMethodOne = new JPanelLateralMethodOne();
		this.jPanelLateralMethodTwo = new JPanelLateralMethodTwo();
		init();
	}

	private void init() {
		this.jPanellateralDefault.setOpaque(false);
		this.setPreferredSize(new Dimension(322 * JFrameMain.WIDTH_FRAME / 1920, 0));
		this.setOpaque(false);
		configureLabel(jLabelMainMenu, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelChooseOption, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelVersion, Constants.FONT_SIZE_APP_PLACEHOLDER, Font.ITALIC);
		
		gbc.fill =1;
		gbc.weightx =1;
		gbc.insets.top = 5;
		gbc.insets.left = 20;
		gbc.insets.right = 20;
		this.jPanellateralDefault.add(jLabelMainMenu, gbc);
		gbc.insets.top = 20;
		gbc.gridy = 1;
		this.jPanellateralDefault.add(jLabelChooseOption, gbc);
		gbc.gridy = 2;
		gbc.weighty = 1;
		this.jPanellateralDefault.add(Box.createRigidArea(new Dimension(0,0)), gbc);
		gbc.weighty = 0;
		gbc.gridy = 3;
		gbc.insets.bottom = 20;
		this.jPanellateralDefault.add(jLabelVersion, gbc);
		changeMethodLateral(".");
	}
	
	private void configureLabel(JLabel jLabel, int fontSize, int style) {
		jLabel.setFont(new Font(Constants.FONT_APP, style, fontSize));
		jLabel.setForeground(Color.WHITE);
	}

	public void changeMethodLateral(String option) {
		removeComponents();
		switch (option) {
		case Constants.METHOD_ONE:
			jPanelLateralMethodOne.setVisible(true);
			this.add(jPanelLateralMethodOne, BorderLayout.CENTER);
			break;
		case Constants.METHOD_TWO:
			jPanelLateralMethodTwo.setVisible(true);
			this.add(jPanelLateralMethodTwo, BorderLayout.CENTER);
			break;
//			case Constants.METHOD_THREE: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
//			case Constants.METHOD_FOUR: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
		default:
			jPanellateralDefault.setVisible(true);
			this.add(jPanellateralDefault);
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
//		g2d.drawLine(20 * JFrameMain.WIDTH_FRAME / 1920, 50 * JFrameMain.HEIGHT_FRAME / 1080,
//				getWidth() - (20 * JFrameMain.WIDTH_FRAME / 1920), 50 * JFrameMain.HEIGHT_FRAME / 1080);
		super.paint(g);

	}

	public void moveAccordion(int index) {
		jPanelLateralMethodTwo.moveAccordion(index);
	}
}
