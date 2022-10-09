package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import model.TextPrompt;
import view.utils.Constants;

public class JPanelLateralMethodFour extends JScrollPane {
	private JPanel jPanelContainer;
	private JLabel jLabelTitle;
	private JLabel jLabelMean;
	private JTextField jTextFieldMean;
	private JLabel jLabelSD;
	private JTextField jTextFieldSD;
	private JLabel jLabelOption;
	private JButton jButtonAccordionM1;
	private JButton jButtonAccordionM2;

	private JPanelLateralMethodOne jPanelLateralMethodOne;
	private JPanelLateralMethodTwo jPanelLateralMethodTwo;

	public JPanelLateralMethodFour() {
		super();
		this.jPanelContainer = new JPanel();
		this.jLabelTitle = new JLabel(Constants.ENTRIES, JLabel.CENTER);
		this.jLabelMean = new JLabel(Constants.MEAN);
		this.jLabelSD = new JLabel(Constants.SD);
		this.jLabelOption = new JLabel("<html><p style='text-align:jusify;'>" + Constants.TITLE_CONGR + "</p></html>");
		this.jButtonAccordionM1 = new JButton(Constants.METHOD_ONE);
		this.jButtonAccordionM2 = new JButton(Constants.METHOD_TWO);
		this.jTextFieldMean = new JTextField();
		this.jTextFieldSD = new JTextField();
		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setViewportView(jPanelContainer);
		this.getViewport().setOpaque(false);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.jPanelContainer.setPreferredSize(
				new Dimension(320 * JFrameMain.WIDTH_FRAME / 1920, 700 * JFrameMain.HEIGHT_FRAME / 1080));
		this.jPanelContainer.setLayout(null);
		this.jPanelContainer.setOpaque(false);

		configureLabel(jLabelTitle, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelMean, Constants.FONT_SIZE_APP_LABELS, Font.BOLD);
		configureLabel(jLabelSD, Constants.FONT_SIZE_APP_LABELS, Font.BOLD);
		configureLabel(jLabelOption, Constants.FONT_SIZE_APP_PLACEHOLDER, Font.PLAIN);

		configureTextField(jTextFieldMean, Constants.PLACEHOLDER_MEAN);
		configureTextField(jTextFieldSD, Constants.PLACEHOLDER_SD);

		configureButtonAccordion(jButtonAccordionM1, Constants.COMMAND_ACCORDION_NOR_M1);
		configureButtonAccordion(jButtonAccordionM2, Constants.COMMAND_ACCORDION_NOR_M2);

		addItems();
	}

	private void addItems() {
		this.jPanelContainer.add(jLabelTitle).setBounds(0, 10 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelMean).setBounds(20, 50 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jTextFieldMean).setBounds(20, 80 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelSD).setBounds(20, 120 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jTextFieldSD).setBounds(20, 150 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelOption).setBounds(20, 190 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 60 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jButtonAccordionM1).setBounds(0, 260 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jButtonAccordionM2).setBounds(0, 300 * JFrameMain.HEIGHT_FRAME / 1080,
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
				if ((int) e.getKeyChar() != 8
						&& (!Character.isDigit(e.getKeyChar()) || jTextField.getText().length() > 7)) {
					e.consume();
					return;
				}
			}
		});
	}

	public void moveAccordion(int index) {
		removeComponents();
		addDefault();
		if (index == 0) {
			jButtonAccordionM2.setVisible(true);
			this.jPanelLateralMethodOne = new JPanelLateralMethodOne(Constants.COMMAND_GENERATE_METHOD_ONE_NOR);
			this.jPanelContainer.add(jPanelLateralMethodOne).setBounds(0, 300 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 300 * JFrameMain.HEIGHT_FRAME / 1080);
			this.jPanelContainer.add(jButtonAccordionM2).setBounds(0, 605 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
			this.jPanelContainer.setPreferredSize(
					new Dimension(320 * JFrameMain.WIDTH_FRAME / 1920, 700 * JFrameMain.HEIGHT_FRAME / 1080));
			jPanelLateralMethodOne.updateUI();
		} else {
			this.jButtonAccordionM2.setVisible(true);
			this.jPanelLateralMethodTwo = new JPanelLateralMethodTwo(Constants.COMMAND_ACCORDION_NOR_C_M1,
					Constants.COMMAND_ACCORDION_NOR_C_M2, Constants.COMMAND_GENERATE_CONGR_N_M2,
					Constants.COMMAND_GENERATE_CONGR_N_M1);
			this.jPanelContainer.add(jButtonAccordionM2).setBounds(0, 300 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
			this.jPanelContainer.add(jPanelLateralMethodTwo).setBounds(0, 335 * JFrameMain.HEIGHT_FRAME / 1080,
					320 * JFrameMain.WIDTH_FRAME / 1920, 500 * JFrameMain.HEIGHT_FRAME / 1080);
			this.jPanelLateralMethodTwo.updateUI();
		}
	}

	private void addDefault() {
		jLabelTitle.setVisible(true);
		jLabelMean.setVisible(true);
		jTextFieldMean.setVisible(true);
		jLabelSD.setVisible(true);
		jTextFieldSD.setVisible(true);
		jLabelOption.setVisible(true);
		jButtonAccordionM1.setVisible(true);
		this.jPanelContainer.add(jLabelTitle).setBounds(0, 10 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelMean).setBounds(20, 50 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jTextFieldMean).setBounds(20, 80 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelSD).setBounds(20, 120 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jTextFieldSD).setBounds(20, 150 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 30 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelOption).setBounds(20, 190 * JFrameMain.HEIGHT_FRAME / 1080,
				280 * JFrameMain.WIDTH_FRAME / 1920, 60 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jButtonAccordionM1).setBounds(0, 260 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
	}

	public void removeComponents() {
		for (int i = 0; i < this.jPanelContainer.getComponents().length; i++) {
			this.jPanelContainer.getComponent(i).setVisible(false);
		}
		this.jPanelContainer.removeAll();
	}

	public void moveAccordionC(int index) {
		jPanelLateralMethodTwo.moveAccordion(index);
		this.jPanelContainer.setPreferredSize(
				new Dimension(320 * JFrameMain.WIDTH_FRAME / 1920, 900 * JFrameMain.HEIGHT_FRAME / 1080));
	}

	public String getMean() {
		return jTextFieldMean.getText();
	}

	public String getSD() {
		return jTextFieldSD.getText();
	}

	public String getSeedN() {
		return jPanelLateralMethodOne.getSeed();
	}

	public boolean getFillN() {
		return jPanelLateralMethodOne.getFill();
	}

	public String getKN() {
		return jPanelLateralMethodTwo.getKM1();
	}

	public String getCN() {
		return jPanelLateralMethodTwo.getCM1();
	}

	public String getGN1() {
		return jPanelLateralMethodTwo.getGM1();
	}

	public String getGN2() {
		return jPanelLateralMethodTwo.getGM2();
	}

	public String getTN() {
		return jPanelLateralMethodTwo.getTM2();
	}


}
