package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import view.utils.Constants;

public class JPanelMain extends JPanel {

	private JPanel jpanelHeader;
	private JPanelLateral jpanelLateral;
	private JPanelContent jpanelContent;
	private JButton jButtonMethodOne;
	private JButton jButtonMethodTwo;
	private JButton jButtonMethodThree;
	private JButton jButtonMethodFour;

	public JPanelMain() {
		super(new BorderLayout());
		this.jpanelHeader = new JPanel(new GridLayout(1, 4));
		this.jpanelContent = new JPanelContent();
		this.jpanelLateral = new JPanelLateral();
		jButtonMethodOne = new JButton(Constants.METHOD_ONE);
		jButtonMethodTwo = new JButton(Constants.METHOD_TWO);
		jButtonMethodThree = new JButton(Constants.METHOD_THREE);
		jButtonMethodFour = new JButton(Constants.METHOD_FOUR);
		init();
	}

	private void init() {
		addPropertiesButtons(jButtonMethodOne, Constants.COMMAND_SWITCH_METHOD_ONE);
		addPropertiesButtons(jButtonMethodTwo, Constants.COMMAND_SWITCH_METHOD_TWO);
		addPropertiesButtons(jButtonMethodThree, Constants.COMMAND_SWITCH_METHOD_THREE);
		addPropertiesButtons(jButtonMethodFour, Constants.COMMAND_SWITCH_METHOD_FOUR);
		this.jpanelHeader.add(jButtonMethodOne);
		this.jpanelHeader.add(jButtonMethodTwo);
		this.jpanelHeader.add(jButtonMethodThree);
		this.jpanelHeader.add(jButtonMethodFour);
		this.jpanelContent.setBackground(Constants.COLOR_BACKGROUND_CONTENT);
		this.add(jpanelHeader, BorderLayout.NORTH);
		this.add(jpanelContent, BorderLayout.CENTER);
		this.add(jpanelLateral, BorderLayout.WEST);
	}

	private void addPropertiesButtons(JButton button, String actionComand) {
		button.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_BUTTONS));
		button.setBackground(Constants.COLOR_BUTTONS_METHODS);
		button.setForeground(Color.WHITE);
		button.setBorder(new LineBorder(Constants.COLOR_BORDER));
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(0, 35));
		button.addActionListener(JFrameMain.getInstance());
		button.setActionCommand(actionComand);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBorder(new LineBorder(Color.WHITE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBorder(new LineBorder(Constants.COLOR_BORDER));
			}
		});
	}

	public void showMethod(String method, ArrayList<Object[]> info, String[] columnNames, ArrayList<Double> x,
			ArrayList<Double> y) {
		jpanelContent.changeMethodContent(method, info, columnNames, x, y);
	}

	public void changeToMethod(String method, String... commands) {
		jpanelLateral.changeMethodLateral(method, commands);
		jpanelContent.changeMethodContent(".", null, null, null, null);
		changeButtonBackGround(method);
	}

	private void changeButtonBackGround(String method) {
		switch (method) {
		case Constants.METHOD_ONE:
			jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
			jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS);
			break;
		case Constants.METHOD_TWO:
			jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
			jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS);
			break;
		case Constants.METHOD_THREE:
			jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
			jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS);
			break;
		case Constants.METHOD_FOUR:
			jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
			jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS);
			jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS);
			break;
			

		}
	}

	public void moveAccordion(int index) {
		jpanelLateral.moveAccordion(index);
	}

	public void moveAccordionUni(int index) {
		jpanelLateral.moveAccordionUni(index);
	}

	public void moveAccordionUniC(int index) {
		jpanelLateral.moveAccordionUniC(index);
	}

	public String getSeed() {
		return jpanelLateral.getSeed();
	}

	public boolean getFill() {
		return jpanelLateral.getFill();
	}

	public void highlightM1(int index, int option) {
		jpanelLateral.highlightM1(index, option);
	}

	public String getKM1() {
		return jpanelLateral.getKM1();
	}

	public String getCM1() {
		return jpanelLateral.getCM1();
	}

	public String getGM1() {
		return jpanelLateral.getGM1();
	}

	public String getTM2() {
		return jpanelLateral.getTM2();
	}

	public String getGM2() {
		return jpanelLateral.getGM2();
	}

	public void highlightM2M1(int index, int option) {
		jpanelLateral.highlightM2M1(index, option);
	}

	public void highlightM2M2(int index, int option) {
		jpanelLateral.highlightM2M2(index, option);
	}

	public String getMinU() {
		return jpanelLateral.getMinU();
	}

	public String getMaxU() {
		return jpanelLateral.getMaxU();
	}

	public String getSeedU() {
		return jpanelLateral.getSeedU();
	}

	public boolean getFillU() {
		return jpanelLateral.getFillU();
	}

	public String getKU() {
		return jpanelLateral.getKU();
	}

	public String getCU() {
		return jpanelLateral.getCU();
	}

	public String getGU1() {
		return jpanelLateral.getGU1();
	}

	public String getGU2() {
		return jpanelLateral.getGU2();
	}

	public String getTU() {
		return jpanelLateral.getTU();
	}

	public void moveAccordionNor(int i) {
		jpanelLateral.moveAccordionNor(i);
	}

	public void moveAccordionNorC(int i) {
		jpanelLateral.moveAccordionNorC(i);
	}

	public String getMean() {
		return jpanelLateral.getMean();
	}

	public String getSD() {
		return jpanelLateral.getSD();
	}

	public String getSeedN() {
		return jpanelLateral.getSeedN();
	}

	public boolean getFillN() {
		return jpanelLateral.getFillN();
	}

	public String getKN() {
		return jpanelLateral.getKN();
	}

	public String getCN() {
		return jpanelLateral.getCN();
	}

	public String getGN1() {
		return jpanelLateral.getG1N();
	}

	public String getGN2() {
		return jpanelLateral.getG2N();
	}

	public String getTN() {
		return jpanelLateral.getTN();
	}

}
