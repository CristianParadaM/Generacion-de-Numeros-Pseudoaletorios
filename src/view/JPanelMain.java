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
		this.jpanelHeader = new JPanel(new GridLayout(1,4));
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
		
		jButtonMethodOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
				jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS);
			}
		});
		jButtonMethodTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
				jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS);
			}
		});
		jButtonMethodThree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
				jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS);
			}
		});
		jButtonMethodFour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jButtonMethodFour.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
				jButtonMethodTwo.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodThree.setBackground(Constants.COLOR_BUTTONS_METHODS);
				jButtonMethodOne.setBackground(Constants.COLOR_BUTTONS_METHODS);
			}
		});
		
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
		button.setPreferredSize(new Dimension(0,35));
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

	
	public void showMethod(String method, ArrayList<Object[]> info, String[] columnNames) {
		jpanelContent.changeMethodContent(method, info, columnNames);
	}

	public void changeToMethod(String method) {
		jpanelLateral.changeMethodLateral(method);;
	}

	public void moveAccordion(int index) {
		jpanelLateral.moveAccordion(index);
	}

	public String getSeed() {
		return jpanelLateral.getSeed();
	}

	public String getMinM1() {
		return jpanelLateral.getMinM1();
	}

	public String getMaxM1() {
		return jpanelLateral.getMaxM1();
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

	public String getMinM2M1() {
		return jpanelLateral.getMinM2M1();
	}

	public String getMaxM2M1() {
		return jpanelLateral.getMaxM2M1();
	}

	public String getTM2() {
		return jpanelLateral.getTM2();
	}

	public String getGM2() {
		return jpanelLateral.getGM2();
	}

	public String getMinM2M2() {
		return jpanelLateral.getMinM2M2();
	}

	public String getMaxM2M2() {
		return jpanelLateral.getMaxM2M2();
	}

	public void highlightM2M1(int index, int option) {
		jpanelLateral.highlightM2M1( index,  option);
	}
	public void highlightM2M2(int index, int option) {
		jpanelLateral.highlightM2M2( index,  option);
	}
	
}
