package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import controller.Controller;
import model.TextPrompt;
import view.utils.Constants;

@SuppressWarnings("deprecation")
public class JPanelLateralMethodTwo extends JPanel {

	private JPanel jPanelContainer;
	private JButton jButtonAccordionM1;
	private JButton jButtonAccordionM2;
	private JLabel jLabelTitle;

	// AC1
	private JPanel jPanelContainerM1;
	private JLabel jLabelTitleM1;
	private JLabel jLabelNumberKM1;
	private JLabel jLabelNumberCM1;
	private JLabel jLabelNumberGM1;
	private JTextField jTextFieldNumberKM1;
	private JTextField jTextFieldNumberCM1;
	private JTextField jTextFieldNumberGM1;
	private JButton buttonGenerateM1;

	// AC2
	private JPanel jPanelContainerM2;
	private JLabel jLabelTitleM2;
	private JLabel jLabelNumberTM2;
	private JLabel jLabelNumberGM2;
	private JTextField jTextFieldNumberTM2;
	private JTextField jTextFieldNumberGM2;
	private JButton buttonGenerateM2;

	private GridBagConstraints gbc;

	public JPanelLateralMethodTwo(String actionCommand1, String actionComand2, String actionCommandB1, String actionCommandB2) {
		super(new GridLayout());
		this.gbc = new GridBagConstraints();
		this.jPanelContainer = new JPanel();
		this.buttonGenerateM1 = new JButton(Constants.GENERATE);
		this.buttonGenerateM2 = new JButton(Constants.GENERATE);
		this.jButtonAccordionM1 = new JButton(Constants.CONGRUENCIAL_LINEAL);
		this.jButtonAccordionM2 = new JButton(Constants.CONGRUENCIAL_MULTIPLICATIVO);
		this.jPanelContainerM1 = new JPanel(new GridBagLayout());
		this.jLabelTitle = new JLabel("<html><p style='text-align:jusify;'>"+Constants.TITLE_CONGR+"</p></html>", JLabel.CENTER);
		this.jLabelTitleM1 = new JLabel(Constants.ENTRIES, JLabel.CENTER);
		this.jLabelNumberKM1 = new JLabel(Constants.NUMBER_K);
		this.jLabelNumberCM1 = new JLabel(Constants.NUMBER_C);
		this.jLabelNumberGM1 = new JLabel(Constants.NUMBER_G);
		this.jTextFieldNumberKM1 = new JTextField();
		this.jTextFieldNumberCM1 = new JTextField();
		this.jTextFieldNumberGM1 = new JTextField();
		this.jPanelContainerM2 = new JPanel(new GridBagLayout());
		this.jLabelTitleM2 = new JLabel(Constants.ENTRIES, JLabel.CENTER);
		this.jLabelNumberTM2 = new JLabel(Constants.NUMBER_T);
		this.jLabelNumberGM2 = new JLabel(Constants.NUMBER_G);
		this.jTextFieldNumberTM2 = new JTextField();
		this.jTextFieldNumberGM2 = new JTextField();
		init(actionCommand1, actionComand2, actionCommandB1, actionCommandB2);
	}

	private void init(String actionCommand1, String actionComand2, String actionCommandB1, String actionCommandB2) {
		this.setOpaque(false);
		this.add(jPanelContainer);
		this.jPanelContainer.setLayout(null);
		this.jPanelContainer.setOpaque(false);
		this.jPanelContainerM1.setOpaque(false);
		this.jPanelContainerM2.setOpaque(false);
		configureButtonAccordion(jButtonAccordionM1, actionCommand1);
		configureButtonAccordion(jButtonAccordionM2, actionComand2);

		configureLabel(jLabelTitle, Constants.FONT_SIZE_APP_PLACEHOLDER, Font.PLAIN);
		configureLabel(jLabelTitleM1, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelNumberKM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelNumberCM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelNumberGM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);

		configureTextField(jTextFieldNumberKM1, Constants.PLACEHOLDER_NUMERO_K);
		configureTextField(jTextFieldNumberCM1, Constants.PLACEHOLDER_NUMERO_C);
		configureTextField(jTextFieldNumberGM1, Constants.PLACEHOLDER_NUMERO_G);

		configureLabel(jLabelTitleM2, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelNumberTM2, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelNumberGM2, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);

		configureTextField(jTextFieldNumberTM2, Constants.PLACEHOLDER_NUMERO_K);
		configureTextField(jTextFieldNumberGM2, Constants.PLACEHOLDER_NUMERO_G);

		configureButton(buttonGenerateM1, actionCommandB1);
		configureButton(buttonGenerateM2, actionCommandB2);

		addItemsPanels();
		addItems();
		
	}

