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

/**
 * 
 * Panel lateral en donde se muestran las opciones del metodo seleccionado dentro de la aplicacion
 *
 * @author Cristian David Parada Martinez, Daniel Felipe Suarez Bohorquez
 *         ,Julian Steven Huertas Henao
 */
public class JPanelLateral extends JPanel {

	private JPanelLateralMethodOne jPanelLateralMethodOne;
	private JPanelLateralMethodTwo jPanelLateralMethodTwo;
	private JPanelLateralMethodThree jPanelLateralMethodThree;
	private JPanelLateralMethodFour jPanelLateralMethodFour;
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
		init();
	}

	private void init() {
		this.jPanellateralDefault.setOpaque(false);
		this.setPreferredSize(new Dimension(322 * JFrameMain.WIDTH_FRAME / 1920, 0));
		this.setOpaque(false);
		configureLabel(jLabelMainMenu, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelChooseOption, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelVersion, Constants.FONT_SIZE_APP_PLACEHOLDER, Font.ITALIC);
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets.top = 5;
		gbc.insets.left = 20;
		gbc.insets.right = 20;
		this.jPanellateralDefault.add(jLabelMainMenu, gbc);
		gbc.insets.top = 20;
		gbc.gridy = 1;
		this.jPanellateralDefault.add(jLabelChooseOption, gbc);
		gbc.gridy = 2;
		gbc.weighty = 1;
		this.jPanellateralDefault.add(Box.createRigidArea(new Dimension(0, 0)), gbc);
		gbc.weighty = 0;
		gbc.gridy = 3;
		gbc.insets.bottom = 20;
		this.jPanellateralDefault.add(jLabelVersion, gbc);
		changeMethodLateral(".",null);
	}

	private void configureLabel(JLabel jLabel, int fontSize, int style) {
		jLabel.setFont(new Font(Constants.FONT_APP, style, fontSize));
		jLabel.setForeground(Color.WHITE);
	}

	public void changeMethodLateral(String option, String[] commands) {
		removeComponents();
		switch (option) {
		case Constants.METHOD_ONE:
			this.jPanelLateralMethodOne = new JPanelLateralMethodOne(commands[0]);
			this.add(jPanelLateralMethodOne, BorderLayout.CENTER);
			jPanelLateralMethodOne.updateUI();
			break;
		case Constants.METHOD_TWO:
			jPanelLateralMethodTwo = new JPanelLateralMethodTwo(commands[0], commands[1], commands[2], commands[3]);
			this.add(jPanelLateralMethodTwo, BorderLayout.CENTER);
			jPanelLateralMethodTwo.updateUI();
			break;
		case Constants.METHOD_THREE:
			jPanelLateralMethodThree = new JPanelLateralMethodThree();
			this.add(jPanelLateralMethodThree);
			jPanelLateralMethodThree.updateUI();
			break;
		case Constants.METHOD_FOUR:
			jPanelLateralMethodFour = new JPanelLateralMethodFour();
			this.add(jPanelLateralMethodFour);
			jPanelLateralMethodFour.updateUI();
			break;
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
		super.paint(g);

	}

	public void moveAccordion(int index) {
		jPanelLateralMethodTwo.moveAccordion(index);
	}

	public void moveAccordionUni(int index) {
		jPanelLateralMethodThree.moveAccordion(index);
	}
	public void moveAccordionUniC(int index) {
		jPanelLateralMethodThree.moveAccordionC(index);
	}

	public String getSeed() {
		return jPanelLateralMethodOne.getSeed();
	}

	public boolean getFill() {
		return jPanelLateralMethodOne.getFill();
	}

	public void highlightM1(int index, int option) {
		jPanelLateralMethodOne.highlight(index, option);
	}

	public String getKM1() {
		return jPanelLateralMethodTwo.getKM1();
	}

	public String getCM1() {
		return jPanelLateralMethodTwo.getCM1();
	}

	public String getGM1() {
		return jPanelLateralMethodTwo.getGM1();
	}

	public String getTM2() {
		return jPanelLateralMethodTwo.getTM2();
	}

	public String getGM2() {
		return jPanelLateralMethodTwo.getGM2();
	}

	public void highlightM2M1(int index, int option) {
		jPanelLateralMethodTwo.highlightM2M1(index, option);
	}

	public void highlightM2M2(int index, int option) {
		jPanelLateralMethodTwo.highlightM2M2(index, option);
	}

	public String getMinU() {
		return jPanelLateralMethodThree.getMin();
	}

	public String getMaxU() {
		return jPanelLateralMethodThree.getMaxU();
	}

	public String getSeedU() {
		return jPanelLateralMethodThree.getSeedU();
	}

	public boolean getFillU() {
		return jPanelLateralMethodThree.getFillU();
	}

	public String getKU() {
		return jPanelLateralMethodThree.getKU();
	}

	public String getCU() {
		return jPanelLateralMethodThree.getCU();
	}

	public String getGU1() {
		return jPanelLateralMethodThree.getGU1();
	}
	public String getGU2() {
		return jPanelLateralMethodThree.getGU2();
	}

	public String getTU() {
		return jPanelLateralMethodThree.getTU();
	}

	public void moveAccordionNor(int i) {
		jPanelLateralMethodFour.moveAccordion(i);
	}

	public void moveAccordionNorC(int i) {
		jPanelLateralMethodFour.moveAccordionC(i);
	}

	public String getMean() {
		return jPanelLateralMethodFour.getMean();
	}

	public String getSD() {
		return jPanelLateralMethodFour.getSD();
	}

	public String getSeedN() {
		return jPanelLateralMethodFour.getSeedN();
	}

	public boolean getFillN() {
		return jPanelLateralMethodFour.getFillN();
	}

	public String getKN() {
		return jPanelLateralMethodFour.getKN();
	}
	public String getCN() {
		return jPanelLateralMethodFour.getCN();
	}
	public String getG1N() {
		return jPanelLateralMethodFour.getGN1();
	}
	public String getG2N() {
		return jPanelLateralMethodFour.getGN2();
	}

	public String getTN() {
		return jPanelLateralMethodFour.getTN();
	}
}
