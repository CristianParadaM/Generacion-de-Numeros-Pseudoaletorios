package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		addPropertiesButtons(jButtonMethodOne);
		addPropertiesButtons(jButtonMethodTwo);
		addPropertiesButtons(jButtonMethodThree);
		addPropertiesButtons(jButtonMethodFour);
		
		this.jpanelHeader.add(jButtonMethodOne);
		this.jpanelHeader.add(jButtonMethodTwo);
		this.jpanelHeader.add(jButtonMethodThree);
		this.jpanelHeader.add(jButtonMethodFour);
		
		this.jpanelContent.setBackground(Constants.COLOR_BACKGROUND_CONTENT);
		
		this.add(jpanelHeader, BorderLayout.NORTH);
		this.add(jpanelContent, BorderLayout.CENTER);
		this.add(jpanelLateral, BorderLayout.WEST);
	}
	
	private void addPropertiesButtons(JButton button) {
		button.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_BUTTONS));
		button.setBackground(Constants.COLOR_BUTTONS_METHODS);
		button.setForeground(Color.WHITE);
		button.setBorder(new LineBorder(Constants.COLOR_BORDER));
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(0,35));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Constants.COLOR_BUTTONS_METHODS);
			}
		});
	}

	
	public void showMethod(String method) {
		jpanelContent.changeMethodLContent(method);
		
	}
	

	
}