	private void addItemsPanels() {
		int insets_width_sides_button = 80 * JFrameMain.WIDTH_FRAME / 1920;
		int insets_width_sides = 20 * JFrameMain.WIDTH_FRAME / 1920;
		int insets_width_top = 16 * JFrameMain.HEIGHT_FRAME / 1080;
		int insets_width_top_button = 30 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets.top = 5 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.insets.left = insets_width_sides;
		gbc.insets.right = insets_width_sides;
		this.jPanelContainerM1.add(jLabelTitleM1, gbc);
		gbc.gridy = 1;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelNumberKM1, gbc);
		gbc.gridy = 2;
		gbc.insets.top = 0;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldNumberKM1, gbc);
		gbc.gridy = 3;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelNumberCM1, gbc);
		gbc.gridy = 4;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldNumberCM1, gbc);
		gbc.gridy = 5;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelNumberGM1, gbc);
		gbc.gridy = 6;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldNumberGM1, gbc);
		gbc.insets.top = insets_width_top_button;
		gbc.insets.left = insets_width_sides_button;
		gbc.insets.right = insets_width_sides_button;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		this.jPanelContainerM1.add(buttonGenerateM1, gbc);
		gbc.gridy = 8;
		gbc.weighty = 1;
		this.jPanelContainerM1.add(Box.createRigidArea(new Dimension(0,0)), gbc);

		gbc.weighty = 0;
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets.top = 5 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.insets.left = insets_width_sides;
		gbc.insets.right = insets_width_sides;
		gbc.gridy = 0;
		this.jPanelContainerM2.add(jLabelTitleM2, gbc);
		gbc.gridy = 1;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM2.add(jLabelNumberTM2, gbc);
		gbc.gridy = 2;
		gbc.insets.top = 0;
		this.jPanelContainerM2.add(jTextFieldNumberTM2, gbc);
		gbc.gridy = 3;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM2.add(jLabelNumberGM2, gbc);
		gbc.gridy = 4;
		gbc.insets.top = 0;
		this.jPanelContainerM2.add(jTextFieldNumberGM2, gbc);
		gbc.insets.top = insets_width_top_button;
		gbc.insets.left = insets_width_sides_button;
		gbc.insets.right = insets_width_sides_button;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		this.jPanelContainerM2.add(buttonGenerateM2, gbc);
		gbc.gridy = 6;
		gbc.weighty = 1;
		this.jPanelContainerM2.add(Box.createRigidArea(new Dimension(0,0)), gbc);
	}

	private void addItems() {
		this.jPanelContainer.add(jLabelTitle).setBounds(10, 15 * JFrameMain.HEIGHT_FRAME / 1080,
				300 * JFrameMain.WIDTH_FRAME / 1920, 80 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jButtonAccordionM1).setBounds(0, 105 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jButtonAccordionM2).setBounds(0, 145 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
	}

	private void configureButtonAccordion(JButton jButtonAccordion, String command) {
		jButtonAccordion.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jButtonAccordion.setForeground(Color.WHITE);
		jButtonAccordion.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
		jButtonAccordion.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE));
		jButtonAccordion.setFocusPainted(false);
		jButtonAccordion.addActionListener(JFrameMain.getInstance());
		jButtonAccordion.setActionCommand(command);
	}

	private void configureButton(JButton jButton, String actionCommand) {
		jButton.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jButton.setForeground(Color.WHITE);
		jButton.setFocusPainted(false);
		jButton.setContentAreaFilled(false);
		jButton.setBorder(new LineBorder(Color.WHITE));
		jButton.addActionListener(Controller.getInstance());
		jButton.setActionCommand(actionCommand);
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setBorder(new LineBorder(Color.ORANGE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setBorder(new LineBorder(Color.WHITE));
			}
		});
	}

	private void configureLabel(JLabel jLabel, int fontSize, int style) {
		jLabel.setFont(new Font(Constants.FONT_APP, style, fontSize));
		jLabel.setForeground(Color.WHITE);
	}

	private void configureTextField(JTextField jTextField, String placeholder) {
		jTextField.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jTextField.setBorder(new LineBorder(Color.WHITE));
		jTextField.setOpaque(false);
		jTextField.setForeground(Color.WHITE);
		jTextField.setPreferredSize(new Dimension(0, 30));
		TextPrompt textPrompt = new TextPrompt(placeholder, jTextField);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		InputMap map2 = jTextField.getInputMap(JTextField.WHEN_FOCUSED);
	    map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		jTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if ((int)e.getKeyChar() != 8 && (!Character.isDigit(e.getKeyChar()) || jTextField.getText().length() > 7)) {
					e.consume();
					return;
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(220, 10, 10, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void removeComponents() {
		for (int i = 0; i < this.jPanelContainer.getComponents().length; i++) {
			this.jPanelContainer.getComponent(i).setVisible(false);
		}
		this.jPanelContainer.removeAll();
	}
	
	public void moveAccordion(int index) {
		removeComponents();
		jButtonAccordionM1.setVisible(true);
		jButtonAccordionM2.setVisible(true);
		jLabelTitle.setVisible(true);
		this.jPanelContainer.add(jLabelTitle).setBounds(10, 15 * JFrameMain.HEIGHT_FRAME / 1080,
				300 * JFrameMain.WIDTH_FRAME / 1920, 80 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jButtonAccordionM1).setBounds(0, 105 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
		if (index == 0) {
			this.jPanelContainer.add(jPanelContainerM1).setBounds(0, 145 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 300 * JFrameMain.HEIGHT_FRAME / 1080);
			this.jPanelContainer.add(jButtonAccordionM2).setBounds(0, 450 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
			jPanelContainerM1.setVisible(true);
		}else {
			this.jPanelContainer.add(jButtonAccordionM2).setBounds(0, 145 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
			this.jPanelContainer.add(jPanelContainerM2).setBounds(0, 185 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 420 * JFrameMain.HEIGHT_FRAME / 1080);
			jPanelContainerM2.setVisible(true);
		}
	}
	
	public String getKM1() {
		return jTextFieldNumberKM1.getText();
	}

	public String getCM1() {
		return jTextFieldNumberCM1.getText();
	}

	public String getGM1() {
		return jTextFieldNumberGM1.getText();
	}

	public String getTM2() {
		return jTextFieldNumberTM2.getText();
	}

	public String getGM2() {
		return jTextFieldNumberGM2.getText();
	}

	public void highlightM2M1(int index, int option) {
		switch (index) {
		case 0:
			if (option == 0) {
				jTextFieldNumberKM1.setBorder(new LineBorder(Constants.COLOR_BORDER));
			}else {
				jTextFieldNumberKM1.setBorder(new LineBorder(Color.RED));
			}
			break;
		case 1:
			if (option == 0) {
				jTextFieldNumberCM1.setBorder(new LineBorder(Constants.COLOR_BORDER));
			}else {
				jTextFieldNumberCM1.setBorder(new LineBorder(Color.RED));
			}
			break;
		case 2:
			if (option == 0) {
				jTextFieldNumberGM1.setBorder(new LineBorder(Constants.COLOR_BORDER));
			}else {
				jTextFieldNumberGM1.setBorder(new LineBorder(Color.RED));
			}
			break;
		}
	}
	
	public void highlightM2M2(int index, int option) {
		switch (index) {
		case 0:
			if (option == 0) {
				jTextFieldNumberTM2.setBorder(new LineBorder(Constants.COLOR_BORDER));
			}else {
				jTextFieldNumberTM2.setBorder(new LineBorder(Color.RED));
			}
			break;
		case 1:
			if (option == 0) {
				jTextFieldNumberGM2.setBorder(new LineBorder(Constants.COLOR_BORDER));
			}else {
				jTextFieldNumberGM2.setBorder(new LineBorder(Color.RED));
			}
			break;
		}
	}
}
